package com.demo.handler;


import com.mars.server.tcp.http.constant.MartianServerConstant;
import com.mars.server.tcp.http.handler.ext.HttpRequestHandler;
import com.mars.server.tcp.http.model.MarsFileUpLoad;
import com.mars.server.tcp.http.request.MartianHttpRequest;

import java.util.List;
import java.util.Map;

public class DemoRequestHandler implements HttpRequestHandler {

    @Override
    public void request(MartianHttpRequest martianHttpRequest) {
        // 如果是json格式提交的，就用这个方法取出参数字符串
        String jsonStr = martianHttpRequest.getJsonParam();

        /* *********如果是其他方式提交的，就用这个方法去除参数********* */
        Map<String, List<String>> paramMap = martianHttpRequest.getMarsParams();
        // 可以这样获取参数， 为什么类型是List? 因为http请求的参数name是可以重复的，一个Name可能获取到多个数据
        List<String> list = paramMap.get("参数的name");

        /* *********如果是文件上传就用这个方法取出文件们********* */
        Map<String, MarsFileUpLoad> fileUpLoadMap = martianHttpRequest.getFiles();
        // 可以这样获取到文件
        MarsFileUpLoad marsFileUpLoad = fileUpLoadMap.get("参数的name");
        marsFileUpLoad.getFileName();// 文件名
        marsFileUpLoad.getInputStream(); // 文件流
        marsFileUpLoad.getName();// 参数的name

        // 设置响应头
        martianHttpRequest.setResponseHeader(MartianServerConstant.CONTENT_TYPE, MartianServerConstant.JSON_CONTENT_TYPE);
        // 设置状态码和响应内容
        martianHttpRequest.sendText(200, "ok");
    }
}
