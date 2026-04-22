package com.demo.dtos;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class Request {
    String date;
    String startDate;
    String endDate;


    public Request(String date) {
        this.date = date;
    }

    public Request(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
