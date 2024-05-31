package com.example.leetcode.hot100;

import com.alibaba.fastjson2.JSON;

/**
 * @author: kai·yang
 * @Date: 2024/5/31 14:49
 * @Description:
 *
 * LeetCode: 【283】移动零
 * Difficulty: medium
 * <link>https://leetcode.cn/studyplan/top-100-liked/
 */
public class Hot_004_283 {

    /**
     * 问题描述：
     *  给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     *  请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     *
     *
     *
     *  示例 1:
     *
     *  输入: nums = [0,1,0,3,12]
     *  输出: [1,3,12,0,0]
     *  示例 2:
     *
     *  输入: nums = [0]
     *  输出: [0]
     *
     *
     *  提示:
     *
     *  1 <= nums.length <= 104
     *  -231 <= nums[i] <= 231 - 1
     *
     *
     * 进阶：你能尽量减少完成的操作次数吗？
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1){
            return;
        }
        //为0 区间的左边界
        int zeroLeft = 0;
        //为0 区间的右边界
        int zeroRight = 0;
        for (zeroRight = 0; zeroRight < nums.length ; zeroRight++){
           if (nums[zeroRight] != 0) {
               swap2(zeroLeft, zeroRight, nums);
               zeroLeft++;
           }
        }

    }

    /**
     * 交换位置
     * @param x
     * @param y
     * @param nums
     */
    public static void swap(int x, int y, int[] nums){
        // 异或操作 都是0或者都是1 异或运算的结果是0,
        // 位运算满足交换律
        // 相同两个数异或等于 0
        // 0 与任何数异或 都等于任何数

        nums[x] = nums[x] ^ nums[y];
        nums[y] = nums[x] ^ nums[y];
        nums[x] = nums[x] ^ nums[y];
    }

    public static void swap2(int x, int y, int[] nums){
        int item = nums[x];
        nums[x] = nums[y];
        nums[y] = item;
    }


    public static void main(String[] args) {
//        int[] nums = {0,1,0,3,12};
        int[] nums = {1, 0};
        moveZeroes(nums);
        System.out.println(JSON.toJSONString(nums));
    }

}
