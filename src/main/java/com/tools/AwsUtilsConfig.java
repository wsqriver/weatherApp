package com.tools;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsUtilsConfig {
    //todo get accesskey&&secretkey in AWS secret manager
    @Value("")
    private  String accessKey;
    @Value("")
    private  String secretKey;
    //get AWS connection
    public  AWSCredentialsProvider getAwsProvider(){
        return new AWSCredentialsProvider() {
            public void refresh() {}
            public AWSCredentials getCredentials() {return new BasicAWSCredentials(accessKey, secretKey);}
        };
    }
    //dynamodb bean
    @Bean
    public  DynamoDBMapper getDynamoDBMapper(){
        AmazonDynamoDB amazonDynamoDBClient;
        amazonDynamoDBClient = AmazonDynamoDBClientBuilder.standard().withCredentials(getAwsProvider()).withRegion(Regions.US_EAST_1).build();
        return new DynamoDBMapper(amazonDynamoDBClient);
    }


}
