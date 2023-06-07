package com.example.leetcode.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kai·yang
 * @Date 2023/5/5 14:30
 *
 * leetcode：【409】最长回文字串
 * level：easy
 */
public class Coding_409 {


    /**
     *问题描述：
     *  给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回
     *    在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
     *
     *    示例 1:
     *
     *   输入:s = "abccccdd"
     *   输出:7
     *   解释:
     *   我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     *
     *    示例 2:
     *
     *   输入:s = "a"
     *   输出:1
     *
     *    示例 3：
     *
     *   输入:s = "aaaaaccc"
     *   输出:7
     *
     *    提示:
     *
     *    1 <= s.length <= 2000
     *    s 只由小写 和/或 大写英文字母组成
     *
     *
     * 思路：
     *    回文串是一个正着读和反着读都一样的字符串。以回文中心为分界线，
     *    1、当长度为偶数时所有元素出现的个数都为偶数， abba
     *    2、当长度为奇数时所有元素中只有一种元素个数为奇数，abcba
     *
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        if (s == null || s.length() ==0){
            return 0;
        }
        int result = 0;
        //使用哈希表记录字符出现次数
        Map<Character, Integer> count = new HashMap<>(16);
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> item : count.entrySet()){
            result += item.getValue() / 2 * 2;
            //这里取一个元素为奇数的
            if (item.getValue() % 2 == 1 && result % 2 ==0){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
}
