package com.demo.dtos;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public class Response {
    private boolean success;
    private String message;
    private TransData data;
    private List<TransData> dataList;

    public Response(boolean success, String message)
    {
        this.success = success;
        this.message = message;
    }

    public Response(boolean success, String message, TransData data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public Response(boolean success, String message, List<TransData> dataList) {
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

    public TransData getData() {
        return data;
    }
    public void setData(TransData data) {
        this.data = data;
    }
    public List<TransData> getDataList() {
        return dataList;
    }
    public void setDataList(List<TransData> dataList) {
        this.dataList = dataList;
    }
}
