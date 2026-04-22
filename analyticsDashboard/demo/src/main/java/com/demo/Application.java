package com.demo;

import com.demo.dtos.Request;
import com.demo.dtos.Response;

public class Application {

    public static void main(String[] args) {
        AnalyticsHandler analyticsHandler = new AnalyticsHandler();
        Request request = new Request("2026-03-14");

        Response response = analyticsHandler.handleRequest(request, null);
        System.out.println("Success: " + response.isSuccess());
        System.out.println("Message: " + response.getMessage());
        System.out.println("Data: " + response.getData());

    }
}