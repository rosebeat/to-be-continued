package com.example.leetcode.stack;

import java.util.Stack;

/**
 * @Ahthor k·Young
 * @Date 2024/10/30 15:06
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【678】有效的括号字符串
 * Difficulty: medium
 *
 */
public class Medium_Coding_678 {


    /**
     *
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            switch(c){
                case '(':
                    stack.push(i);
                    break;
                case '*':
                    star.push(i);
                    break;
                case ')':
                    if (!stack.isEmpty()){
                        stack.pop();
                    }else if(!star.isEmpty()){
                        star.pop();
                    }else{
                        return false;
                    }
            }
        }
        while (!stack.isEmpty() && !star.isEmpty()){
            int leftIndex = stack.pop();
            int starIndex = star.pop();
            if (starIndex < leftIndex){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
