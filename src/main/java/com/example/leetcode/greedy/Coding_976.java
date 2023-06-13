package com.example.leetcode.greedy;

import java.util.Arrays;

/**
 * @author kai·yang
 * @Date 2023/6/13 11:00
 *
 * leetcode: 【976】 三角形的最大周长
 *
 *
 */
public class Coding_976 {

    /**
     * 给定由一些正数（代表长度）组成的数组 nums ，返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。如果不能形成任何面积不为零的三角形，返回 0。
     *
     *  示例 1：
     *
     * 输入：nums = [2,1,2]
     * 输出：5
     * 解释：你可以用三个边长组成一个三角形:1 2 2。
     *
     *  示例 2：
     *
     * 输入：nums = [1,2,1,10]
     * 输出：0
     * 解释：
     * 你不能用边长 1,1,2 来组成三角形。
     * 不能用边长 1,1,10 来构成三角形。
     * 不能用边长 1、2 和 10 来构成三角形。
     * 因为我们不能用任何三条边长来构成一个非零面积的三角形，所以我们返回 0。
     *
     *  提示：
     *
     *  3 <= nums.length <= 104
     *  1 <= nums[i] <= 106
     *
     *  Related Topics 贪心 数组 数学 排序
     */


    /**
     * 思路：
     *   能够成为三角形的必要条件是： 任意两边之和大于第三边   a + b > c
     *   先将数组降序排列 从最大端开始，
     *    1、必然有 nums[i] + nums[i - 1] > nums[i - 2]
     *    2、必然有 nums[i] + nums[i - 2] > nums[i - 1]
     *    3、如果有  nums[i] < nums[i - 1] + nums[i - 2] 成立
     *    则组成的三角形边长最长
     *
     * @param nums
     * @return
     */
    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length -1; i >= 2; i--){
            if (nums[i-1] + nums[i-2] > nums[i]){
                return nums[i-1] + nums[i-2] + nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,4};
        System.out.println(largestPerimeter(nums));
        int i = -5;
        System.out.println(-i);
    }

}
