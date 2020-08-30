package com.gz.pigvideo.common;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;


/**
 * 配置websocket
 * 
 * @author gaozhen
 *
 */
@SuppressWarnings("deprecation")
@Configuration
@EnableWebSocketMessageBroker // 注解使用STOMP协议传输基于代理消息
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
	// 注册STOMP协议节点，同时指定使用SockJS协议。
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/endpointSang").setAllowedOrigins("*").withSockJS();
	}

	// 由于我们是实现推送功能，这里的消息代理是/topic
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic");
	}

}