package com.example.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kai·yang
 * @Date 2023/7/26 15:23
 *
 * leetcode: 【17】电话号码的字母组合
 * level：easy
 * <link> https://leetcode.cn/problems/letter-combinations-of-a-phone-number/solutions/388738/dian-hua-hao-ma-de-zi-mu-zu-he-by-leetcode-solutio/
 */
public class Coding_17 {

    /**
     *给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *  给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     *
     *  示例 1：
     *
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     *
     *  示例 2：
     *
     * 输入：digits = ""
     * 输出：[]
     *
     *  示例 3：
     *
     * 输入：digits = "2"
     * 输出：["a","b","c"]
     *
     *
     *  提示：
     *
     *  0 <= digits.length <= 4
     *  digits[i] 是范围 ['2', '9'] 的一个数字。
     *
     *  Related Topics 哈希表 字符串 回溯
     */


    /**
     * 回溯法
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return result;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(result, phoneMap, digits, 0, new StringBuffer());
        return result;
    }


    /**
     *
     * @param result 结果集
     * @param phoneMap 数字 字母映射
     * @param digits 电话号码
     * @param index 下标
     * @param combination
     */
    public void backtrack(List<String> result, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination){
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }
        char ch = digits.charAt(index);
        String map = phoneMap.get(ch);
        for (int i = 0; i < map.length(); i++){
            combination.append(map.charAt(i));
            backtrack(result, phoneMap, digits, index + 1, combination);
            combination.deleteCharAt(index);
        }
    }


}
