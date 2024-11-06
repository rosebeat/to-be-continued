package com.example.leetcode.hot100;

/**
 * @Ahthor k·Young
 * @Date 2024/11/6 17:14
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【136】只出现一次的数字
 * Difficulty: easy
 * <link> https://leetcode.cn/problems/single-number/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_Easy_xxx_136 {

    /**
     * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
     *
     *
     *
     * 示例 1 ：
     *
     * 输入：nums = [2,2,1]
     * 输出：1
     * 示例 2 ：
     *
     * 输入：nums = [4,1,2,1,2]
     * 输出：4
     * 示例 3 ：
     *
     * 输入：nums = [1]
     * 输出：1
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 3 * 104
     * -3 * 104 <= nums[i] <= 3 * 104
     * 除了某个元素只出现一次以外，其余每个元素均出现两次。
     */


    /**
     * 异或操作，相同数字异或 等于 0；
     * 0 异或任何数 等于 本身
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int x : nums){
            res ^= x;
        }
        return res;
    }

}
