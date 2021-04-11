package com.demo.handler;

import io.magician.tcp.http.handler.MagicianHandler;
import io.magician.tcp.http.model.MagicianFileUpLoad;
import io.magician.tcp.http.request.MagicianRequest;

import java.util.Map;

public class DemoRequestHandler implements MagicianHandler {

    @Override
    public void request(MagicianRequest magicianRequest) {

        for(String key : magicianRequest.getRequestHeaders().keySet()){
            System.out.println(key+":"+magicianRequest.getRequestHeaders().get(key));
        }

        // 如果是json格式提交的，就用这个方法获取参数字符串
        String jsonStr = magicianRequest.getJsonParam();
        System.out.println(jsonStr);
        /* *********如果是其他方式提交的，就用这个方法获取参数********* */
        String list = magicianRequest.getParam("参数的name");

        /* *********如果是文件上传就用这个方法获取文件们********* */
        Map<String, MagicianFileUpLoad> fileUpLoadMap = magicianRequest.getFiles();
        // 可以这样获取到文件
        MagicianFileUpLoad magicianFileUpLoad = fileUpLoadMap.get("file2");
        magicianFileUpLoad.getFileName();// 文件名
        magicianFileUpLoad.getInputStream(); // 文件流
        magicianFileUpLoad.getName();// 参数的name

        // 设置响应数据
        magicianRequest.getResponse()
                .setResponseHeader("content-type", "application/json;charset=UTF-8")
                .sendText(200, "ok");
    }
}
