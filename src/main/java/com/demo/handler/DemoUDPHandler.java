package com.demo.handler;

import io.magician.common.annotation.UDPHandler;
import io.magician.udp.handler.UDPBaseHandler;

import java.io.ByteArrayOutputStream;

@UDPHandler
public class DemoUDPHandler implements UDPBaseHandler {

    @Override
    public void receive(ByteArrayOutputStream byteArrayOutputStream) {
        try {
            String str = byteArrayOutputStream.toString("UTF-8");
            System.out.println(str.length());
            System.out.println(str);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
