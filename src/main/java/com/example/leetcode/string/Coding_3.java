package com.example.leetcode.string;


import java.util.HashMap;
import java.util.Map;

/**
 * @author kai·yang
 * @Date 2021/8/11 15:09
 */
public class Coding_3 {


    /**
     * 3：无重复字符的最长字串
     * 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }
}
