package com.demo;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.demo.dtos.APIGatewayRequest;
import com.demo.dtos.AnalyticsData;
import com.fasterxml.jackson.core.JsonProcessingException;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import com.demo.dtos.Request;
import com.demo.dtos.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnalyticsHandler implements RequestHandler<APIGatewayRequest, Map<String, Object>> {

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

        // Look up date in db
        AnalyticsRepository analyticsRepository = new AnalyticsRepository();
        Map<String, AttributeValue> item = analyticsRepository.findByDate(date);

        if (item == null || item.isEmpty()) {
            message = "Date not found";
            return new Response(false, message);
        }

        AnalyticsData data = new AnalyticsData(
                item.get("date").s(),
                Integer.parseInt(item.get("totalTransactions").n()),
                Double.parseDouble(item.get("totalTransactionsAmount").n()),
                Integer.parseInt(item.get("totalLogins").n())
        );

        return new Response(true, message, data);
    }

    private Response handleDateRange(String startDate, String endDate) {
        String message = "";

        if (startDate.compareTo(endDate) > 0) {
            return new Response(false, "Start date cannot be after end date");
        }

        // Look up date in db
        AnalyticsRepository analyticsRepository = new AnalyticsRepository();
        List<Map<String, AttributeValue>> items = analyticsRepository.findByDateRange(startDate, endDate);

        if (items == null || items.isEmpty()) {
            message = "Dates not found";
            return new Response(false, message);
        }

        List<AnalyticsData> list = new ArrayList<>();
        for (Map<String, AttributeValue> item : items) {
            list.add(new AnalyticsData(
                    item.get("date").s(),
                    Integer.parseInt(item.get("totalTransactions").n()),
                    Double.parseDouble(item.get("totalTransactionsAmount").n()),
                    Integer.parseInt(item.get("totalLogins").n())));
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