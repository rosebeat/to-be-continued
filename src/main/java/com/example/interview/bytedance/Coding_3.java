package com.example.interview.bytedance;

import java.util.HashSet;
import java.util.Set;

/**
 * @Ahthor k·Young
 * @Date 2024/10/28 13:09
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【3】无重复的最长字串
 * Difficulty: medium
 *
 */
public class Coding_3 {


    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
     * 子串
     *  的长度。
     *
     *
     *
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     *
     * 提示：
     *
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     */


    /**
     *
     * 滑动窗口
     *
     *
     *
     *
     *
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> sub = new HashSet<>();
        int max = 0;
        int left = 0;
        //控制窗口的有边界
        for (int right = 0; right < s.length(); right++){
            //控制窗口的左边界
            while(sub.contains(s.charAt(right))){
                sub.remove(s.charAt(left));
                left++;
            }
            sub.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
