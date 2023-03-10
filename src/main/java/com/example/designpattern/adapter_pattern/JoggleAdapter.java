package com.example.designpattern.adapter_pattern;

/**
 * @author kai·yang
 * @Date 2023/3/8 11:11
 *
 * 适配器接口实现( 属于类适配器模式 )
 */
public class JoggleAdapter extends NetTwine implements NetToTypeC {



    @Override
    public void handleRequest() {
        System.out.println("将网口适配为 Type-C接口");
        super.request();
    }
}
