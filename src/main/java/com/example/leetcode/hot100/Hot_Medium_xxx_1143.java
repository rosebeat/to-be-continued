package com.example.leetcode.hot100;

/**
 * @Ahthor k·Young
 * @Date 2024/11/5 9:34
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【1143】最长公共子序列
 * Difficulty: medium
 *
 * 最经典的最长公共子序列（LCS）模板题
 *
 */
public class Hot_Medium_xxx_1143 {


    /**
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
     *
     * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     *
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
     *
     *
     *
     * 示例 1：
     *
     * 输入：text1 = "abcde", text2 = "ace"
     * 输出：3
     * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
     * 示例 2：
     *
     * 输入：text1 = "abc", text2 = "abc"
     * 输出：3
     * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
     * 示例 3：
     *
     * 输入：text1 = "abc", text2 = "def"
     * 输出：0
     * 解释：两个字符串没有公共子序列，返回 0 。
     *
     *
     * 提示：
     *
     * 1 <= text1.length, text2.length <= 1000
     * text1 和 text2 仅由小写英文字符组成。
     */

    /**
     *
     * 最长公共子序列问题是典型的二维动态规划问题
     * 动态规划（利用偏移）
     *
     * f[i][j] 代表考虑 s1 的前 i−1 个字符、考虑 s2 的前 j−1 的字符，形成的最长公共子序列长度。
     *
     * 那么最终的 f[n][m] 就是我们的答案，f[0][0] 当做无效值，不处理即可。
     *
     * s1[i-1]==s2[j-1] : f[i][j]=f[i−1][j−1]+1。代表使用 s1[i−1] 与 s2[j−1]形成最长公共子序列的长度。
     * s1[i-1]!=s2[j-1] : f[i][j]=max(f[i−1][j],f[i][j−1])。代表不使用 s1[i−1] 形成最长公共子序列的长度、不使用 s2[j−1] 形成最长公共子序列的长度。这两种情况中的最大值。
     *
     * 动态规划的边界情况：
     *    a. 当 i=0 时，text1[0:i] 为空，空字符串和任何字符串的最长公共子序列的长度都是 0，因此对任意 0≤j≤n，有 dp[0][j]=0；
     *    b. 当 j=0 时，text1[0:j] 为空，同理可得，对任意 0≤i≤m，有 dp[i][0]=0。
     *   因此动态规划的边界情况是：当 i=0 或 j=0 时，dp[i][j]=0。
     *
     *   当 i>0 且 j>0 时，考虑 dp[i][j] 的计算：
     *      a. 当 text1[i−1]=text2[j−1] 时，将这两个相同的字符称为公共字符，考虑 text1[0:i−1] 和 text2[0:j−1] 的最长公共子序列，
     *         再增加一个字符（即公共字符）即可得到 text1[0:i] 和 text2[0:j] 的最长公共子序列，因此 dp[i][j]=dp[i−1][j−1]+1。
     *      b. 当 text1[i−1] != text2[j−1] 时，考虑以下两项：
     *          1. text1[0:i−1] 和 text2[0:j] 的最长公共子序列；
     *          2. text1[0:i] 和 text2[0:j−1] 的最长公共子序列
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        char[] cs1 = text1.toCharArray();
        char[] cs2 = text2.toCharArray();
        for (int i = 1; i <= n; i++){
            for( int j = 1; j <= m; j++){
                if (cs1[i - 1] == cs2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

}
