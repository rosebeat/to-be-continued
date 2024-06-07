package com.example.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;


/**
 * @author: kai·yang
 * @Date: 2024/6/5 11:44
 * @Description:
 *
 *
 * LeetCode: 【3】无重复字符的最长子串
 * Difficulty：medium
 * <link>https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_xxx_3 {


    /**
     * todo 不知道是否是最优解，需要在验证
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int maxLen = 0;
        //左指针
        int l = 0;
        //
        int r = 0;
        List<Character> list = new ArrayList<>();
        while(r < s.length()){
            if (!list.contains(s.charAt(r))){
                list.add(s.charAt(r));
                r++;
            }else{
                maxLen = Math.max(maxLen, list.size());
                list.remove(0);
                l++;
            }

        }
        return Math.max(maxLen, list.size());
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

}
