package com.example.designpattern.observer;

/**
 * @author kai·yang
 * @Date 2023/3/3 9:50
 *
 *
 * 观察者
 * Observer是接口, 我们可以理解它是一个抽象观察者类.
 * 它只有一个  update() 方法, 也就是说它可以通过这个方法来执行某些动作.
 */
public interface Observer {


    void update();

}
