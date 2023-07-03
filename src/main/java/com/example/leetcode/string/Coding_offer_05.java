package com.example.leetcode.string;

/**
 * @author kai·yang
 * @Date 2023/7/3 16:14
 *
 * 剑指 offer：【5】替换空格
 * level：easy
 *
 */
public class Coding_offer_05 {

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     *
     *  示例 1：
     *  输入：s = "We are happy."
     * 输出："We%20are%20happy."
     *
     *  限制：
     *  0 <= s 的长度 <= 10000
     *  Related Topics 字符串
     */

    public static String replaceSpace(String s) {
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++){
            if (ch[i] == 32){
                sb.append("%20");
            }else{
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        char c = ' ';
        int a = c;
        System.out.println(a);
        System.out.println(replaceSpace("We are happy."));
        System.out.println("We are happy.".replaceAll(" ", "%20"));
    }
}
