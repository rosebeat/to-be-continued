package com.example.designpattern.adapter_pattern;

/**
 * @author kai·yang
 * @Date 2023/3/8 11:38
 */
public class Computer {

    /**
     * 属于类适配器模式
     * @param adapter
     */
    public void net(NetToTypeC adapter){
        adapter.handleRequest();
    }


    public static void main(String[] args) {
        Computer c = new Computer();
        c.net(new JoggleAdapter());
    }

}
