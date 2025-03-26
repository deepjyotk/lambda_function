package com.lambda_function_sg.lambda_function.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Value("${app.name}")
    private String appName;

    @Value("${app.environment}")
    private String environment;

    @Value("${dynamodb.table-name}")
    private String dynamoTableName;

    @Value("${s3.bucket-name}")
    private String s3BucketName;

    public String getAppName() {
        return appName;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getDynamoTableName() {
        return dynamoTableName;
    }

    public String getS3BucketName() {
        return s3BucketName;
    }
}
