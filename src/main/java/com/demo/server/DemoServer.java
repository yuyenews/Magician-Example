package com.demo.server;

import com.demo.handler.DemoRequestHandler;
import com.demo.handler.DemoSocketHandler;
import io.magician.Magician;

public class DemoServer {

    public static void main(String[] args) {
        try {

            Magician.createHttpServer()
                    .bind(8080, 100)// 设置端口号和最大连接数，必填
                    .fileSizeMax(100*1024*1024)// 设置单个文件上传大小限制，非必填，默认 2*1024*1024
                    .sizeMax(100*1024*1024)// 设置上传文件总大小限制，非必填，默认 10*1024*1024
                    .readSize(1024) // 设置读取数据的缓冲区大小，非必填，默认 1024
                    .readTimeout(10000)// 设置读取数据的超时时间，非必填，默认 10000
                    .writeTimeout(1000)// 设置写入数据的超时时间，非必填， 默认 10000
                    .threadPool(DemoThreadPool.getThreadPoolExecutor())// 设置一个线程池，非必填，默认 Executors.newFixedThreadPool(20)
                    .httpHandler("/", new DemoRequestHandler()) // 设置http的handler，必填
                    .webSocketHandler("/websocket", new DemoSocketHandler()) // 设置webSocket的handler，暂时不可用
                    .start();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
