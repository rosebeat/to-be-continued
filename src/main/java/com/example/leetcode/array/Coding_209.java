package com.example.leetcode.array;

/**
 * @author kai·yang
 * @Date 2023/6/27 14:50
 *
 * leetcode: 【209】 长度最小的子数组
 * level：medium
 *
 */
public class Coding_209 {


    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     *  找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-
     * 度。如果不存在符合条件的子数组，返回 0 。
     *
     *  示例 1：
     *
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     *
     *  示例 2：
     *
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     *
     *  示例 3：
     *
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     *
     *
     *  提示：
     *
     *  1 <= target <= 109
     *  1 <= nums.length <= 105
     *  1 <= nums[i] <= 105
     *
     *
     *  进阶：
     *
     *  如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
     *
     *  Related Topics 数组 二分查找 前缀和 滑动窗口
     */


    /**
     * 滑动窗口
     *
     * 定义两个指针 start 和 end 代表窗口的开始位置和结束位置， sum 代表 nums[start] 到 nums[end]的元素和
     *
     * 初始位置start end 都指向 下标 0 位置
     * 每次迭代，将nums[end] 加到 sum 中
     *      1、如果此时 sum >= target, 则更新数组的最小长度（ 此时最小长度 end - start + 1）
     *      2、将 start 指针向前移动，每次移动将 nums[start] 从sum 中减去，直到 sum < target,此过程中也会更新数组的最小长度
     *      3、然后 end继续向右移动，重复步骤 1，2
     *
     * 时间复杂度：O(n)   n为便利数组的长度
     * 空间复杂度：O(1)   用到几个变量
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int minTime = Integer.MAX_VALUE;
        int itemSum = 0;
        //窗口开始指针
        int start = 0;
        //窗口结束指针
        for (int i = 0; i < nums.length; i ++){
            itemSum += nums[i];
            while(itemSum >= target){
                minTime = Math.min( i - start + 1, minTime);
                itemSum -= nums[start++];
            }
        }
        return minTime == Integer.MAX_VALUE ? 0 : minTime;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(11, nums));
    }
}
