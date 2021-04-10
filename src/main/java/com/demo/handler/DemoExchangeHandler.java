package com.demo.handler;

import com.mars.server.tcp.http.constant.MartianServerConstant;
import com.mars.server.tcp.http.handler.ext.HttpExchangeHandler;
import com.mars.server.tcp.http.model.HttpHeaders;
import com.mars.server.tcp.http.request.MartianHttpExchange;

import java.io.InputStream;
import java.nio.channels.AsynchronousSocketChannel;

public class DemoExchangeHandler implements HttpExchangeHandler {

    @Override
    public void request(MartianHttpExchange martianHttpExchange) {
        // 获取请求头
        HttpHeaders httpHeaders = martianHttpExchange.getRequestHeaders();

        // 获取请求内容，是一个文件流 需要自己解析
        InputStream inputStream = martianHttpExchange.getRequestBody();

        // 也可以自己直接操作channel
        AsynchronousSocketChannel socketChannel = martianHttpExchange.getSocketChannel();

        /* *************************设置响应头************************* */
        // 如果不想让框架自己关闭channel的话，这句是必须的
        martianHttpExchange.setResponseHeader(MartianServerConstant.CONNECTION,"keep-alive");
        // 设置响应格式为json
        martianHttpExchange.setResponseHeader(MartianServerConstant.CONTENT_TYPE,MartianServerConstant.JSON_CONTENT_TYPE);
        // 设置响应状态码以及数据
        martianHttpExchange.sendText(200,"ok");
    }
}
