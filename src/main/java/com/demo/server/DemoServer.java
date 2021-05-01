package com.demo.server;

import com.demo.handler.DemoRequestHandler;
import com.demo.handler.DemoSocketHandler;
import com.demo.handler.DemoUDPHandler;
import io.magician.Magician;
import io.magician.common.constant.EventEnum;
import io.magician.common.event.EventGroup;
import io.magician.tcp.TCPServer;
import io.magician.tcp.TCPServerConfig;

import java.util.concurrent.Executors;

public class DemoServer {

    public static void main(String[] args) throws Exception {

        TCPServerConfig tcpServerConfig = new TCPServerConfig();
        tcpServerConfig.setFileSizeMax(1024*1024*1024);
        tcpServerConfig.setSizeMax(1024*1024*1024);

        EventGroup ioEventGroup = new EventGroup(2, Executors.newCachedThreadPool());
        EventGroup workerEventGroup = new EventGroup(10, Executors.newCachedThreadPool());
        workerEventGroup.setSteal(EventEnum.STEAL.YES);

        /* 创建TCP服务，默认采用http解码器，支持webSocket */
        TCPServer tcpServer = Magician.createTCPServer(ioEventGroup, workerEventGroup)
                .config(tcpServerConfig)
                .soTimeout(3000)
                .handler("/", new DemoRequestHandler())
                .webSocketHandler("/websocket", new DemoSocketHandler());

        tcpServer.bind(8080);
        tcpServer.bind(8088);

        /* ************************创建UDP服务************************ */
        Magician.createUdpServer()
                .readSize(65507)
                .handler(new DemoUDPHandler())
                .bind(8088);
    }

}
