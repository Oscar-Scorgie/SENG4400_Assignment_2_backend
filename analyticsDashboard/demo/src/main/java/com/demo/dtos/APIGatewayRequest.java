package com.demo.dtos;

import io.micronaut.serde.annotation.Serdeable;

import java.util.Map;

@Serdeable
public class APIGatewayRequest {
    private String body;
    private Map<String, String> queryStringParameters;

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public Map<String, String> getQueryStringParameters() { return queryStringParameters; }
    public void setQueryStringParameters(Map<String, String> queryStringParameters) {
        this.queryStringParameters = queryStringParameters;
    }
}