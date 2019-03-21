package com.sparrow.springboot.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WsController {
    @MessageMapping("/welcome")//相当于requestMapping
    @SendTo("/topic/getResponse")//当服务端有消息时，会对订阅了该注解中路径的浏览器发送消息
    public WiselyRespone say(WiselyMessage message)throws Exception{
        Thread.sleep(3000);
        return new WiselyRespone("欢迎，"+message.getName()+"!");
    }
}
