package com.example.iconcurrent;

import org.openjdk.jol.info.ClassLayout;

/**
 * @tile: JustTest
 * @ahthor: kai.Yang
 * @description:
 * @date: 2023/6/7 23:15
 **/
public class JustTest {


    public static void main(String[] args) {
        Object o = new Object();
        //展示对象头
        String s = ClassLayout.parseInstance(o).toPrintable();
        System.out.println(s);
    }

}
