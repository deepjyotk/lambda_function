package com.lambda_function_sg.lambda_function.config;


import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecretConfig {

    private final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

    public String getAwsSecretKey() {
        return dotenv.get("AWS_SECRET_KEY");
    }

    public String getAwsAccessKey() {
        return dotenv.get("AWS_ACCESS_KEY");
    }

    public String getDbPassword() {
        return dotenv.get("DB_PASSWORD");
    }
}
