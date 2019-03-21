package com.sparrow.springboot.websocket;

public class WiselyRespone {
    private  String responseMessage;

    public WiselyRespone(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
