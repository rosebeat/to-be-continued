package com.example.interview.bytedance;

import java.util.Arrays;

/**
 * @Ahthor k·Young
 * @Date 2024/10/28 11:26
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【169】多数元素
 * Difficulty: easy
 */
public class Coding_169 {


    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [3,2,3]
     * 输出：3
     * 示例 2：
     *
     * 输入：nums = [2,2,1,1,1,2,2]
     * 输出：2
     *
     *
     * 提示：
     * n == nums.length
     * 1 <= n <= 5 * 104
     * -109 <= nums[i] <= 109
     *
     *
     * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
     */


    /**
     * 摩尔投票法:
     *  如果把众数的票数记为 +1， 非众数的票数几位 -1， 则一定有所有数字的 票数和 > 0
     *
     *  算法流程：
     *      1. 票数统计 votes = 0， 众数 x
     *      2. 遍历数组 nums 中的每一个元素item
     *         a. 当 votes等于0，则设当前数字为众数
     *         b. 当 x == item时，票数votes 自增1； 当 x != item时，votes减一
     *      3. 最后x就是众数
     *
     * @param nums
     * @return
     */
    public int majorityElementV1(int[] nums) {
        //众数
        int x = -1;
        //票数
        int votes = 0;
        for(int item : nums){
            if (votes == 0){
                x = item;
            }
            votes += x == item ? 1 : -1;
        }
        return x;
    }


    /**
     * 排序法
     *  将数组nums中的所有元素按照升序或者降序排序，那么下表 n/2 的元素一定是众数
     *  因为题目中规定 超过 n/2 数量的数为众数
     *
     * @param nums
     * @return
     */
    public int majorityElementV2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

}
