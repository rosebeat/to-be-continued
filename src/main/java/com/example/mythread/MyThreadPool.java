package com.example.mythread;

import java.util.concurrent.*;

/**
 * @author: kai·yang
 * @Date: 2024/3/26 16:23
 * @Description:
 */
public class MyThreadPool {

    /**
     *
     * 1、核心线程数
     * 2、最大线程数
     * 3、非核心线程最大空闲时间
     * 4、时间单位
     * 5、阻塞队列
     * 6、线程创建工厂
     * 7、拒绝策略
     *
     */
    public static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 16,
            30, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1024),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy() );


    //拒绝策略
    RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.CallerRunsPolicy();


    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();


    public void set(){
        threadLocal.set("线程私有");
    }

    public void get(){
        String s = threadLocal.get();
    }

    public void test(){
        threadPoolExecutor.submit(() -> System.out.println(""));
    }


}
