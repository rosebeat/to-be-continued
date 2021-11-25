package com.example.designpattern.factory;

/**
 * @author kai·yang
 * @Date 2021/11/25 11:47
 */
public class WhiteCat implements Cat {


    @Override
    public void name() {
        System.out.print("汤姆");
    }

    @Override
    public void sex() {
        System.out.print("公猫");
    }

    @Override
    public void eat() {
        System.out.println("偷吃奶酪！");
    }
}
