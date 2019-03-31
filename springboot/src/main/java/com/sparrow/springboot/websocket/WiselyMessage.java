package com.sparrow.springboot.websocket;

/**
 * 浏览器向服务端发送的消息
 */
public class WiselyMessage {
    private String name;

    public WiselyMessage() {
    }

    public WiselyMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
