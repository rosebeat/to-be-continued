package com.example.designpattern.singleton;



/**
 * @author kai·yang
 * @Date 2021/11/18 16:01
 */

/**
 * 懒汉式---线程不安全
 */
public class SingletonExample {

    public SingletonExample(){

    }

    private static SingletonExample instance = null;

    public SingletonExample getInstance(){
        //多个线程同时调用时，可能会创建多个对象
        if (instance == null){
            instance = new SingletonExample();
        }
        return instance;
    }


}
