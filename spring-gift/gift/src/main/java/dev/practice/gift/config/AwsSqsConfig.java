package dev.practice.gift.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AwsSqsConfig {
//    @Value("${spring.cloud.aws.credentials.access-key}")
//    private String awsAccessKey;
//
//    @Value("${spring.cloud.aws.credentials.secret-key}")
//    private String awsSecretKey;

//    @Bean
//    public AmazonSQSAsync amazonSQSAsync() {
//        AWSCredentialsProvider awsCredentialsProvider = new AWSStaticCredentialsProvider(
//                new BasicAWSCredentials(awsAccessKey, awsSecretKey)
//        );
//
//        return AmazonSQSAsyncClientBuilder
//                .standard()
//                .withRegion(Regions.AP_NORTHEAST_2)
//                .withCredentials(awsCredentialsProvider)
//                .build();
//    }
}
