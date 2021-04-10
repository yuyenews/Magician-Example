package com.demo.server;

import com.demo.handler.DemoRequestHandler;
import com.demo.handler.DemoSocketHandler;
import com.mars.server.MartianServer;

public class DemoServer {

    public static void main(String[] args) {
        try {

            MartianServer.builder()
                    .bind(8080, 100)
                    .fileSizeMax(100*1024*1024)
                    .sizeMax(100*1024*1024)
                    .threadPool(DemoThreadPool.getThreadPoolExecutor())
                    .httpHandler("/",new DemoRequestHandler())
                    .webSocketHandler("/websocket", new DemoSocketHandler())
                    .start();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
