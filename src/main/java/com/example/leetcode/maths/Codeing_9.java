package com.example.leetcode.maths;

/**
 * @author kai·yang
 * @Date 2022/4/7 14:27
 */

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Codeing_9 {

    public boolean isPalindrome(int x) {
        // 负数一定不是回文的
        if (x < 0){
            return false;
        }
        //将整数反转，然后比较大小
        //反转后数字
        int reverse = 0;
        int current = x;
        while(current != 0){
            reverse = reverse * 10 + (current % 10);
            current = current / 10;
        }
        return x == reverse;
    }

}
