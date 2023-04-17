package it.loooop;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.loooop.model.Item;
import it.loooop.response.PutItemResponse;
import it.loooop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PutItem implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    Logger logger = LoggerFactory.getLogger(PutItem.class);
    ObjectMapper mapper = new ObjectMapper();
    ItemService itemService = new ItemService();

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();

        String itemId = "";
        try {
            Item item = mapper.readValue(event.getBody(), Item.class);

            logger.info("item.userId -> {}",item.getUserId());
            logger.info("item.information -> {}", item.getInformation());

            itemId = itemService.persistRecord(item);

            response.setBody(mapper.writeValueAsString(
                    new PutItemResponse("OK", itemId)
            ));

        } catch (JsonProcessingException e) {
            logger.atError().setCause(e).log("Error mapping APIGatewayProxyRequestEvent to Item");
        }
        return response;
    }
}
