package com.demo;

import com.demo.dtos.Request;
import com.demo.dtos.Response;
import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        AuthHandler authHandler = new AuthHandler();
        Request request = new Request("oscar@bank.com", "hashed_password_123");

        Response response = authHandler.handleRequest(request, null);
        System.out.println("Success: " + response.isSuccess());
        System.out.println("Message: " + response.getMessage());

    }
}