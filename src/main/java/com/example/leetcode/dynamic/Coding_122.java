package com.example.leetcode.dynamic;

/**
 * @author: kai·yang
 * @Date: 2024/3/27 16:34
 * @Description:
 *
 * LeetCode: 【122】 买卖股票的最佳时机II
 * Difficulty: medium
 * <link>https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class Coding_122 {

    public int maxProfit(int[] prices) {
        if (prices.length < 2){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        //dp[i][0] 表示第i天交易完成后 不持有股票 的收益
        //dp[i][1] 表示第i天交易完成后 持有股票 的收益
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        /*
            1、第 i 天不持有股票
                如果这一天交易完后手里没有股票，那么可能的转移状态为前一天已经没有股票，即 dp[i−1][0]，
                或者前一天结束的时候手里持有一支股票，即 dp[i−1][1]，这时候我们要将其卖出，并获得 prices[i]的收益
                因此为了收益最大化 dp[i][0] = Max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            2、第 i 天持有股票
                如果这一天持有股票，那么可能的状态为前一天 已经持有的股票，即 dp[i - 1][1],
                或者前一天结束的时候没有持有股票，即 dp[i - 1][0], 这时候我们买入i天股票，并减少prices[i]的收益
                因此最大收益 dp[i][1] = Max(dp[i - 1][1], dp[i -1][0] - prices[i]);

         */
        for( int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i -1][0] - prices[i]);
        }
        return dp[prices.length -1][0];
    }

}
