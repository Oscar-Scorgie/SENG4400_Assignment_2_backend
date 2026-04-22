package com.demo;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.demo.dtos.AnalyticsData;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import com.demo.dtos.Request;
import com.demo.dtos.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AnalyticsHandler implements RequestHandler<Request, Response> {

    @Override
    public Response handleRequest(Request input, Context context) {
        if (input.getStartDate() != null && input.getEndDate() != null) {
            return handleDateRange(input.getStartDate(), input.getEndDate());
        }else{
            return handleSingleDate(input.getDate());
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
}