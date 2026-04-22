package com.demo.dtos;

import java.util.List;

public class Response {
    private boolean success;
    private String message;
    private AnalyticsData data;
    private List<AnalyticsData> dataList;

    public Response(boolean success, String message)
    {
        this.success = success;
        this.message = message;
    }

    public Response(boolean success, String message, AnalyticsData data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public Response(boolean success, String message, List<AnalyticsData> dataList) {
        this.success = success;
        this.message = message;
        this.dataList = dataList;
    }

    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public AnalyticsData getData() {
        return data;
    }
    public void setData(AnalyticsData data) {
        this.data = data;
    }
    public List<AnalyticsData> getDataList() {
        return dataList;
    }
    public void setDataList(List<AnalyticsData> dataList) {
        this.dataList = dataList;
    }
}
