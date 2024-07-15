package com.example.cache;

import com.github.benmanes.caffeine.cache.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.sql.Time;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author: kai·yang
 * @Date: 2024/7/3 11:18
 * @Description:
 */
public class MyCaffeine {


    public static void main(String[] args) throws InterruptedException {
        /**
         * 默认的缓存淘汰算法是  Window—TinyLFU
         */
        Cache<Object, Object> caffeine = Caffeine.newBuilder().maximumSize(1).build();
        caffeine.put("bob", "bob");
        caffeine.put("lily", "lily");
        TimeUnit.MICROSECONDS.sleep(10);
        System.out.println(caffeine.getIfPresent("bob"));
        System.out.println(caffeine.getIfPresent("lily"));

    }


    public void loadCache(){

        LoadingCache loadingCache = (LoadingCache) Caffeine.newBuilder()
                //缓存最大容量
                .maximumSize(10)
                //最后一次访问之后多久过期
                .expireAfterAccess(2, TimeUnit.SECONDS)
                //当key过期时，同步执行CacheLoader中的load方法
                .build( new CacheLoader(){
                    @Nullable
                    @Override
                    public Object load(Object key) throws Exception {
                        return null;
                    }
                });



    }


    public void asyncLoadCache(){
        AsyncLoadingCache asyncLoadingCache = Caffeine.newBuilder()
                .maximumSize(10)
                //写入之后多久过期
                .expireAfterWrite(2, TimeUnit.SECONDS)
                //当key过期时，异步执行CacheLoader中的load方法
                .buildAsync( new CacheLoader(){
                     @Nullable
                     @Override
                     public Object load(Object key) throws Exception {
                         return null;
                     }
                 });
        //异步的，value是 CompletedFuture 类型
        asyncLoadingCache.put("NAME", CompletableFuture.completedFuture("xxxFuture"));



    }


}
