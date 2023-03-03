package com.example.designpattern.observer;

/**
 * @author kai·yang
 * @Date 2023/3/3 11:16
 *
 * subject（通知者/被观察者）
 * subject是一个接口
 *
 */
public interface Subject {

    /**
     * 添加观察者
     * @param obs
     */
    void attach(Observer obs);

    /**
     * 删除观察者
     * @param obs
     */
    void detach(Observer obs);

    /**
     * 通知所有观察者，根据state 执行自己的update方法
     */
    void sNotify();

    /**
     * 获取被观察者状态
     * @return
     */
    int getSate();

    /**
     * 设置状态
     * @param state
     */
    void setSate(int state);
}
