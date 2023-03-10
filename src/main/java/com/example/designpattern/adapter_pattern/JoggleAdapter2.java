package com.example.designpattern.adapter_pattern;

/**
 * @author kai·yang
 * @Date 2023/3/8 11:11
 *
 * 适配器接口实现( 属于对象适配器模式 )
 */
public class JoggleAdapter2  implements NetToTypeC {

    private NetTwine netTwine;

    public JoggleAdapter2(NetTwine netTwine){
        this.netTwine = netTwine;
    }


    @Override
    public void handleRequest() {
        System.out.println("将网口适配为 Type-C接口");
        netTwine.request();
    }
}
