package com.example.leetcode.stack;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.Stack;

/**
 * @author kai·yang
 * @Date 2022/4/11 10:48
 *
 *  题目： 【20】有效的括号
 *  难度：  easy
 */
public class Coding_20 {


    /**
     * 解题思路：利用栈的先进后出原理
     * 遍历所有字符，遇到左括号入栈，遇到右括号尝试与栈顶元素匹配，匹配成功则出栈，匹配失败则遇到无法匹配的右括号，直接返回false。
     * 如果全部成功匹配，即所有括号都合法，则栈是空的
     *
     * @param s
     * @return
     */
    public boolean isValid(String s){
        if (s == null){
            return false;
        }
        Stack<Character> parenthesisStack = new Stack<>();
        for (char ch : s.toCharArray()){
            if (ch == '{' || ch == '(' || ch == '['){
                parenthesisStack.push(ch);
            }else if (!parenthesisStack.empty()){
                Character top = parenthesisStack.peek();
                if (top == '{' && ch == '}'){
                    parenthesisStack.pop();
                }else if (top == '(' && ch == ')'){
                    parenthesisStack.pop();
                }else if (top == '[' && ch == ']'){
                    parenthesisStack.pop();
                }else{
                    return false;
                }
            }else {
                return false;
            }
        }
        return parenthesisStack.empty();
    }
}
