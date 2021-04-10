package com.demo.server;

import com.demo.handler.DemoRequestHandler;
import com.demo.handler.DemoSocketHandler;
import com.mars.server.MartianServer;

public class DemoServer {

    public static void main(String[] args) {
        try {

            MartianServer.builder()
                    .bind(8080, 100)// 设置端口号和最大连接数
                    .fileSizeMax(100*1024*1024)// 设置单个文件上传大小限制
                    .sizeMax(100*1024*1024)// 设置上传文件总大小限制
                    .readSize(1024) // 设置读取数据的缓冲区大小
                    .readTimeout(10000)// 设置读取数据的超时时间
                    .writeTimeout(1000)// 设置写入数据的超时时间
                    .threadPool(DemoThreadPool.getThreadPoolExecutor())// 设置一个线程池
                    .httpHandler("/",new DemoRequestHandler()) // 设置http的handler
                    .webSocketHandler("/websocket", new DemoSocketHandler()) // 设置webSocket的handler
                    .start();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
