package com.example.leetcode.greedy;

/**
 * @author kai·yang
 * @Date 2023/6/9 17:35
 *
 * leetcode: 【680】验证回文串II
 * level: easy
 */
public class Coding_680 {

    /**
     *给你一个字符串 s，最多 可以从中删除一个字符。
     *  请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
     *
     *  示例 1：
     *
     * 输入：s = "aba"
     * 输出：true
     *
     *  示例 2：
     *
     * 输入：s = "abca"
     * 输出：true
     * 解释：你可以删除字符 'c' 。
     *
     *  示例 3：
     *
     * 输入：s = "abc"
     * 输出：false
     *
     *  提示：
     *
     *  1 <= s.length <= 105
     *  s 由小写英文字母组成
     *
     *  Related Topics 贪心 双指针 字符串
     */


    /**
     *
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {
        int h = 0;
        int t = s.length() -1;
        int removed = 0;
        while (t > h){
            if (s.charAt(h) == s.charAt(t)){
                h++;
                t--;
                continue;
            }
            //判断剩下的是否是 回文字串即可
            return validPalindrome(s, h + 1, t) || validPalindrome(s, h, t - 1);
        }
        return true;
    }
    public static boolean validPalindrome(String s, int h, int t) {
        while (t > h){
            if (s.charAt(h) == s.charAt(t)){
                h++;
                t--;
            }else{
                return false;
            }
        }
        return true;
    }





    public static void main(String[] args) {
        System.out.println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        System.out.println(validPalindrome("abcdefgfedcba"));
    }

}
