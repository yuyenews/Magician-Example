package com.demo.server;

import com.demo.handler.DemoRequestHandler;
import com.demo.handler.DemoSocketHandler;
import com.demo.handler.DemoUDPHandler;
import io.magician.Magician;

public class DemoServer {

    public static void main(String[] args) throws Exception {
        /* 创建http服务 */
        Magician.createHttpServer()
                .threadSize(5)
                .fileSizeMax(1024*1024*1024)
                .sizeMax(1024*1024*1024)
                .httpHandler("/", new DemoRequestHandler())
                .webSocketHandler("/websocket", new DemoSocketHandler())
                .bind(8080, 1000).start();

        /* ****实战中不能这样写，因为每个服务创建完都会阻塞主线程，所以会导致下面的代码执行不到**** */

        /* 创建UDP服务 */
        Magician.createUdpServer()
                .bind(8088)
                .threadSize(5)
                .readSize(65507)
                .handler(new DemoUDPHandler())
                .start();
    }

}
