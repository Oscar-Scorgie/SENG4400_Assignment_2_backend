package com.demo;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.demo.dtos.APIGatewayRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import com.demo.dtos.Request;
import com.demo.dtos.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class AuthHandler implements RequestHandler<APIGatewayRequest, Map<String, Object>> {

    @Override
    public Map<String, Object> handleRequest(APIGatewayRequest input, Context context) {
        ObjectMapper mapper = new ObjectMapper();
        Request request;
        try {
            request = mapper.readValue(input.getBody(), Request.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        // Look up email in db
        UserRepository userRepository = new UserRepository();
        Map<String, AttributeValue> item = userRepository.findByEmail(request.getEmail());

        if (item == null || item.isEmpty()) {
            return returnFunction("User not found", false, mapper);
        }

        // Check the password matches
        String password = item.get("password").s();

        if (Objects.equals(password, request.getPassword())) {
            String token = JWT.create()
                    .withSubject(request.getEmail())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 3600_000)) // 1 hour
                    .sign(Algorithm.HMAC256("your-secret-key"));

            return returnFunction("", true, mapper, token);

        }else{
            return returnFunction("Wrong password", false, mapper);
        }
    }

    private Map<String, Object> returnFunction(String message, boolean success, ObjectMapper mapper, String token){
        try {
            return Map.of(
                    "statusCode", 200,
                    "headers", Map.of(
                            "Content-Type", "application/json",
                            "Access-Control-Allow-Origin", "*"
                    ),
                    "body", mapper.writeValueAsString(new Response(success, message, token))
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, Object> returnFunction(String message, boolean success, ObjectMapper mapper){
        try {
            return Map.of(
                    "statusCode", 200,
                    "headers", Map.of(
                            "Content-Type", "application/json",
                            "Access-Control-Allow-Origin", "*"
                    ),
                    "body", mapper.writeValueAsString(new Response(success, message))
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}