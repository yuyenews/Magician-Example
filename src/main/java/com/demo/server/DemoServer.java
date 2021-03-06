package com.demo.server;

import io.magician.Magician;
import io.magician.common.constant.EventEnum;
import io.magician.common.event.EventGroup;
import io.magician.tcp.TCPServer;
import io.magician.tcp.TCPServerConfig;
import io.magician.tcp.codec.impl.http.HttpProtocolCodec;

import java.util.concurrent.Executors;

public class DemoServer {

    public static void main(String[] args) throws Exception {

        TCPServerConfig tcpServerConfig = new TCPServerConfig();
        tcpServerConfig.setFileSizeMax(1024*1024*1024);
        tcpServerConfig.setSizeMax(1024*1024*1024);
        tcpServerConfig.setReadSize(1024);

        EventGroup ioEventGroup = new EventGroup(2, Executors.newCachedThreadPool());
        EventGroup workerEventGroup = new EventGroup(2, Executors.newCachedThreadPool());
        workerEventGroup.setSteal(EventEnum.STEAL.YES);

        /* 创建TCP服务，默认采用http解码器，支持webSocket */
        TCPServer tcpServer = Magician.createTCPServer(ioEventGroup, workerEventGroup)
                .config(tcpServerConfig)
                .soTimeout(3000)
                .scan("com.demo.handler")
                .protocolCodec(new HttpProtocolCodec());

        tcpServer.bind(8080);
        tcpServer.bind(8088);

        /* ************************创建UDP服务************************ */
        Magician.createUdpServer()
                .readSize(65507)
                .scan("com.demo.handler")
                .bind(8088);
    }

}
