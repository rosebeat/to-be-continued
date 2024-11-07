package com.example.leetcode.hot100;

/**
 * @Ahthor k·Young
 * @Date 2024/11/7 10:25
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【322】零钱兑换
 * Difficulty: medium
 * <link> https://leetcode.cn/problems/coin-change/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_Medium_xxx_322 {


    /**
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     *
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     *
     * 你可以认为每种硬币的数量是无限的。
     *
     *
     *
     * 示例 1：
     *
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     * 示例 2：
     *
     * 输入：coins = [2], amount = 3
     * 输出：-1
     * 示例 3：
     *
     * 输入：coins = [1], amount = 0
     * 输出：0
     *
     *
     * 提示：
     *
     * 1 <= coins.length <= 12
     * 1 <= coins[i] <= 231 - 1
     * 0 <= amount <= 104
     */

    /**
     * F(s): 组成金额s所需要的最少硬币数量
     * [c0,c1....cn]: 可选的n枚硬币面额
     *
     * 假设知道 F(s),即组成金额s最少的硬币数， 最后一枚硬币的面额c，那么 F(s) = F(s -c) + 1
     * 但我们不知道最后一枚硬币的面值是多少，所以我们需要枚举每个硬币面额值 c0 ,c1,c2....cn−1 并选择其中的最小值
     *
     * 为了避免重复的计算，我们将每个子问题的答案存在一个数组中进行记忆化，如果下次还要计算这个问题的值直接从数组中取出返回即可，这样能保证每个子问题最多只被计算一次
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0){
            return -1;
        }
        return dfs(coins, amount, new int[amount + 1]);
    }

    /**
     * memo[n] 表示金额n可以换取的最少硬币数，不能换取就是-1；
     * @param coins
     * @param amount
     * @param memo
     * @return
     */
    public int dfs(int[] coins, int amount, int[] memo){
        //不符合返回 -1
        if (amount < 0){
            return -1;
        }
        //金额为0 说明不需要兑换
        if (amount == 0){
            return 0;
        }
        //记忆化搜索，将出现过的金额对应的次数缓存
        if (memo[amount] != 0){
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins){
            int res = dfs(coins, amount - coin, memo);
            if (res >= 0 && res < min){
                //这里的加 1 是要加上得到 res结果那一步骤中，兑换的一个硬币
                min = res + 1;
            }
        }
        memo[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return memo[amount];
    }

}
