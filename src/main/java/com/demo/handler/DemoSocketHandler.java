package com.demo.handler;

import com.mars.server.tcp.websocket.WebSocketSession;
import com.mars.server.tcp.websocket.handler.WebSocketHandler;

/**
 * WebSocket暂时不可用，可以忽略这个类
 */
public class DemoSocketHandler implements WebSocketHandler {

    /**
     * WebSocket暂时不可用，可以忽略这个类
     */
    @Override
    public void onOpen(WebSocketSession webSocketSession) {
        System.out.println("连接了websocket");
    }

    /**
     * WebSocket暂时不可用，可以忽略这个类
     */
    @Override
    public void onClose(WebSocketSession webSocketSession) {
        System.out.println("关闭了websocket");
    }

    /**
     * WebSocket暂时不可用，可以忽略这个类
     */
    @Override
    public void onMessage(String message, WebSocketSession webSocketSession) {
        System.out.println("收到了消息"+message);
    }
}
