package com.demo.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransData {
    private String pk;
    private String date;
    private String fromUserId;
    private String toUserId;
    private String fromAccount;
    private String toAccount;
    private double amount;

    public TransData() {}

    public TransData(String pk, String date, String fromUserId, String toUserId, String fromAccount, String toAccount, double amount) {
        this.pk = pk;
        this.date = date;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    public String getPk() { return pk; }
    public String getDate() { return date; }
    public String getFromUserId() { return fromUserId; }
    public String getToUserId() { return toUserId; }
    public String getFromAccount() { return fromAccount; }
    public String getToAccount() { return toAccount; }
    public double getAmount() { return amount; }
}