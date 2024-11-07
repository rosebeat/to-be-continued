package com.example.leetcode.hot100;

import java.util.Arrays;

/**
 * @Ahthor k·Young
 * @Date 2024/11/7 14:17
 * @Version 1.0
 * @Desc
 *
 * LeetCdoe: 【300】最长递增子序列
 * Difficulty: medium
 * <link>https://leetcode.cn/problems/longest-increasing-subsequence/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_Medium_xxx_300 {


    /**
     * 动态规划
     *
     *
     * 思路与算法
     *
     * 定义 dp[i] 为考虑前 i 个元素，以第 i 个数字结尾的最长上升子序列的长度，注意 nums[i] 必须被选取。
     *
     * 我们从小到大计算 dp 数组的值，在计算 dp[i] 之前，我们已经计算出 dp[0…i−1] 的值，则状态转移方程为：
     *
     * dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
     * 即考虑往 dp[0…i−1] 中最长的上升子序列后面再加一个 nums[i]。由于 dp[j] 代表 nums[0…j] 中以 nums[j] 结尾的最长上升子序列，
     * 所以如果能从 dp[j] 这个状态转移过来，那么 nums[i] 必然要大于 nums[j]，才能将 nums[i] 放在 nums[j] 后面以形成更长的上升子序列。
     *
     * 最后，整个数组的最长上升子序列即所有 dp[i] 中的最大值。
     *
     *
     * 时间复杂度：O(N^2)
     * 空间复杂度: O(N)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        //控制有边界
        for (int i = 1; i < n; i++){
            //控制左边界
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
