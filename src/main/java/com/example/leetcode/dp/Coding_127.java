package com.example.leetcode.dp;

public class Coding_127 {

    /**
     * 121 买卖股票最佳时机
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //最大收益
        int maxPrices = 0;
        //int curPrices = 0;
        //开始买入的价格
        int target = prices[0];
        for(int i = 1; i < prices.length; i++){
            //当前价格 - 前一天价格 > 当前价格 - 开始买入的价格，则将开始买入的价格替换为前一天价格
            if(prices[i] - prices[i-1] > prices[i] - target){
                target = prices[i-1];
            }
            //int curMax = Math.max(prices[i] - prices[i-1], prices[i] - target)
            //比较最大收益
            maxPrices = Math.max(maxPrices, prices[i] - target);

        }
        return maxPrices;
    }

}
