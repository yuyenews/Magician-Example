package com.demo.handler;


import io.magician.tcp.codec.impl.websocket.connection.WebSocketSession;
import io.magician.tcp.codec.impl.websocket.handler.WebSocketHandler;

/**
 * WebSocket
 */
public class DemoSocketHandler implements WebSocketHandler {

    /**
     * 有连接进来时调用
     */
    @Override
    public void onOpen(WebSocketSession webSocketSession) {
        System.out.println("连接了websocket");
    }

    /**
     * 连接断开时调用
     */
    @Override
    public void onClose(WebSocketSession webSocketSession) {
        System.out.println("关闭了websocket");
    }

    /**
     * 有消息进来时调用
     */
    @Override
    public void onMessage(String message, WebSocketSession webSocketSession) {
        System.out.println("收到了消息"+message);
        try{
            webSocketSession.send("我收到了");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
