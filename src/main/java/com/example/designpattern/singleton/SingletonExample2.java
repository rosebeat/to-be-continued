package com.example.designpattern.singleton;



/**
 * @author kai·yang
 * @Date 2021/11/25 10:01
 * @description  饿汉模式，单例实例在类装载的时候进行创建，是线程安全的
 *
 */

public class SingletonExample2 {

    public SingletonExample2(){

    }

    private static SingletonExample2 instance = new SingletonExample2();

    public SingletonExample2 getInstance(){
        return instance;
    }


}
