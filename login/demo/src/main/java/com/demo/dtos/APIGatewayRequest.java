package com.demo.dtos;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class APIGatewayRequest {
    private String body;

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }
}