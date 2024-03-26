package com.example.leetcode.dynamic;

/**
 * @author: kai·yang
 * @Date: 2024/3/26 15:39
 * @Description:
 *
 * LeetCode: 【5】最长回文子串
 * Difficulty：medium
 * <link>https://leetcode.cn/problems/longest-palindromic-substring/description/
 */
public class Coding_5 {


    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *  如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     *
     *  示例 1：
     *
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     *
     *  示例 2：
     *
     * 输入：s = "cbbd"
     * 输出："bb"
     *
     *
     *  提示：
     *
     *  1 <= s.length <= 1000
     *  s 仅由数字和英文字母组成
     *
     *  Related Topics 字符串 动态规划
     *  👍 7122 👎 0
     */


    /**
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2){
            return s;
        }
        //回文字串起始位置
        int begin = 0;
        //最大长度
        int maxL = 1;
        //dp[i][j] 表示 s[i...j] 是回文子串
        boolean dp[][] = new boolean[n][n];
        //长度为1 都是回文字串
        for (int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        //枚举长度从2开始
        for(int L = 2; L <= n; L++){
            //起始位置
            for (int i = 1; i < n; i++){
                //结束边界，  L = j - i + 1
                int j = L + i - 1;
                //结束边界，越界
                if (j >= n){
                    break;
                }

                if (chars[i] != chars[j]){
                    dp[i][j] = false;
                } else{
                    if( j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxL){
                    begin = i;
                    maxL = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxL);
    }


}
