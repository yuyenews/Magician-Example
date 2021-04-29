package com.demo.handler;



import io.magician.tcp.codec.impl.http.request.MagicianRequest;
import io.magician.tcp.handler.MagicianHandler;
import java.util.concurrent.atomic.AtomicInteger;

public class DemoRequestHandler implements MagicianHandler<MagicianRequest> {
    AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void request(MagicianRequest magicianRequest) {
        System.out.println(atomicInteger.getAndIncrement());
//        try {
//            System.out.println(WorkersCacheManager.getProtocolDataModelMap().size());
//            System.out.println(magicianRequest.getJsonParam());
//            Thread.sleep(10000);
//        } catch (Exception e){
//
//        }
//        for(String key : magicianRequest.getRequestHeaders().keySet()){
//            System.out.println(key+":"+magicianRequest.getRequestHeaders().get(key));
//        }
//        magicianRequest.getRequestHeaders();
//        // 如果是json格式提交的，就用这个方法获取参数字符串
//        String jsonStr = magicianRequest.getJsonParam();
//        System.out.println(jsonStr);
//        /* *********如果是其他方式提交的，就用这个方法获取参数********* */
//        String list = magicianRequest.getParam("参数的name");
//
//        /* *********如果是文件上传就用这个方法获取文件们********* */
//        Map<String, MagicianFileUpLoad> fileUpLoadMap = magicianRequest.getFiles();
//        // 可以这样获取到文件
//        MagicianFileUpLoad magicianFileUpLoad = fileUpLoadMap.get("file2");
//        System.out.println(magicianFileUpLoad.getFileName());// 文件名
//        System.out.println(magicianFileUpLoad.getInputStream()); // 文件流
//        System.out.println(magicianFileUpLoad.getName());// 参数的name

        // 设置响应数据
        magicianRequest.getResponse()
                .sendText(200, "ok");
    }
}
