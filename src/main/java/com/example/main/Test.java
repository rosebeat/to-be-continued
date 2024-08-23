package com.example.main;

import com.example.designpattern.factory_pattern.AnimalFactory;
import com.example.service.OdinService;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

public class Test {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static void main(String[] args) {
//        String s = "test";
//        try {
//            System.out.println( new String(s.getBytes(), "GBK"));
//            System.out.println("00016".matches("-?[0-9]+.?[0-9]*"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

//        String s = "这是字符串";
//
//        String ss = s.toLowerCase();
//
//        System.out.println("ss: " + ss);
//
//        System.out.println(LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//
//        System.out.println(isPalindrome(10));
//
//        System.out.println(format.format(new Date()));


        test();
    }

    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        int reverse = 0;
        int current = x;
        while(current != 0){
            reverse = reverse * 10 + (current % 10);
            current = current / 10;
        }
        return x == reverse;
    }



    public static void test(){
        OdinService a = null;
        get(a);
        a.validateRetry();
        System.out.println(a);
    }

    public static void get(OdinService a){
        if (a == null){
            a = new OdinService();
            System.out.println("get method: " + a);
        }
    }








}
