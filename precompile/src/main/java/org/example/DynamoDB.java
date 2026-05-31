package org.example;

import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.net.URI;
import java.util.Map;

public class DynamoDB {
    public static void main(URI url, StaticCredentialsProvider credentials, Region region) {
        // Instantiate DynamoDB
        DynamoDbClient dynamo = DynamoDbClient.builder()
                .endpointOverride(url)
                .credentialsProvider(credentials)
                .region(region)
                .build();


        createAndSeedUserTable(dynamo);
        createAndSeedAnalyticsTable(dynamo);
        createAndSeedTransactionsTable(dynamo);
    }

    private static void seedUsers(DynamoDbClient dynamo){
        // Add Oscar
        dynamo.putItem(r -> r
                .tableName("Users")
                .item(Map.of(
                        "PK",          AttributeValue.builder().s("oscar@bank.com").build(),
                        "userId",      AttributeValue.builder().s("USER#oscar").build(),
                        "firstName",   AttributeValue.builder().s("Oscar").build(),
                        "lastName",    AttributeValue.builder().s("Scorgie").build(),
                        "password",    AttributeValue.builder().s("hashed_password_123").build(),
                        "dateCreated", AttributeValue.builder().s("2026-01-01").build(),
                        "timeCreated", AttributeValue.builder().s("09:00:00").build(),
                        "accounts",    AttributeValue.builder().s("ACC#001,ACC#002").build()
                ))
        );

        // Add Jane
        dynamo.putItem(r -> r
                .tableName("Users")
                .item(Map.of(
                        "PK",          AttributeValue.builder().s("jane@bank.com").build(),
                        "userId",      AttributeValue.builder().s("USER#jane").build(),
                        "firstName",   AttributeValue.builder().s("Jane").build(),
                        "lastName",    AttributeValue.builder().s("Doe").build(),
                        "password",    AttributeValue.builder().s("hashed_password_456").build(),
                        "dateCreated", AttributeValue.builder().s("2026-01-15").build(),
                        "timeCreated", AttributeValue.builder().s("10:30:00").build(),
                        "accounts",    AttributeValue.builder().s("ACC#003,ACC#004").build()
                ))
        );
    }



    private static void seedAnalytics(DynamoDbClient dynamo){
        // Week 1 - April 4-10
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-04").build(), "date", AttributeValue.builder().s("2026-04-04").build(), "totalLogins", AttributeValue.builder().n("38").build(), "totalTransactions", AttributeValue.builder().n("142").build(), "totalTransactionsAmount", AttributeValue.builder().n("48320.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-05").build(), "date", AttributeValue.builder().s("2026-04-05").build(), "totalLogins", AttributeValue.builder().n("45").build(), "totalTransactions", AttributeValue.builder().n("167").build(), "totalTransactionsAmount", AttributeValue.builder().n("61450.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-06").build(), "date", AttributeValue.builder().s("2026-04-06").build(), "totalLogins", AttributeValue.builder().n("29").build(), "totalTransactions", AttributeValue.builder().n("98").build(), "totalTransactionsAmount", AttributeValue.builder().n("34210.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-07").build(), "date", AttributeValue.builder().s("2026-04-07").build(), "totalLogins", AttributeValue.builder().n("52").build(), "totalTransactions", AttributeValue.builder().n("203").build(), "totalTransactionsAmount", AttributeValue.builder().n("78900.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-08").build(), "date", AttributeValue.builder().s("2026-04-08").build(), "totalLogins", AttributeValue.builder().n("41").build(), "totalTransactions", AttributeValue.builder().n("175").build(), "totalTransactionsAmount", AttributeValue.builder().n("59340.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-09").build(), "date", AttributeValue.builder().s("2026-04-09").build(), "totalLogins", AttributeValue.builder().n("36").build(), "totalTransactions", AttributeValue.builder().n("134").build(), "totalTransactionsAmount", AttributeValue.builder().n("43670.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-10").build(), "date", AttributeValue.builder().s("2026-04-10").build(), "totalLogins", AttributeValue.builder().n("42").build(), "totalTransactions", AttributeValue.builder().n("158").build(), "totalTransactionsAmount", AttributeValue.builder().n("52750.00").build())));

        // Week 2 - April 11-17
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-11").build(), "date", AttributeValue.builder().s("2026-04-11").build(), "totalLogins", AttributeValue.builder().n("55").build(), "totalTransactions", AttributeValue.builder().n("189").build(), "totalTransactionsAmount", AttributeValue.builder().n("67320.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-12").build(), "date", AttributeValue.builder().s("2026-04-12").build(), "totalLogins", AttributeValue.builder().n("48").build(), "totalTransactions", AttributeValue.builder().n("201").build(), "totalTransactionsAmount", AttributeValue.builder().n("71840.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-13").build(), "date", AttributeValue.builder().s("2026-04-13").build(), "totalLogins", AttributeValue.builder().n("33").build(), "totalTransactions", AttributeValue.builder().n("112").build(), "totalTransactionsAmount", AttributeValue.builder().n("38920.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-14").build(), "date", AttributeValue.builder().s("2026-04-14").build(), "totalLogins", AttributeValue.builder().n("61").build(), "totalTransactions", AttributeValue.builder().n("224").build(), "totalTransactionsAmount", AttributeValue.builder().n("89340.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-15").build(), "date", AttributeValue.builder().s("2026-04-15").build(), "totalLogins", AttributeValue.builder().n("44").build(), "totalTransactions", AttributeValue.builder().n("178").build(), "totalTransactionsAmount", AttributeValue.builder().n("63210.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-16").build(), "date", AttributeValue.builder().s("2026-04-16").build(), "totalLogins", AttributeValue.builder().n("39").build(), "totalTransactions", AttributeValue.builder().n("156").build(), "totalTransactionsAmount", AttributeValue.builder().n("54780.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-17").build(), "date", AttributeValue.builder().s("2026-04-17").build(), "totalLogins", AttributeValue.builder().n("57").build(), "totalTransactions", AttributeValue.builder().n("198").build(), "totalTransactionsAmount", AttributeValue.builder().n("74560.00").build())));

        // Week 3 - April 18-24
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-18").build(), "date", AttributeValue.builder().s("2026-04-18").build(), "totalLogins", AttributeValue.builder().n("62").build(), "totalTransactions", AttributeValue.builder().n("215").build(), "totalTransactionsAmount", AttributeValue.builder().n("82340.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-19").build(), "date", AttributeValue.builder().s("2026-04-19").build(), "totalLogins", AttributeValue.builder().n("47").build(), "totalTransactions", AttributeValue.builder().n("183").build(), "totalTransactionsAmount", AttributeValue.builder().n("65430.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-20").build(), "date", AttributeValue.builder().s("2026-04-20").build(), "totalLogins", AttributeValue.builder().n("35").build(), "totalTransactions", AttributeValue.builder().n("121").build(), "totalTransactionsAmount", AttributeValue.builder().n("41230.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-21").build(), "date", AttributeValue.builder().s("2026-04-21").build(), "totalLogins", AttributeValue.builder().n("58").build(), "totalTransactions", AttributeValue.builder().n("209").build(), "totalTransactionsAmount", AttributeValue.builder().n("79870.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-22").build(), "date", AttributeValue.builder().s("2026-04-22").build(), "totalLogins", AttributeValue.builder().n("43").build(), "totalTransactions", AttributeValue.builder().n("171").build(), "totalTransactionsAmount", AttributeValue.builder().n("58920.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-23").build(), "date", AttributeValue.builder().s("2026-04-23").build(), "totalLogins", AttributeValue.builder().n("37").build(), "totalTransactions", AttributeValue.builder().n("145").build(), "totalTransactionsAmount", AttributeValue.builder().n("49670.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-24").build(), "date", AttributeValue.builder().s("2026-04-24").build(), "totalLogins", AttributeValue.builder().n("66").build(), "totalTransactions", AttributeValue.builder().n("231").build(), "totalTransactionsAmount", AttributeValue.builder().n("93450.00").build())));

        // Week 4 - April 25 - May 1
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-25").build(), "date", AttributeValue.builder().s("2026-04-25").build(), "totalLogins", AttributeValue.builder().n("51").build(), "totalTransactions", AttributeValue.builder().n("192").build(), "totalTransactionsAmount", AttributeValue.builder().n("69870.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-26").build(), "date", AttributeValue.builder().s("2026-04-26").build(), "totalLogins", AttributeValue.builder().n("44").build(), "totalTransactions", AttributeValue.builder().n("168").build(), "totalTransactionsAmount", AttributeValue.builder().n("57340.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-27").build(), "date", AttributeValue.builder().s("2026-04-27").build(), "totalLogins", AttributeValue.builder().n("38").build(), "totalTransactions", AttributeValue.builder().n("139").build(), "totalTransactionsAmount", AttributeValue.builder().n("46120.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-28").build(), "date", AttributeValue.builder().s("2026-04-28").build(), "totalLogins", AttributeValue.builder().n("59").build(), "totalTransactions", AttributeValue.builder().n("217").build(), "totalTransactionsAmount", AttributeValue.builder().n("84560.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-29").build(), "date", AttributeValue.builder().s("2026-04-29").build(), "totalLogins", AttributeValue.builder().n("53").build(), "totalTransactions", AttributeValue.builder().n("196").build(), "totalTransactionsAmount", AttributeValue.builder().n("72340.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-04-30").build(), "date", AttributeValue.builder().s("2026-04-30").build(), "totalLogins", AttributeValue.builder().n("46").build(), "totalTransactions", AttributeValue.builder().n("174").build(), "totalTransactionsAmount", AttributeValue.builder().n("61780.00").build())));
        dynamo.putItem(r -> r.tableName("Analytics").item(Map.of("PK", AttributeValue.builder().s("2026-05-01").build(), "date", AttributeValue.builder().s("2026-05-01").build(), "totalLogins", AttributeValue.builder().n("64").build(), "totalTransactions", AttributeValue.builder().n("228").build(), "totalTransactionsAmount", AttributeValue.builder().n("91230.00").build())));
    }

    private static void seedTransactions(DynamoDbClient dynamo) {

        // April 27
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-27-001").build(), "date", AttributeValue.builder().s("2026-04-27").build(), "fromUserId", AttributeValue.builder().s("USER#oscar").build(), "toUserId", AttributeValue.builder().s("USER#jane").build(), "fromAccount", AttributeValue.builder().s("ACC#001").build(), "toAccount", AttributeValue.builder().s("ACC#003").build(), "amount", AttributeValue.builder().n("450.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-27-002").build(), "date", AttributeValue.builder().s("2026-04-27").build(), "fromUserId", AttributeValue.builder().s("USER#jane").build(), "toUserId", AttributeValue.builder().s("USER#oscar").build(), "fromAccount", AttributeValue.builder().s("ACC#003").build(), "toAccount", AttributeValue.builder().s("ACC#002").build(), "amount", AttributeValue.builder().n("320.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-27-003").build(), "date", AttributeValue.builder().s("2026-04-27").build(), "fromUserId", AttributeValue.builder().s("USER#oscar").build(), "toUserId", AttributeValue.builder().s("USER#jane").build(), "fromAccount", AttributeValue.builder().s("ACC#002").build(), "toAccount", AttributeValue.builder().s("ACC#004").build(), "amount", AttributeValue.builder().n("890.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-27-004").build(), "date", AttributeValue.builder().s("2026-04-27").build(), "fromUserId", AttributeValue.builder().s("USER#jane").build(), "toUserId", AttributeValue.builder().s("USER#oscar").build(), "fromAccount", AttributeValue.builder().s("ACC#004").build(), "toAccount", AttributeValue.builder().s("ACC#001").build(), "amount", AttributeValue.builder().n("215.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-27-005").build(), "date", AttributeValue.builder().s("2026-04-27").build(), "fromUserId", AttributeValue.builder().s("USER#oscar").build(), "toUserId", AttributeValue.builder().s("USER#jane").build(), "fromAccount", AttributeValue.builder().s("ACC#001").build(), "toAccount", AttributeValue.builder().s("ACC#003").build(), "amount", AttributeValue.builder().n("670.00").build())));

        // April 26
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-26-001").build(), "date", AttributeValue.builder().s("2026-04-26").build(), "fromUserId", AttributeValue.builder().s("USER#oscar").build(), "toUserId", AttributeValue.builder().s("USER#jane").build(), "fromAccount", AttributeValue.builder().s("ACC#001").build(), "toAccount", AttributeValue.builder().s("ACC#003").build(), "amount", AttributeValue.builder().n("780.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-26-002").build(), "date", AttributeValue.builder().s("2026-04-26").build(), "fromUserId", AttributeValue.builder().s("USER#jane").build(), "toUserId", AttributeValue.builder().s("USER#oscar").build(), "fromAccount", AttributeValue.builder().s("ACC#004").build(), "toAccount", AttributeValue.builder().s("ACC#002").build(), "amount", AttributeValue.builder().n("430.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-26-003").build(), "date", AttributeValue.builder().s("2026-04-26").build(), "fromUserId", AttributeValue.builder().s("USER#oscar").build(), "toUserId", AttributeValue.builder().s("USER#jane").build(), "fromAccount", AttributeValue.builder().s("ACC#002").build(), "toAccount", AttributeValue.builder().s("ACC#004").build(), "amount", AttributeValue.builder().n("920.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-26-004").build(), "date", AttributeValue.builder().s("2026-04-26").build(), "fromUserId", AttributeValue.builder().s("USER#jane").build(), "toUserId", AttributeValue.builder().s("USER#oscar").build(), "fromAccount", AttributeValue.builder().s("ACC#003").build(), "toAccount", AttributeValue.builder().s("ACC#001").build(), "amount", AttributeValue.builder().n("340.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-26-005").build(), "date", AttributeValue.builder().s("2026-04-26").build(), "fromUserId", AttributeValue.builder().s("USER#oscar").build(), "toUserId", AttributeValue.builder().s("USER#jane").build(), "fromAccount", AttributeValue.builder().s("ACC#001").build(), "toAccount", AttributeValue.builder().s("ACC#003").build(), "amount", AttributeValue.builder().n("560.00").build())));

        // April 25
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-25-001").build(), "date", AttributeValue.builder().s("2026-04-25").build(), "fromUserId", AttributeValue.builder().s("USER#oscar").build(), "toUserId", AttributeValue.builder().s("USER#jane").build(), "fromAccount", AttributeValue.builder().s("ACC#001").build(), "toAccount", AttributeValue.builder().s("ACC#003").build(), "amount", AttributeValue.builder().n("1200.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-25-002").build(), "date", AttributeValue.builder().s("2026-04-25").build(), "fromUserId", AttributeValue.builder().s("USER#jane").build(), "toUserId", AttributeValue.builder().s("USER#oscar").build(), "fromAccount", AttributeValue.builder().s("ACC#004").build(), "toAccount", AttributeValue.builder().s("ACC#002").build(), "amount", AttributeValue.builder().n("875.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-25-003").build(), "date", AttributeValue.builder().s("2026-04-25").build(), "fromUserId", AttributeValue.builder().s("USER#oscar").build(), "toUserId", AttributeValue.builder().s("USER#jane").build(), "fromAccount", AttributeValue.builder().s("ACC#002").build(), "toAccount", AttributeValue.builder().s("ACC#004").build(), "amount", AttributeValue.builder().n("430.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-25-004").build(), "date", AttributeValue.builder().s("2026-04-25").build(), "fromUserId", AttributeValue.builder().s("USER#jane").build(), "toUserId", AttributeValue.builder().s("USER#oscar").build(), "fromAccount", AttributeValue.builder().s("ACC#003").build(), "toAccount", AttributeValue.builder().s("ACC#001").build(), "amount", AttributeValue.builder().n("690.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-25-005").build(), "date", AttributeValue.builder().s("2026-04-25").build(), "fromUserId", AttributeValue.builder().s("USER#oscar").build(), "toUserId", AttributeValue.builder().s("USER#jane").build(), "fromAccount", AttributeValue.builder().s("ACC#001").build(), "toAccount", AttributeValue.builder().s("ACC#003").build(), "amount", AttributeValue.builder().n("950.00").build())));

        // April 24
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-24-001").build(), "date", AttributeValue.builder().s("2026-04-24").build(), "fromUserId", AttributeValue.builder().s("USER#oscar").build(), "toUserId", AttributeValue.builder().s("USER#jane").build(), "fromAccount", AttributeValue.builder().s("ACC#001").build(), "toAccount", AttributeValue.builder().s("ACC#003").build(), "amount", AttributeValue.builder().n("540.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-24-002").build(), "date", AttributeValue.builder().s("2026-04-24").build(), "fromUserId", AttributeValue.builder().s("USER#jane").build(), "toUserId", AttributeValue.builder().s("USER#oscar").build(), "fromAccount", AttributeValue.builder().s("ACC#004").build(), "toAccount", AttributeValue.builder().s("ACC#002").build(), "amount", AttributeValue.builder().n("1100.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-24-003").build(), "date", AttributeValue.builder().s("2026-04-24").build(), "fromUserId", AttributeValue.builder().s("USER#oscar").build(), "toUserId", AttributeValue.builder().s("USER#jane").build(), "fromAccount", AttributeValue.builder().s("ACC#002").build(), "toAccount", AttributeValue.builder().s("ACC#004").build(), "amount", AttributeValue.builder().n("760.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-24-004").build(), "date", AttributeValue.builder().s("2026-04-24").build(), "fromUserId", AttributeValue.builder().s("USER#jane").build(), "toUserId", AttributeValue.builder().s("USER#oscar").build(), "fromAccount", AttributeValue.builder().s("ACC#003").build(), "toAccount", AttributeValue.builder().s("ACC#001").build(), "amount", AttributeValue.builder().n("380.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-24-005").build(), "date", AttributeValue.builder().s("2026-04-24").build(), "fromUserId", AttributeValue.builder().s("USER#oscar").build(), "toUserId", AttributeValue.builder().s("USER#jane").build(), "fromAccount", AttributeValue.builder().s("ACC#001").build(), "toAccount", AttributeValue.builder().s("ACC#003").build(), "amount", AttributeValue.builder().n("920.00").build())));

        // April 23
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-23-001").build(), "date", AttributeValue.builder().s("2026-04-23").build(), "fromUserId", AttributeValue.builder().s("USER#jane").build(), "toUserId", AttributeValue.builder().s("USER#oscar").build(), "fromAccount", AttributeValue.builder().s("ACC#003").build(), "toAccount", AttributeValue.builder().s("ACC#002").build(), "amount", AttributeValue.builder().n("410.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-23-002").build(), "date", AttributeValue.builder().s("2026-04-23").build(), "fromUserId", AttributeValue.builder().s("USER#oscar").build(), "toUserId", AttributeValue.builder().s("USER#jane").build(), "fromAccount", AttributeValue.builder().s("ACC#002").build(), "toAccount", AttributeValue.builder().s("ACC#004").build(), "amount", AttributeValue.builder().n("630.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-23-003").build(), "date", AttributeValue.builder().s("2026-04-23").build(), "fromUserId", AttributeValue.builder().s("USER#jane").build(), "toUserId", AttributeValue.builder().s("USER#oscar").build(), "fromAccount", AttributeValue.builder().s("ACC#004").build(), "toAccount", AttributeValue.builder().s("ACC#001").build(), "amount", AttributeValue.builder().n("280.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-23-004").build(), "date", AttributeValue.builder().s("2026-04-23").build(), "fromUserId", AttributeValue.builder().s("USER#oscar").build(), "toUserId", AttributeValue.builder().s("USER#jane").build(), "fromAccount", AttributeValue.builder().s("ACC#001").build(), "toAccount", AttributeValue.builder().s("ACC#003").build(), "amount", AttributeValue.builder().n("750.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-23-005").build(), "date", AttributeValue.builder().s("2026-04-23").build(), "fromUserId", AttributeValue.builder().s("USER#jane").build(), "toUserId", AttributeValue.builder().s("USER#oscar").build(), "fromAccount", AttributeValue.builder().s("ACC#003").build(), "toAccount", AttributeValue.builder().s("ACC#002").build(), "amount", AttributeValue.builder().n("490.00").build())));

        // April 22
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-22-001").build(), "date", AttributeValue.builder().s("2026-04-22").build(), "fromUserId", AttributeValue.builder().s("USER#oscar").build(), "toUserId", AttributeValue.builder().s("USER#jane").build(), "fromAccount", AttributeValue.builder().s("ACC#001").build(), "toAccount", AttributeValue.builder().s("ACC#004").build(), "amount", AttributeValue.builder().n("870.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-22-002").build(), "date", AttributeValue.builder().s("2026-04-22").build(), "fromUserId", AttributeValue.builder().s("USER#jane").build(), "toUserId", AttributeValue.builder().s("USER#oscar").build(), "fromAccount", AttributeValue.builder().s("ACC#004").build(), "toAccount", AttributeValue.builder().s("ACC#002").build(), "amount", AttributeValue.builder().n("320.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-22-003").build(), "date", AttributeValue.builder().s("2026-04-22").build(), "fromUserId", AttributeValue.builder().s("USER#oscar").build(), "toUserId", AttributeValue.builder().s("USER#jane").build(), "fromAccount", AttributeValue.builder().s("ACC#002").build(), "toAccount", AttributeValue.builder().s("ACC#003").build(), "amount", AttributeValue.builder().n("1050.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-22-004").build(), "date", AttributeValue.builder().s("2026-04-22").build(), "fromUserId", AttributeValue.builder().s("USER#jane").build(), "toUserId", AttributeValue.builder().s("USER#oscar").build(), "fromAccount", AttributeValue.builder().s("ACC#003").build(), "toAccount", AttributeValue.builder().s("ACC#001").build(), "amount", AttributeValue.builder().n("460.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-22-005").build(), "date", AttributeValue.builder().s("2026-04-22").build(), "fromUserId", AttributeValue.builder().s("USER#oscar").build(), "toUserId", AttributeValue.builder().s("USER#jane").build(), "fromAccount", AttributeValue.builder().s("ACC#001").build(), "toAccount", AttributeValue.builder().s("ACC#003").build(), "amount", AttributeValue.builder().n("730.00").build())));

        // April 21
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-21-001").build(), "date", AttributeValue.builder().s("2026-04-21").build(), "fromUserId", AttributeValue.builder().s("USER#jane").build(), "toUserId", AttributeValue.builder().s("USER#oscar").build(), "fromAccount", AttributeValue.builder().s("ACC#004").build(), "toAccount", AttributeValue.builder().s("ACC#001").build(), "amount", AttributeValue.builder().n("550.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-21-002").build(), "date", AttributeValue.builder().s("2026-04-21").build(), "fromUserId", AttributeValue.builder().s("USER#oscar").build(), "toUserId", AttributeValue.builder().s("USER#jane").build(), "fromAccount", AttributeValue.builder().s("ACC#002").build(), "toAccount", AttributeValue.builder().s("ACC#003").build(), "amount", AttributeValue.builder().n("980.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-21-003").build(), "date", AttributeValue.builder().s("2026-04-21").build(), "fromUserId", AttributeValue.builder().s("USER#jane").build(), "toUserId", AttributeValue.builder().s("USER#oscar").build(), "fromAccount", AttributeValue.builder().s("ACC#003").build(), "toAccount", AttributeValue.builder().s("ACC#002").build(), "amount", AttributeValue.builder().n("340.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-21-004").build(), "date", AttributeValue.builder().s("2026-04-21").build(), "fromUserId", AttributeValue.builder().s("USER#oscar").build(), "toUserId", AttributeValue.builder().s("USER#jane").build(), "fromAccount", AttributeValue.builder().s("ACC#001").build(), "toAccount", AttributeValue.builder().s("ACC#004").build(), "amount", AttributeValue.builder().n("810.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-21-005").build(), "date", AttributeValue.builder().s("2026-04-21").build(), "fromUserId", AttributeValue.builder().s("USER#jane").build(), "toUserId", AttributeValue.builder().s("USER#oscar").build(), "fromAccount", AttributeValue.builder().s("ACC#004").build(), "toAccount", AttributeValue.builder().s("ACC#002").build(), "amount", AttributeValue.builder().n("620.00").build())));

        // April 20
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-20-001").build(), "date", AttributeValue.builder().s("2026-04-20").build(), "fromUserId", AttributeValue.builder().s("USER#oscar").build(), "toUserId", AttributeValue.builder().s("USER#jane").build(), "fromAccount", AttributeValue.builder().s("ACC#001").build(), "toAccount", AttributeValue.builder().s("ACC#003").build(), "amount", AttributeValue.builder().n("470.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-20-002").build(), "date", AttributeValue.builder().s("2026-04-20").build(), "fromUserId", AttributeValue.builder().s("USER#jane").build(), "toUserId", AttributeValue.builder().s("USER#oscar").build(), "fromAccount", AttributeValue.builder().s("ACC#003").build(), "toAccount", AttributeValue.builder().s("ACC#001").build(), "amount", AttributeValue.builder().n("890.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-20-003").build(), "date", AttributeValue.builder().s("2026-04-20").build(), "fromUserId", AttributeValue.builder().s("USER#oscar").build(), "toUserId", AttributeValue.builder().s("USER#jane").build(), "fromAccount", AttributeValue.builder().s("ACC#002").build(), "toAccount", AttributeValue.builder().s("ACC#004").build(), "amount", AttributeValue.builder().n("310.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-20-004").build(), "date", AttributeValue.builder().s("2026-04-20").build(), "fromUserId", AttributeValue.builder().s("USER#jane").build(), "toUserId", AttributeValue.builder().s("USER#oscar").build(), "fromAccount", AttributeValue.builder().s("ACC#004").build(), "toAccount", AttributeValue.builder().s("ACC#002").build(), "amount", AttributeValue.builder().n("650.00").build())));
        dynamo.putItem(r -> r.tableName("Transactions").item(Map.of("PK", AttributeValue.builder().s("2026-04-20-005").build(), "date", AttributeValue.builder().s("2026-04-20").build(), "fromUserId", AttributeValue.builder().s("USER#oscar").build(), "toUserId", AttributeValue.builder().s("USER#jane").build(), "fromAccount", AttributeValue.builder().s("ACC#001").build(), "toAccount", AttributeValue.builder().s("ACC#003").build(), "amount", AttributeValue.builder().n("520.00").build())));
    }
    private static void createAndSeedUserTable(DynamoDbClient dynamo) {
        // Create user table
        dynamo.createTable(r -> r
                .tableName("Users")
                .attributeDefinitions(AttributeDefinition.builder()
                        .attributeName("PK")
                        .attributeType(ScalarAttributeType.S)
                        .build())
                .keySchema(KeySchemaElement.builder()
                        .attributeName("PK")
                        .keyType(KeyType.HASH)
                        .build())
                .billingMode(BillingMode.PAY_PER_REQUEST)
                .build());

        seedUsers(dynamo);
    }

    private static void createAndSeedAnalyticsTable(DynamoDbClient dynamo) {
        // Create analytics table
        dynamo.createTable(r -> r
                .tableName("Analytics")
                .attributeDefinitions(AttributeDefinition.builder()
                        .attributeName("PK")
                        .attributeType(ScalarAttributeType.S)
                        .build())
                .keySchema(KeySchemaElement.builder()
                        .attributeName("PK")
                        .keyType(KeyType.HASH)
                        .build())
                .billingMode(BillingMode.PAY_PER_REQUEST)
                .build());

        seedAnalytics(dynamo);
    }

    private static void createAndSeedTransactionsTable(DynamoDbClient dynamo) {
        // Create Transaction table
        dynamo.createTable(r -> r
                .tableName("Transactions")
                .attributeDefinitions(AttributeDefinition.builder()
                        .attributeName("PK")
                        .attributeType(ScalarAttributeType.S)
                        .build())
                .keySchema(KeySchemaElement.builder()
                        .attributeName("PK")
                        .keyType(KeyType.HASH)
                        .build())
                .billingMode(BillingMode.PAY_PER_REQUEST)
                .build());

        seedTransactions(dynamo);
    }
}
