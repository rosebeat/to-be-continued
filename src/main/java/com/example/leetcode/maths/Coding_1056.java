package com.example.leetcode.maths;
/**
 * @tile: Coding_1056
 * @ahthor: kai.Yang
 * @description: 
 * @date: 2024/5/19 22:37
 *
 * LeetCode: 【1056】 易混淆数
 * Difficult: easy
 * <link>https://leetcode.cn/problems/confusing-number/description/</link>
**/
public class Coding_1056 {


    public boolean confusingNumber(int n) {
        int[] map = new int[]{0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
        int x = n;
        int newNum = 0;

        while(x > 0){
            int item = x % 10;
            // 判断是否是易混淆数
            if (map[item] == -1){
                return false;
            }
            //新数
            newNum = newNum * 10 + map[item];
            x = x / 10;
        }
        //反转后的新数与原数相等
        if (newNum == n){
            return false;
        }
        return true;
    }

}
