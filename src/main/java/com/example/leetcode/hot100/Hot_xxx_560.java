package com.example.leetcode.hot100;

import java.util.HashMap;

/**
 * @author: kai·yang
 * @Date: 2024/6/24 16:27
 * @Description:
 *
 *
 * @LeetCode: 【560】和为K的子数组
 * @Difficulty: medium
 * <link>https://leetcode.cn/problems/subarray-sum-equals-k/solutions/247577/bao-li-jie-fa-qian-zhui-he-qian-zhui-he-you-hua-ja/?envType=study-plan-v2&envId=top-100-liked
 *
 * 前缀和
 *
 */
public class Hot_xxx_560 {


    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
     *
     * 子数组是数组中元素的连续非空序列。
     *
     * 示例 1：
     *
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     * 示例 2：
     *
     * 输入：nums = [1,2,3], k = 3
     * 输出：2
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 2 * 104
     * -1000 <= nums[i] <= 1000
     * -107 <= k <= 107
     */



    /**
     * 效率太低
     * 枚举 + 前缀和
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int len = nums.length;

        int[] prefixSum = new int[len + 1];
        //计算前缀和
        for (int i = 0; i < len; i++){
            prefixSum[i + 1] = prefixSum[i] + nums[i];

        }
        int count = 0;

        for(int i = 0; i < len; i++){
            for (int j = i; j < len; j++){
                if (prefixSum[j + 1] - prefixSum[i] == k){
                    count++;
                }
            }
        }

        return count;
    }


    /**
     *  前缀和 + hash表
     *
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySumV2(int[] nums, int k){
        int count = 0;
        int pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        //每个不同的前缀和 肯定有1个存在，就是本身
        mp.put(0,1);
        for (int item : nums){
            pre += item;
            if (mp.containsKey(pre - k)){
                count += mp.get(pre - k);
            }
            //mp.getOrDefault(pre, 0), 是因为 从起点到当前位置 可能存在多个结束点的前缀和都为 pre 的
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }




    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(subarraySumV2(nums, 2));
    }

}
