package com.caler.zkl.openpsd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.websocket.server.ServerEndpointConfig;

/**
 * @author Caler_赵康乐
 * @create 2020-05-08 12:22
 * @description :服务器向客户端发送请求
 */

@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter  serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
