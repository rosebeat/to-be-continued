package com.example.designpattern.singleton_pattern;



/**
 * @author kai·yang
 * @Date 2021/11/25 10:01
 *
 * @description  枚举方式进行实例化，是线程安全的，此种方式也是线程最安全的
 *
 */

public class SingletonExample4 {

    public SingletonExample4(){}


    public static SingletonExample4 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }


    private enum Singleton{

        INSTANCE;

        private SingletonExample4 singleton;

        Singleton(){
            singleton = new SingletonExample4();
        }

        public SingletonExample4 getInstance(){
            return singleton;
        }

    }
}
