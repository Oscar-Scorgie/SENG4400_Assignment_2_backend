package org.example;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;

import java.io.IOException;
import java.net.URI;


public class LocalStackCompile {
    public static void main(String[] args) throws IOException {
        StaticCredentialsProvider credentials = StaticCredentialsProvider.create(AwsBasicCredentials.create("test", "test"));
        URI url = URI.create("http://localhost:4566");
        Region region = Region.US_EAST_1;

        DynamoDB.main(url, credentials, region);

        Lambdas.main(url, credentials, region);

        ApiGateway.main(url, credentials, region);
    }






}