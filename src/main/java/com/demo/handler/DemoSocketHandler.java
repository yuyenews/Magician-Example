package com.demo.handler;


import io.magician.common.annotation.WebSocketHandler;
import io.magician.tcp.codec.impl.websocket.connection.WebSocketSession;
import io.magician.tcp.handler.WebSocketBaseHandler;

/**
 * WebSocket
 */
@WebSocketHandler(path = "/websocket")
public class DemoSocketHandler implements WebSocketBaseHandler {

    /**
     * 有连接进来时调用
     */
    @Override
    public void onOpen(WebSocketSession webSocketSession) {
        System.out.println("连接了websocket");
        try{
            webSocketSession.send("已经连上了");
        } catch (Exception e){
            e.printStackTrace();
        }
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
            StringBuffer msg = new StringBuffer();
            for(int i=0;i<12500;i++){
                msg.append("h");
            }
            msg.append("$");
            webSocketSession.send(msg.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
