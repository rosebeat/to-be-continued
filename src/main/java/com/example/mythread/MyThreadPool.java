package com.example.mythread;

import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: kai·yang
 * @Date: 2024/3/26 16:23
 * @Description:
 */
public class MyThreadPool {

    //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor()
    ThreadFactory factory = Executors.defaultThreadFactory();
    RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.CallerRunsPolicy();


    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public void set(){
        threadLocal.set("线程私有");
    }

    public void get(){
        String s = threadLocal.get();
    }


}
