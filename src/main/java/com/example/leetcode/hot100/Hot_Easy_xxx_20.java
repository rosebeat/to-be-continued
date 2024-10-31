package com.example.leetcode.hot100;

import java.util.Stack;

/**
 * @Ahthor k·Young
 * @Date 2024/10/31 14:23
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【20】有效括号数
 * Difficult: easy
 *
 */
public class Hot_Easy_xxx_20 {


    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     *
     *
     * 示例 1：
     *
     * 输入：s = "()"
     *
     * 输出：true
     *
     * 示例 2：
     *
     * 输入：s = "()[]{}"
     *
     * 输出：true
     *
     * 示例 3：
     *
     * 输入：s = "(]"
     *
     * 输出：false
     *
     * 示例 4：
     *
     * 输入：s = "([])"
     *
     * 输出：true
     *
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 104
     * s 仅由括号 '()[]{}' 组成
     */

    /**
     * 压栈
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s ==null || s.length() % 2 == 1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if ('(' == c ){
                stack.push(')');
            }else if('{' == c){
                stack.push('}');
            }else if('[' == c){
                stack.push(']');
            }else if( stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }


}
