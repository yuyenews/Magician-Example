package com.demo.handler;

import io.magician.udp.handler.MagicianUDPHandler;

import java.io.ByteArrayOutputStream;

public class DemoUDPHandler implements MagicianUDPHandler {

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
