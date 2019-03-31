package com.sparrow.springboot.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class WsController {
    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/welcome")//相当于requestMapping
    @SendTo("/topic/getResponse")//当服务端有消息时，会对订阅了该注解中路径的浏览器发送消息
    public WiselyRespone say(WiselyMessage message)throws Exception{
        Thread.sleep(3000);
        return new WiselyRespone("欢迎，"+message.getName()+"!");
    }

    @RequestMapping("/ws")
    public String welcome(){
        return "ws";
    }

    @RequestMapping("/chat")
    public void handlerChat(Principal principal, String msg){//principal包含当前用户信息
        if ("heyi".equals(principal.getName())) {
            // 向浏览器发送消息
            messagingTemplate.convertAndSendToUser("test", "/queue/notifications",
                    principal.getName() + "-send:" + msg);
        } else{
            // 参数1：接受消息用户，参数2：浏览器订阅地址，参数3：消息本身
            messagingTemplate.convertAndSendToUser("heyi", "/queue/notifications",
                    principal.getName() + "-send:" + msg);
        }
    }
}
