package com.demo;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.demo.dtos.APIGatewayRequest;
import com.demo.dtos.TransData;
import com.fasterxml.jackson.core.JsonProcessingException;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import com.demo.dtos.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransactionHandler implements RequestHandler<APIGatewayRequest, Map<String, Object>> {

    @Override
    public Map<String, Object> handleRequest(APIGatewayRequest input, Context context) {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, String> params = input.getQueryStringParameters();

        String startDate = params != null ? params.get("startDate") : null;
        String endDate = params != null ? params.get("endDate") : null;
        String date = params != null ? params.get("date") : null;

        if (startDate != null && endDate != null) {
            return returnFunction(handleDateRange(startDate, endDate), mapper);
        } else if (date != null) {
            return returnFunction(handleSingleDate(date), mapper);
        } else {
            return returnFunction(new Response(false, "No date provided"), mapper);
        }
    }

    private Response handleSingleDate(String date) {
        String message = "";

        TransRepository transRepository = new TransRepository();
        List<Map<String, AttributeValue>> items = transRepository.findByDate(date);

        if (items == null || items.isEmpty()) {
            message = "Date not found";
            return new Response(false, message);
        }

        List<TransData> list = new ArrayList<>();
        for (Map<String, AttributeValue> item : items) {
            list.add(new TransData(
                    item.get("PK").s(),
                    item.get("date").s(),
                    item.get("fromUserId").s(),
                    item.get("toUserId").s(),
                    item.get("fromAccount").s(),
                    item.get("toAccount").s(),
                    Double.parseDouble(item.get("amount").n())
            ));
        }

        return new Response(true, message, list);
    }

    private Response handleDateRange(String startDate, String endDate) {
        String message = "";

        if (startDate.compareTo(endDate) > 0) {
            return new Response(false, "Start date cannot be after end date");
        }

        TransRepository transRepository = new TransRepository();
        List<Map<String, AttributeValue>> items = new ArrayList<>(transRepository.findByDateRange(startDate, endDate));

        if (items == null || items.isEmpty()) {
            message = "Dates not found";
            return new Response(false, message);
        }

        List<Map<String, AttributeValue>> items2 = new ArrayList<>(transRepository.findByDateRange(startDate, endDate));
        items2.sort((a, b) -> a.get("date").s().compareTo(b.get("date").s()));

        List<TransData> list = new ArrayList<>();
        for (Map<String, AttributeValue> item : items2) {
            list.add(new TransData(
                    item.get("PK").s(),
                    item.get("date").s(),
                    item.get("fromUserId").s(),
                    item.get("toUserId").s(),
                    item.get("fromAccount").s(),
                    item.get("toAccount").s(),
                    Double.parseDouble(item.get("amount").n())
            ));
        }

        return new Response(true, message, list);
    }

    private Map<String, Object> returnFunction(Response response, ObjectMapper mapper){
        try {
            return Map.of(
                    "statusCode", 200,
                    "headers", Map.of(
                            "Content-Type", "application/json",
                            "Access-Control-Allow-Origin", "*"
                    ),
                    "body", mapper.writeValueAsString(response)
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}