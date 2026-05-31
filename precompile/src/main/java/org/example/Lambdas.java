package org.example;

import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.apigateway.ApiGatewayClient;
import software.amazon.awssdk.services.apigateway.model.IntegrationType;
import software.amazon.awssdk.services.lambda.LambdaClient;
import software.amazon.awssdk.services.lambda.model.Runtime;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Lambdas {
    public static void main(URI url, StaticCredentialsProvider credentials, Region region) throws IOException {
        // Instantiate Lambda
        LambdaClient lambda = LambdaClient.builder()
                .endpointOverride(url)
                .credentialsProvider(credentials)
                .region(region)
                .build();

        createLambdas(lambda);

        // Instantitate

    }

    private static void createLambdas(LambdaClient lambda) throws IOException {

        // login
        lambda.createFunction(r -> r
                .functionName("login")
                .runtime(software.amazon.awssdk.services.lambda.model.Runtime.JAVA21)
                .handler("com.demo.AuthHandler::handleRequest")
                .role("arn:aws:iam::000000000000:role/lambda-role")
                .code(c -> {
                    try {
                        c.zipFile(SdkBytes.fromByteArray(
                                Files.readAllBytes(Paths.get("login/demo/build/libs/login-0.1.jar"))));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .timeout(30)
                .environment(e -> e.variables(Map.of(
                        "DYNAMODB_ENDPOINT", "http://172.17.0.2:4566")))
        );

        // analyticsDashboard
        lambda.createFunction(r -> r
                .functionName("analyticsDashboard")
                .runtime(software.amazon.awssdk.services.lambda.model.Runtime.JAVA21)
                .handler("com.demo.AnalyticsHandler::handleRequest")
                .role("arn:aws:iam::000000000000:role/lambda-role")
                .code(c -> {
                    try {
                        c.zipFile(SdkBytes.fromByteArray(
                                Files.readAllBytes(Paths.get("analyticsDashboard/demo/build/libs/analyticsDashboard-0.1.jar"))));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .timeout(30)
                .environment(e -> e.variables(Map.of(
                        "DYNAMODB_ENDPOINT", "http://172.17.0.2:4566")))
        );

        // transactions
        lambda.createFunction(r -> r
                .functionName("transactions")
                .runtime(Runtime.JAVA21)
                .handler("com.demo.TransactionHandler::handleRequest")
                .role("arn:aws:iam::000000000000:role/lambda-role")
                .code(c -> {
                    try {
                        c.zipFile(SdkBytes.fromByteArray(
                                Files.readAllBytes(Paths.get("transactions/demo/build/libs/transactions-0.1.jar"))));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .timeout(30)
                .environment(e -> e.variables(Map.of(
                        "DYNAMODB_ENDPOINT", "http://172.17.0.2:4566")))
        );
    }


}
