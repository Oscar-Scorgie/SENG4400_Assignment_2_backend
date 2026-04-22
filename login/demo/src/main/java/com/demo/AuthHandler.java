package com.demo;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import com.demo.dtos.Request;
import com.demo.dtos.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AuthHandler implements RequestHandler<Request, Response> {

    @Override
    public Response handleRequest(Request input, Context context) {
        String message = "";

        // Look up email in db
        UserRepository userRepository = new UserRepository();
        Map<String, AttributeValue> item = userRepository.findByEmail(input.getEmail());

        if (item == null || item.isEmpty()) {
            message = "User not found";
            return new Response(false, message);
        }

        // Check the password matches
        String password = item.get("password").s();

        if (!Objects.equals(password, input.getPassword())) {
            message = "Wrong password";
            return new Response(false, message);
        }

        return new Response(true, message);
    }
}