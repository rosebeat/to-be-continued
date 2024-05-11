package com.example.tools;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author: kai·yang
 * @Date: 2024/4/28 10:09
 * @Description:
 */
public class MyOptional {

    public static void main(String[] args) {
        AdUser user = new AdUser();
        //如果传入的值为null，则抛出空指针异常
        Optional<AdUser> u1 = Optional.of(user);
        //如果掺入的值为null，则返回一个空的Optional对象
        Optional<AdUser> u2 = Optional.ofNullable(null);

        System.out.println(" 判断当前Optional对象是否为空 u1 isPresent: " + u1.isPresent());
        System.out.println(" u1 isPresent: " + u1.get());
        u1.ifPresent( u -> { u.setAge(19); u.setName("lisi"); });
        System.out.println(u1.orElse( new AdUser()));


        System.out.println(" 判断当前Optional对象是否为空 u2 isPresent: " + u2.isPresent());


        Consumer consumer;
        Supplier supplier;
        Predicate predicate;
        Function function;


    }

}
