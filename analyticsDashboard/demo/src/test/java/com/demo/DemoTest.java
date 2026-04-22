package com.demo;


import com.demo.dtos.Request;
import com.demo.dtos.Response;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

@MicronautTest
class DemoTest {
    private static AnalyticsHandler analyticsHandler;

    @BeforeAll
    static void setUp() {
        analyticsHandler = new AnalyticsHandler();
    }

    @Test
    void testCannotFindDate() {
        Request request = new Request("2026-03-14");

        Response response = analyticsHandler.handleRequest(request, null);
        Assertions.assertTrue(!response.isSuccess() && response.getMessage().equals("Date not found"));
    }

    @Test
    void testFoundDate() {
        Request request = new Request("2026-04-14");

        Response response = analyticsHandler.handleRequest(request, null);
        Assertions.assertTrue(response.isSuccess() && response.getMessage().isEmpty() && response.getData() != null);
    }

    @Test
    void testDatesBackwards() {
        Request request = new Request("2026-03-14", "2026-02-14");

        Response response = analyticsHandler.handleRequest(request, null);
        Assertions.assertTrue(!response.isSuccess() && response.getMessage().equals("Start date cannot be after end date"));
    }

    @Test
    void testOutOfRange() {
        Request request = new Request("2026-01-14", "2026-02-14");

        Response response = analyticsHandler.handleRequest(request, null);
        Assertions.assertTrue(!response.isSuccess() && response.getMessage().equals("Dates not found"));
    }

    @Test
    void testFoundPartialRange() {
        Request request = new Request("2026-03-14", "2026-04-14");

        Response response = analyticsHandler.handleRequest(request, null);
        Assertions.assertTrue(response.isSuccess() && response.getMessage().isEmpty() && !response.getDataList().isEmpty());
    }

    @Test
    void testFoundRange() {
        Request request = new Request("2026-04-14", "2026-04-15");

        Response response = analyticsHandler.handleRequest(request, null);
        Assertions.assertTrue(response.isSuccess() && response.getMessage().isEmpty() && !response.getDataList().isEmpty());
    }

}
