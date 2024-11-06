package com.example.leetcode.hot100;

/**
 * @Ahthor k·Young
 * @Date 2024/11/6 9:37
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【647】回文子串
 * Difficulty: medium
 * <link> https://leetcode.cn/problems/palindromic-substrings/description/
 *
 */
public class Hot_Medium_xxx_647 {

    /**
     * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
     *
     * 回文字符串 是正着读和倒过来读一样的字符串。
     *
     * 子字符串 是字符串中的由连续字符组成的一个序列。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     * 示例 2：
     *
     * 输入：s = "aaa"
     * 输出：6
     * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 由小写英文字母组成
     *
     *
     */

    /**
     * 动态规划：
     *  1、使用一个二维数组dp[i][j] 代表字符出 s 下标i到j是否是回文的，
     *  2、dp[i][j] 是否是回文的，需要依赖 dp[i + 1][j - 1]是否是回文的
     *      a. 如果si != sj 那么dp[i][j] 必然不是回文的
     *      b. 如果 si == sj，需要分三中情况讨论
     *          1) i == j, 也就是同一个字符，那么dp[i][j] 必然是回文的
     *          2) j - i = 1, 也就是i 和 j 相邻，那么dp[i][j] 也是回文的
     *          3) j - i > 1, 那么dp[i][j]是否是回文，需要依赖dp[i + 1][j - 1]是否是回文的
     *              如果是，dp[i][j] 也是回文
     *              如果否，dp[i][j] 不是回文
     *
     *  遍历顺序，因为 dp[i][j], 要依赖dp[i + 1][j - 1], 即dp[i][j]在 dp[i + 1][j - 1] 的右上角
     *  所以遍历要从下向上，从左向右遍历（或者是先遍历列，再遍历行），保证依赖的 dp[i + 1][j - 1]已经被计算过,并且要保证字符串合法（i <= j）
     *
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >=0; i--){
            for (int j = i; j < n; j++){
                if (s.charAt(i) == s.charAt(j)){
                    if (j - i <= 1){
                        dp[i][j] = true;
                        res++;
                    }else if(dp[i + 1][j - 1]){
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }

}
