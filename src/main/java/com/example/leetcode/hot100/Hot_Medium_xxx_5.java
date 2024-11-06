package com.example.leetcode.hot100;

/**
 * @Ahthor k·Young
 * @Date 2024/11/5 15:02
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【5】 最长回文字串
 * Difficulty: medium
 * <link> https://leetcode.cn/problems/longest-palindromic-substring/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_Medium_xxx_5 {


    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串
     *
     * 示例 1：
     *
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     *
     *
     * 示例 2：

     * 输入：s = "cbbd"
     * 输出："bb"
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母组成
     */


    /**
     * 动态规划
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2){
            return s;
        }
        int maxLen = 0;
        int begin = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        //枚举回文子串的长度
        for (int L = 2; L <= n; L++){
            //枚举左边界，有边界可以通过长度和左边界计算出来  L = right - left + 1    ==>>  right = L + left - 1
            for (int i = 0; i < n; i++){
                int endIndex = L + i - 1;
                //结束位置越界，直接跳出当前循环
                if (endIndex >= n){
                    break;
                }
                if (s.charAt(i) != s.charAt(endIndex)){
                    dp[i][endIndex] = false;
                }else{
                    if ( endIndex - i < 3){
                        dp[i][endIndex] = true;
                    }else{
                        dp[i][endIndex] = dp[i - 1][endIndex - 1];
                    }
                }
                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][endIndex] && (endIndex - i + 1) > maxLen){
                    maxLen = endIndex - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    /**
     * 中心扩展算法
     * @param s
     * @return
     */
    public String longestPalindromeV2(String s) {
        if (s == null || s.length() < 2){
            return s;
        }
        int n = s.length();
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++){
            //回文串为奇数的情况
            int one = expend(s, i, i);
            //回文串为偶数的情况
            int two = expend(s, i, i + 1);
            int len = Math.max(one, two);
            if (len > start - end){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }

        }
        return s.substring(start, end + 1);
    }


    /**
     *
     * @param s
     * @param left 左边界
     * @param right 有边界
     * @return 间隔元素个数
     */
    public int expend(String s, int left, int right){
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }


}
