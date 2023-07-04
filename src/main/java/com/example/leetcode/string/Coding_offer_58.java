package com.example.leetcode.string;

import org.springframework.util.StringUtils;

/**
 * @author kai·yang
 * @Date 2023/7/4 15:05
 *
 * 剑指Offer：【58】左旋转字符串
 * level：easy
 * <link>https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 *
 */
public class Coding_offer_58 {

    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋
     * 将返回左旋转两位得到的结果"cdefgab"。
     *
     *  示例 1：
     *  输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     *
     *  示例 2：
     *  输入: s = "lrloseumgh", k = 6
     * 输出: "umghlrlose"
     *
     *
     *  限制：
     *
     *  1 <= k < s.length <= 10000
     *
     *  Related Topics 数学 双指针 字符串
     */


    /**
     * 不适用jdk自带的api
     *
     * 先对 0-n 位置进行反转，在对 （n+1）-- s.length() 进行反转，最后对整体进行反转
     *
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords(String s, int n) {
        String front = reverse(s, 0, n);
        String back = reverse(s, n, s.length());
        String reverse = reverse(front + back, 0, s.length());
        return reverse;
    }


    public static String reverse(String s, int start, int end){
        StringBuilder sb = new StringBuilder();
        while(start <= --end){
            sb.append(s.charAt(end));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
    }
}
