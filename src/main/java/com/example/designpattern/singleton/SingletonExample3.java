package com.example.designpattern.singleton;



/**
 * @author kai·yang
 * @Date 2021/11/25 10:01
 * @description  饿汉模式，单例实例在类装载的时候进行创建，是线程安全的
 *
 */

public class SingletonExample3 {

    public SingletonExample3(){}

    private static SingletonExample3 instance = null;

    //使用静态代码块进行创建
    static{
        instance = new SingletonExample3();
    }

    public static SingletonExample3 getInstance(){
        return instance;
    }


}
