package com.example.leetcode.hot100;

import java.util.*;

/**
 * @Ahthor k·Young
 * @Date 2024/10/31 15:24
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【394】 字符串解码
 * Difficulty: medium
 *
 */
public class Hot_Medium_xxx_394 {


    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     *
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     *
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     *
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     * 示例 2：
     *
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     * 示例 3：
     *
     * 输入：s = "2[abc]3[cd]ef"
     * 输出："abcabccdcdcdef"
     * 示例 4：
     *
     * 输入：s = "abc3[cd]xyz"
     * 输出："abccdcdcdxyz"
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 30
     * s 由小写英文字母、数字和方括号 '[]' 组成
     * s 保证是一个 有效 的输入。
     * s 中所有整数的取值范围为 [1, 300]
     */


    /**
     *
     *
     *
     * @param s
     * @return
     */
    public static String decodeString(String s){
        //当前倍数对应的字符串
        StringBuilder res = new StringBuilder();
        int multi = 0;
        //记录每个倍数
        Stack<Integer> multiStack = new Stack<>();
        //记录当前倍数的前缀，如果直接是以数字开头那么它的前缀是 ""
        Stack<String> prefix = new Stack<>();
        for (char c : s.toCharArray()){
            if( c >= '0' && c <= '9'){
                multi = multi * 10 + c - '0';
            }else if (c == '['){
                //将数字入栈
                multiStack.push(multi);
                multi = 0;
                //将当前数字的 字符前缀入栈，如果没有前缀，就是空字符串 ""
                prefix.push(res.toString());
                //置空， 开始积累当前数字对应的 字符
                res = new StringBuilder();
            }else if (c == ']'){
                //弹出倍数
                int count = multiStack.pop();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < count; i++){
                    //res就是要解密的字符串
                    temp.append(res);
                }
                //弹出当前数字对应的前缀，并设置当前字符
                res = new StringBuilder(prefix.pop() + temp.toString());
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }

}
