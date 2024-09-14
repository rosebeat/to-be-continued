package com.example.main;


import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static void main(String[] args) {
        String s = "test";
        try {
            System.out.println( new String(s.getBytes(), "GBK"));
            System.out.println("00016".matches("-?[0-9]+.?[0-9]*"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String ss = s.toLowerCase();

        System.out.println("ss: " + ss);

        System.out.println(LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        System.out.println(isPalindrome(10));

        System.out.println(format.format(new Date()));

    }


    /**
     * 判断数字是不是回文数
     * @param x
     * @return
     */
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



}
