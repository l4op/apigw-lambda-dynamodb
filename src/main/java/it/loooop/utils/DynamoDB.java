package it.loooop.utils;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class DynamoDB {

    //The Region is automatically "injected" from AWS with the reserved Environment Variable AWS_REGION
    Region region = Region.of(System.getenv("AWS_REGION"));
    DynamoDbClient ddb = DynamoDbClient.builder().region(region).build();
    private final DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
            .dynamoDbClient(ddb)
            .build();

    public DynamoDbEnhancedClient client(){
        return this.enhancedClient;
    }

}
