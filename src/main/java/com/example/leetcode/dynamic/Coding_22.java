package com.example.leetcode.dynamic;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: kai·yang
 * @Date: 2024/3/25 17:19
 * @Description:
 *
 * LeetCode: 【22】括号生成
 * Difficulty: medium
 * <link> https://leetcode.cn/problems/generate-parentheses/description/
 */
public class Coding_22 {


    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, new StringBuilder(), 0, 0, n);
        System.out.println(JSON.toJSONString(result));
        return result;
    }


    /**
     * 递归 + 回溯
     * @param result
     * @param sb
     * @param left
     * @param right
     * @param max
     */
    public static void dfs(List<String> result, StringBuilder sb, int left, int right, int max){
        if (left == max && right == max){
            result.add(sb.toString());
            return;
        }
        //left 小于 max 可以一直先放左括号
        if (left < max ){
            dfs(result, sb.append("("), left + 1, right, max);
            sb.deleteCharAt(sb.length() - 1);
        }
        // 之后放置 左括号的数量大于 右括号的数量才可以放右括号
        if (left > right){
            dfs(result, sb.append(")"), left, right + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }

}
