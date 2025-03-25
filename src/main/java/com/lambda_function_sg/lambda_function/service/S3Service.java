package com.lambda_function_sg.lambda_function.service;


import java.io.InputStream;
import java.net.URL;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
 
@Service
@RequiredArgsConstructor
public class S3Service {

    private final S3Client s3Client;

    public void uploadImageFromUrl(String bucketName, String key, String imageUrl) {

        try (InputStream inputStream = new URL(imageUrl).openStream()) {
            PutObjectRequest request = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .acl("public-read") // Make public
                    .contentType("image/jpeg")
                    .build();

            s3Client.putObject(request, RequestBody.fromInputStream(inputStream, inputStream.available()));
        } catch (Exception e) {
            throw new RuntimeException("Failed to upload image", e);
        }
    }
}