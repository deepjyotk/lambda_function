package com.lambda_function_sg.lambda_function.controller;
import com.lambda_function_sg.lambda_function.config.ApplicationConfig;
import com.lambda_function_sg.lambda_function.service.DynamoDbService;
import com.lambda_function_sg.lambda_function.service.S3Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final DynamoDbService dynamoDbService;
    private final S3Service s3Service;
    private final ApplicationConfig applicationConfig;

    public DemoController(DynamoDbService dynamoDbService,
                          S3Service s3Service,
                          ApplicationConfig applicationConfig) {
        this.dynamoDbService = dynamoDbService;
        this.s3Service = s3Service;
        this.applicationConfig = applicationConfig;
    }


    @GetMapping("/demo")
    public String demo() {
        String tableName = applicationConfig.getDynamoTableName();
        String bucketName = applicationConfig.getS3BucketName();

        dynamoDbService.saveItem(tableName, "123", "Deepjyot");

        String imageUrl = "https://images.unsplash.com/photo-1506744038136-46273834b3fb";
        s3Service.uploadImageFromUrl(bucketName, "123", "sample-image.jpg", imageUrl);

        return String.format(
                "Item added to table [%s] in [%s] environment and image uploaded to bucket [%s].",
                tableName,
                applicationConfig.getEnvironment(),
                bucketName
        );
    }
}
