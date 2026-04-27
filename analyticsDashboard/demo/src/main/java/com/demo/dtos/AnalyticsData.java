package com.demo.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnalyticsData {
    private String date;
    private int totalTransactions;
    private double totalTransactionsAmount;
    private int totalLogins;

    public AnalyticsData() {}

    public AnalyticsData(String date, int totalTransactions, double totalTransactionsAmount, int totalLogins) {
        this.date = date;
        this.totalTransactions = totalTransactions;
        this.totalTransactionsAmount = totalTransactionsAmount;
        this.totalLogins = totalLogins;
    }

    public String getDate() { return date; }
    public int getTotalTransactions() { return totalTransactions; }
    public double getTotalTransactionsAmount() { return totalTransactionsAmount; }
    public int getTotalLogins() { return totalLogins; }
}