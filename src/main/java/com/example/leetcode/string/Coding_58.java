package com.example.leetcode.string;

import com.alibaba.druid.sql.visitor.functions.Char;

/**
 * @author kai·yang
 * @Date 2022/9/15 11:12
 */
public class Coding_58 {
    public static int lengthOfLastWord(String s) {
        int count = 0;
        if (s == null){
            return count;
        }
        //去掉字符串前后空格
        s = s.trim();
        char[] c  = s.toCharArray();
        for (int i = c.length -1; i >=0; i--){
            //倒叙遍历遇到第一个空格退出
            if (Character.isSpaceChar(c[i])){
                break;
            }
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }

}
