package org.example;

import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.apigateway.ApiGatewayClient;
import software.amazon.awssdk.services.apigateway.model.IntegrationType;

import java.net.URI;

public class ApiGateway {
    public static void main(URI url, StaticCredentialsProvider credentials, Region region) {
        ApiGatewayClient apiGateway = ApiGatewayClient.builder()
                .endpointOverride(url)
                .credentialsProvider(credentials)
                .region(region)
                .build();

        createAndDeployApiGateways(apiGateway);
    }

    private static void createAndDeployApiGateways(ApiGatewayClient apiGateway) {
        // Create REST API
        String apiId = apiGateway.createRestApi(r -> r
                        .name("banking-api"))
                .id();

        // Get root resource ID
        String rootId = apiGateway.getResources(r -> r
                        .restApiId(apiId))
                .items().get(0).id();

        // Login
        String loginId = apiGateway.createResource(r -> r
                        .restApiId(apiId)
                        .parentId(rootId)
                        .pathPart("login"))
                .id();

        apiGateway.putMethod(r -> r
                .restApiId(apiId)
                .resourceId(loginId)
                .httpMethod("POST")
                .authorizationType("NONE"));

        apiGateway.putIntegration(r -> r
                .restApiId(apiId)
                .resourceId(loginId)
                .httpMethod("POST")
                .type(IntegrationType.AWS_PROXY)
                .integrationHttpMethod("POST")
                .uri("arn:aws:apigateway:us-east-1:lambda:path/2015-03-31/functions/arn:aws:lambda:us-east-1:000000000000:function:login/invocations"));

        // Analytics
        String analyticsId = apiGateway.createResource(r -> r
                        .restApiId(apiId)
                        .parentId(rootId)
                        .pathPart("analytics"))
                .id();

        apiGateway.putMethod(r -> r
                .restApiId(apiId)
                .resourceId(analyticsId)
                .httpMethod("GET")
                .authorizationType("NONE"));

        apiGateway.putIntegration(r -> r
                .restApiId(apiId)
                .resourceId(analyticsId)
                .httpMethod("GET")
                .type(IntegrationType.AWS_PROXY)
                .integrationHttpMethod("POST")
                .uri("arn:aws:apigateway:us-east-1:lambda:path/2015-03-31/functions/arn:aws:lambda:us-east-1:000000000000:function:analyticsDashboard/invocations"));

        // Transactions
        String transactionsId = apiGateway.createResource(r -> r
                        .restApiId(apiId)
                        .parentId(rootId)
                        .pathPart("transactions"))
                .id();

        apiGateway.putMethod(r -> r
                .restApiId(apiId)
                .resourceId(transactionsId)
                .httpMethod("GET")
                .authorizationType("NONE"));

        apiGateway.putIntegration(r -> r
                .restApiId(apiId)
                .resourceId(transactionsId)
                .httpMethod("GET")
                .type(IntegrationType.AWS_PROXY)
                .integrationHttpMethod("POST")
                .uri("arn:aws:apigateway:us-east-1:lambda:path/2015-03-31/functions/arn:aws:lambda:us-east-1:000000000000:function:transactions/invocations"));

        // Deploy
        apiGateway.createDeployment(r -> r
                .restApiId(apiId)
                .stageName("local"));

        System.out.println("API_ID: " + apiId);
    }
}
