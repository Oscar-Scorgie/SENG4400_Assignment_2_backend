package com.demo;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.List;
import java.util.Map;

public class TransRepository {
    private final DynamoDbClient client = DynamoDbClientProvider.getClient();

    public List<Map<String, AttributeValue>> findByDate(String date) {
        ScanRequest request = ScanRequest.builder()
                .tableName("Transactions")
                .filterExpression("#d = :date")
                .expressionAttributeNames(Map.of("#d", "date"))
                .expressionAttributeValues(Map.of(
                        ":date", AttributeValue.fromS(date)
                ))
                .build();

        ScanResponse response = client.scan(request);
        return response.items();
    }

    public List<Map<String, AttributeValue>> findByDateRange(String startDate, String endDate) {
        ScanRequest request = ScanRequest.builder()
                .tableName("Transactions")
                .filterExpression("#d BETWEEN :start AND :end")
                .expressionAttributeNames(Map.of("#d", "date"))
                .expressionAttributeValues(Map.of(
                        ":start", AttributeValue.fromS(startDate),
                        ":end", AttributeValue.fromS(endDate)
                ))
                .build();

        ScanResponse response = client.scan(request);
        return response.items();
    }
}
