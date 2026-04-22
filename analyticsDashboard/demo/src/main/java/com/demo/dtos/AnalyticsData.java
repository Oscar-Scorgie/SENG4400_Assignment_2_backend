package com.demo.dtos;

public class AnalyticsData {
    private String date;
    private int totalTransactions;
    private double totalTransactionsAmount;
    private int totalLogins;

    public AnalyticsData(String date, int totalTransactions, double totalTransactionsAmount, int totalLogins) {
        this.date = date;
        this.totalTransactions = totalTransactions;
        this.totalTransactionsAmount = totalTransactionsAmount;
        this.totalLogins = totalLogins;
    }
}
