package com.demo.handler;


import com.mars.server.tcp.http.constant.MartianServerConstant;
import com.mars.server.tcp.http.handler.ext.HttpRequestHandler;
import com.mars.server.tcp.http.request.MartianHttpRequest;

public class DemoRequestHandler implements HttpRequestHandler {

    @Override
    public void request(MartianHttpRequest martianHttpRequest) {
        // 如果是json格式提交的，就用这个方法取出参数字符串
        System.out.println(martianHttpRequest.getJsonParam());
        // 如果是其他方式提交的，就用这个方法去除参数
        System.out.println(martianHttpRequest.getMarsParams());
        // 如果是文件上传就用这个方法取出文件们
        System.out.println(martianHttpRequest.getFiles());

        // 设置响应头
        martianHttpRequest.getMartianHttpExchange().setResponseHeader(MartianServerConstant.CONTENT_TYPE, MartianServerConstant.JSON_CONTENT_TYPE);
        // 设置状态码和响应内容
        martianHttpRequest.getMartianHttpExchange().sendText(200, "ok");
    }
}
