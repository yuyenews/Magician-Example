package com.demo.server;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DemoThreadPool {

    /**
     * 线程池
     */
    private static ThreadPoolExecutor threadPoolExecutor;

    static {
        init();
    }

    /**
     * 获取线程池
     *
     * @return
     */
    public static ThreadPoolExecutor getThreadPoolExecutor() {
        if (threadPoolExecutor == null) {
            init();
        }
        return threadPoolExecutor;
    }

    /**
     * 初始化线程池
     */
    private static void init() {
        /* 创建线程池 */
        threadPoolExecutor = new ThreadPoolExecutor(
                10,
                1000,
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(990));
    }
}
