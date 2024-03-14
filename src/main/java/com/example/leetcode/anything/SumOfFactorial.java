package com.example.leetcode.anything;

/**
 * @author: kai·yang
 * @Date: 2024/3/14 17:03
 * @Description:
 *
 */
public class SumOfFactorial {


    /**
     * 阶乘
     * 给定一个数字 N ，求出 1! + 2! + 3! + .... + N!= ?
     */
    public int factorial(int n){
        int result = 0;
        int last = 1;
        for (int i = 1; i <= n; i++){
            result += last * i;
        }
        return result;
    }



}
