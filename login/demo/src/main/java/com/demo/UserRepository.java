package com.demo;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;

import java.util.Map;

public class UserRepository {
    private final DynamoDbClient client = DynamoDbClientProvider.getClient();

    public Map<String, AttributeValue> findByEmail(String email) {
        GetItemRequest request = GetItemRequest.builder()
                .tableName("Users")
                .key(Map.of("PK", AttributeValue.fromS(email)))
                .build();

        GetItemResponse response = client.getItem(request);
        return response.item();
    }
}
