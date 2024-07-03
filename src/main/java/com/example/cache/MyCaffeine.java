package com.example.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

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


}
