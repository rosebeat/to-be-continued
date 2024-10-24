package com.example.leetcode.hot100;

import com.alibaba.fastjson2.JSON;

import java.util.*;

/**
 * @Ahthor k·Young
 * @Date 2024/10/24 14:26
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【17】电话号码组合
 * Difficulty: medium
 * <linkL>https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=top-100-liked</linkL>
 *
 */
public class Hot_xxx_17 {


    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * 示例 1：
     *
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * 示例 2：
     *
     * 输入：digits = ""
     * 输出：[]
     * 示例 3：
     *
     * 输入：digits = "2"
     * 输出：["a","b","c"]
     */

    static Map<Character, List<String>> words = new HashMap<>();
    static{
        words.put('2', Arrays.asList("a", "b", "c"));
        words.put('3', Arrays.asList("d", "e", "f"));
        words.put('4', Arrays.asList("h", "i", "g"));
        words.put('5', Arrays.asList("j", "k", "l"));
        words.put('6', Arrays.asList("m", "n", "o"));
        words.put('7', Arrays.asList("p", "q", "r", "s"));
        words.put('8', Arrays.asList("t", "u", "v"));
        words.put('9', Arrays.asList("w", "x", "y", "z"));
    }


    /**
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return res;
        }
        backtrack(digits, 0, res,new StringBuilder());
        return res;
    }


    /**
     *
     * @param digits 电话号码
     * @param index 要处理数字的下表
     * @param res 结果集
     * @param comb 每一种结果
     */
    public static void backtrack(String digits, int index, List<String> res, StringBuilder comb){
        if (index == digits.length()){
            res.add(comb.toString());
            return;
        }

        char c = digits.charAt(index);
        List<String> w = words.get(c);
        //遍历每一种 数字对应的字符
        for (int i = 0; i < w.size(); i++){
            comb.append(w.get(i));
            //递归控制深度（也就是拼接完一种情况）
            backtrack(digits, index + 1, res, comb);
            //回溯，删除添加的字符
            comb.deleteCharAt(index);
        }

    }


    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(Hot_xxx_17.letterCombinations("23")));
    }

}


