package com.example.leetcode.hot100;

import java.util.Arrays;

/**
 * @Ahthor k·Young
 * @Date 2024/11/7 11:37
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【279】完全平方数
 * Difficulty: medium
 * <link> https://leetcode.cn/problems/perfect-squares/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_Medium_xxx_279 {

    /**
     * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
     *
     * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 12
     * 输出：3
     * 解释：12 = 4 + 4 + 4
     * 示例 2：
     *
     * 输入：n = 13
     * 输出：2
     * 解释：13 = 4 + 9
     *
     * 提示：
     *
     * 1 <= n <= 104
     */


    /**
     *
     * 动态规划：
     *  首先初始化长度为 n+1 的数组 dp，每个位置都为 Integer.Max
     *  如果 n 为 0，则结果为 0
     *  对数组进行遍历，下标为 i，每次都将当前数字先更新为最大的结果，即 dp[i]=i，比如 i=4，最坏结果为 4=1+1+1+1 即为 4 个数字
     *  动态转移方程为：dp[i] = MIN(dp[i], dp[i - j * j] + 1)，i 表示当前数字，j*j 表示平方数
     *  时间复杂度：O(n∗sqrt(n))，sqrt 为平方根
     *

     * @param n
     * @return
     */
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        //初始化最大值
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        //遍历里计算 1 ~ n 完全平方数的和 最小个数
        for (int i = 1; i <= n; i++){
            for (int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(3));
    }
}
