package com.sparrow.springboot.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * 配置websocket
 */
@Configuration
@EnableWebSocketMessageBroker//1:开启使用stomp协议来传输基于代理（message broker）的消息，这时，控制器支持使用@messageMapping
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {//2:注册stomp协议节点，并映射指定的URL
        registry.addEndpoint("/endpointWisely").withSockJS();//3：注册一个stomp的endpoint，并指定使用SockJs协议
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {//4：配置消息代理
        registry.enableSimpleBroker("/topic");//5：广播式应配置一个/topic消息代理
    }
}
