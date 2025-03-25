package com.lambda_function_sg.lambda_function.controller;

import com.lambda_function_sg.lambda_function.service.DynamoDbService;
import com.lambda_function_sg.lambda_function.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DynamoDbService dynamoDbService;
    private final S3Service s3Service;

    @GetMapping("/demo")
    public String demo() {
        // Put item in DynamoDB
        dynamoDbService.saveItem("SampleItems", "123", "Deepjyot");

        // Upload public image to S3
        String imageUrl = "https://via.placeholder.com/150";

        s3Service.uploadImageFromUrl("my-lambda-demo-bucket", "sample-image.jpg", imageUrl);

        return "Item added to DynamoDB and image uploaded to S3.";
    }
}
