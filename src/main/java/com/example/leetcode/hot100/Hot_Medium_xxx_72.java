package com.example.leetcode.hot100;

/**
 * @Ahthor k·Young
 * @Date 2024/11/8 9:39
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【72】编辑距离
 * Difficulty: medium
 * <link>https://leetcode.cn/problems/edit-distance/description/?envType=study-plan-v2&envId=top-100-liked</link>
 *
 *
 * 编辑距离算法被数据科学家广泛应用，是用作机器翻译和语音识别评价标准的基本算法
 */
public class Hot_Medium_xxx_72 {


    /**
     * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
     *
     * 你可以对一个单词进行如下三种操作：
     *
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     *
     *
     * 示例 1：
     *
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     * 示例 2：
     *
     * 输入：word1 = "intention", word2 = "execution"
     * 输出：5
     * 解释：
     * intention -> inention (删除 't')
     * inention -> enention (将 'i' 替换为 'e')
     * enention -> exention (将 'n' 替换为 'x')
     * exention -> exection (将 'n' 替换为 'c')
     * exection -> execution (插入 'u')
     *
     *
     * 提示：
     *
     * 0 <= word1.length, word2.length <= 500
     * word1 和 word2 由小写英文字母组成
     */


    /**
     * 如上所述，当我们获得 D[i][j-1]，D[i-1][j] 和 D[i-1][j-1] 的值之后就可以计算出 D[i][j]。
     *  分三种情况：
     *
     *  1、 D[i][j-1] 为 A 的前 i 个字符和 B 的前 j - 1 个字符编辑距离的子问题。即对于 B 的第 j 个字符，我们在 A 的末尾添加了一个相同的字符，那么 D[i][j] 最小可以为 D[i][j-1] + 1；
     *
     *  2、 D[i-1][j] 为 A 的前 i - 1 个字符和 B 的前 j 个字符编辑距离的子问题。即对于 A 的第 i 个字符，我们在 B 的末尾添加了一个相同的字符，那么 D[i][j] 最小可以为 D[i-1][j] + 1；
     *
     *  3、 D[i-1][j-1] 为 A 前 i - 1 个字符和 B 的前 j - 1 个字符编辑距离的子问题。即对于 B 的第 j 个字符，我们修改 A 的第 i 个字符使它们相同，那么 D[i][j] 最小可以为 D[i-1][j-1] + 1。特别地，如果 A 的第 i 个字符和 B 的第 j 个字符原本就相同，那么我们实际上不需要进行修改操作。在这种情况下，D[i][j] 最小可以为 D[i-1][j-1]。
     *
     * 那么我们可以写出如下的状态转移方程：
     *
     *  若 A 和 B 的最后一个字母相同：
     *
     *      D[i][j] = min(D[i][j−1]+1, D[i−1][j]+1, D[i−1][j−1]) = 1+min(D[i][j−1], D[i−1][j], D[i−1][j−1]−1)
     *
     *  若 A 和 B 的最后一个字母不同：
     *
     *      D[i][j]=1+min(D[i][j−1],D[i−1][j],D[i−1][j−1])
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n * m == 0){
            return n + m;
        }
        //dp[i][j] 代表 w1前i个字符  w2前j个字符，最短的编辑距离
        int[][] dp = new int[n + 1][m + 1];
        //边界处理
        //初始化，当其中一个字符串为空是，最小的操作次数就是，另一个字符串的长度
        for (int i = 1; i <= n; i++){
            dp[i][0] = i;
        }
        //初始化，当其中一个字符串为空是，最小的操作次数就是，另一个字符串的长度
        for(int j = 1; j <= m; j++){
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int add = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    ++add;
                }
                dp[i][j] = Math.min(add, Math.min(left, down));
            }
        }
        return dp[n][m];
    }

}
