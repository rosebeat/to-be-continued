package com.example.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: kai·yang
 * @Date: 2024/6/14 11:43
 * @Description:
 *
 * @LeetCode 【438】找到字符串中所有字母异位词
 * @difficulty medium
 * <link> https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_xxx_438 {


    /**
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     *
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
     *
     *
     * 示例 1:
     *
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     *  示例 2:
     *
     * 输入: s = "abab", p = "ab"
     * 输出: [0,1,2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
     *
     *
     * 提示:
     *
     * 1 <= s.length, p.length <= 3 * 104
     * s 和 p 仅包含小写字母
     */


    /**
     * 思路：
     *      1、找到所以异位词的 起始位置索引 k，那么    0 <= k <= (s.length - p.length) + 1
     *      2、在这个区间上，从0开始截取 p.length长度的字符串 item ，然后排序与p做 equal 比较
     *      3、
     *
     *
     *
     * todo 需要优化
     *
     * @param s
     *          给定字符串
     * @param p
     *          子串
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        //合法性校验
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()){
            return result;
        }
        char[] pChars = p.toCharArray();
        //对字符进行排序
        Arrays.sort(pChars);
        String pNew = new String(pChars);
        int pl = p.length();
        //依次改变左窗口位置
        for (int i = 0; i < s.length() - pl + 1; i++ ){
            //一次截取 pl 长度的字串, 排序后判断两字符串是否相等 --->>>  固定窗口问题
            String n = newItemString(s, i, i + pl);
            if (pNew.equals(n)){
                result.add(i);
            }
        }
        return result;
    }

    public static String newItemString(String s, int start, int end){
        char[] chars = s.substring(start, end).toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

}
