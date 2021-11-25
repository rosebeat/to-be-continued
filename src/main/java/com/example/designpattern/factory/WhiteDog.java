package com.example.designpattern.factory;

/**
 * @author kai·yang
 * @Date 2021/11/25 11:47
 */
public class WhiteDog implements Dog{


    @Override
    public void name() {
        System.out.print("斯派克");
    }

    @Override
    public void sex() {
        System.out.print("公狗");
    }

    @Override
    public void eat() {
        System.out.println("监视汤姆偷吃奶酪！");
    }


}
