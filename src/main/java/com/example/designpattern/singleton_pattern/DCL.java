package com.example.designpattern.singleton_pattern;

/**
 * @Ahthor k·Young
 * @Date 2024/10/22 16:16
 * @Version 1.0
 * @Desc
 *
 *
 *
 * 双重锁模式
 *
 */
public class DCL {

    /**
     * 一定要加 volatile 禁止指令重排序，在高并发下防止别的线程拿到半成品（半初始化）对象
     */
    volatile DCL instance;

    public DCL getInstance(){
        if (instance == null){
            synchronized (instance){
                if(instance == null){
                    instance = new DCL();
                }
            }
        }
        return instance;
    }


}
