package com.example.mythread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author kai·yang
 * @Date 2024/1/5 17:32
 *
 * ThreadPoolTaskExecutor 是 spring 框架提供的，是 spring 框架对java线程池的封装和扩展，提供了更多的功能和配置选项，例如异步任务执行
 * 任务拒绝策略，线程池监控等
 *
 */
@Configuration
public class ThreadPoolTaskConfig {

    /**
     * 核心线程数
     */
    private static final int CORE_POOL_SIZE = 10;

    /**
     * 最大线程数
     */
    private static final int MAX_POOL_SIZE = 20;

    /**
     * 允许线程空闲时间（单位：秒）
     */
    private static final int KEEP_ALIVE_TIME = 10;

    /**
     * 任务队列大小
     */
    private static final int QUEUE_CAPACITY = 100;

    /**
     * 线程池前缀
     */
    private static final String THREAD_NAME_PREFIX = "dmpTodsp-Async-";


    @Bean("taskExecutor")
    public ThreadPoolTaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程数
        executor.setCorePoolSize(CORE_POOL_SIZE);
        //最大线程数
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        //任务队列大小
        executor.setQueueCapacity(QUEUE_CAPACITY);
        //允许线程空闲时间（单位：秒）
        executor.setKeepAliveSeconds(KEEP_ALIVE_TIME);
        //线程池线程前缀
        executor.setThreadNamePrefix(THREAD_NAME_PREFIX);
        //拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

}
