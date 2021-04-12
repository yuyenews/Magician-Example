package com.demo.server;

import io.magician.Magician;

public class DemoServer {

    public static void main(String[] args) throws Exception {
        Magician.createHttpServer().httpHandler("/", req -> {
            req.getResponse()
                .sendText(200, "ok");
        }).bind(8080).start();
    }

}
