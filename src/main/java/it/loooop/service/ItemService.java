package it.loooop.service;

import it.loooop.model.Item;
import it.loooop.utils.DynamoDB;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.UUID;

public class ItemService {

    DynamoDB dynamoDb = new DynamoDB();
    String itemTable = System.getenv("DYNAMODB_ITEMS_TABLE");

    public String persistRecord(Item item){

        DynamoDbTable<Item> mappedTable = dynamoDb.client()
                .table(itemTable, TableSchema.fromBean(Item.class));

        String itemId = UUID.randomUUID().toString();

        item.setItemId(itemId);

        mappedTable.putItem(item);

        return itemId;
    }

}
