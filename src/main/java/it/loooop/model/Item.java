package it.loooop.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import java.io.Serializable;

@DynamoDbBean
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("itemId")
    private String itemId = null;

    @JsonProperty("information")
    private String information = null;

    @JsonProperty("userId")
    private String userId = null;

    public Item() {
    }

    public Item(String itemId, String information, String userId) {
        this.itemId = itemId;
        this.information = information;
        this.userId = userId;
    }

    @DynamoDbPartitionKey
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String recordId) {
        this.itemId = recordId;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
