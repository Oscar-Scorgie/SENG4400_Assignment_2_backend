package com.demo;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.List;
import java.util.Map;

public class AnalyticsRepository {
    private final DynamoDbClient client = DynamoDbClientProvider.getClient();

    public Map<String, AttributeValue> findByDate(String date) {
        GetItemRequest request = GetItemRequest.builder()
                .tableName("Analytics")
                .key(Map.of("PK", AttributeValue.fromS(date)))
                .build();

        GetItemResponse response = client.getItem(request);
        return response.item();
    }

    public List<Map<String, AttributeValue>> findByDateRange(String startDate, String endDate) {
        ScanRequest request = ScanRequest.builder()
                .tableName("Analytics")
                .filterExpression("PK BETWEEN :start AND :end")
                .expressionAttributeValues(Map.of(
                        ":start", AttributeValue.fromS(startDate),
                        ":end", AttributeValue.fromS(endDate)
                ))
                .build();

        ScanResponse response = client.scan(request);
        return response.items();
    }
}
