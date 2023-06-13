package com.example.leetcode.greedy;

import java.util.Arrays;

/**
 * @author kai·yang
 * @Date 2023/6/13 11:30
 *
 * leetcode: 【1005】k次取反后最大的数组和
 * level：easy
 *
 */
public class Coding_1005 {


    /**
     * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
     *
     *  选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
     *
     *  重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
     *  以这种方式修改数组后，返回数组 可能的最大和 。
     *
     *  示例 1：
     *
     * 输入：nums = [4,2,3], k = 1
     * 输出：5
     * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
     *
     *  示例 2：
     *
     * 输入：nums = [3,-1,0,2], k = 3
     * 输出：6
     * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
     *
     *  示例 3：
     *
     * 输入：nums = [2,-3,-1,5,-4], k = 2
     * 输出：13
     * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
     *
     *
     *  提示：
     *
     *  1 <= nums.length <= 104
     *  -100 <= nums[i] <= 100
     *  1 <= k <= 104
     *
     *  Related Topics 贪心 数组 排序
     */

    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public static int largestSumAfterKNegations(int[] nums, int k) {
        //排序将最小的放在前面，便于对负数进行修改
        Arrays.sort(nums);
        //对负数进行处理
        for (int i = 0; i < nums.length && k > 0;){
            if (nums[i] < 0){
                nums[i] = -nums[i];
                i++;
                k--;
            }else{
                break;
            }
        }
        //再排序
        Arrays.sort(nums);
        //如果还有修改次数，则将第一位重复修改对应次数
        int x = k  % 2 == 0 ? nums[0] : -nums[0];
        nums[0] = x;
        return sum(nums);
    }

    public static int sum(int[] nums){
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,6,7,9};
        System.out.println(largestSumAfterKNegations(nums, 3));

    }
}
