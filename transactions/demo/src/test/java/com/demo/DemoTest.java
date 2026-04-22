package com.demo;


import com.demo.dtos.Request;
import com.demo.dtos.Response;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

@MicronautTest
class DemoTest {
    private static AuthHandler authHandler;

    @BeforeAll
    static void setUp() {
        authHandler = new AuthHandler();
    }

    @Test
    void testCannotFindUser() {
        Request request = new Request("osca@bank.com", "hashed_password_123");

        Response response = authHandler.handleRequest(request, null);
        Assertions.assertTrue(!response.isSuccess() && response.getMessage().equals("User not found"));
    }

    @Test
    void testIncorrectPassword() {
        Request request = new Request("oscar@bank.com", "hashed_password_1234");

        Response response = authHandler.handleRequest(request, null);
        Assertions.assertTrue(!response.isSuccess() && response.getMessage().equals("Wrong password"));
    }

    @Test
    void testSuccessfulLogin() {
        Request request = new Request("oscar@bank.com", "hashed_password_123");

        Response response = authHandler.handleRequest(request, null);
        Assertions.assertTrue(response.isSuccess() && response.getMessage().isEmpty());
    }

}
