package com.example.leetcode.hot100;

/**
 * @Ahthor k·Young
 * @Date 2024/11/1 17:56
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【34】在排序数组中查找元素的第一个和最后一个位置
 * Difficulty: medium
 * Tag: 二分
 *
 */
public class Hot_Medium_xxx_34 {


    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     *
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     *
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 示例 2：
     *
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * 示例 3：
     *
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     *
     *
     * 提示：
     *
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * nums 是一个非递减数组
     * -109 <= target <= 109
     */

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int left = search(nums, target);
        if(left == nums.length || nums[left] != target){
            return new int[]{-1, -1};
        }
        //找到比 （target + 1） 大的数下标，然后减一 就是 target右侧下标
        //因为 search 找的是 最左侧的下标，要找右侧的（target + 1）的下标然后 减一，就是右侧下标
        int right = search(nums, target + 1) - 1;
        return new int[]{left, right};
    }


    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] >= target){
                right = mid - 1;
            }else{
                left = mid - 1;
            }
        }
        return left;
    }

}
