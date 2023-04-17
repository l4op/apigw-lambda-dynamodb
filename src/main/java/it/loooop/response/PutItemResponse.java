package it.loooop.response;

import java.io.Serializable;

public class PutItemResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    public PutItemResponse(String status, String itemId){
        this.itemId = itemId;
        this.status = status;
    }

    private String status;
    private String itemId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
