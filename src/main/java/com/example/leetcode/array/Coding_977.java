package com.example.leetcode.array;

import com.alibaba.fastjson2.JSON;

/**
 * @author kai·yang
 * @Date 2023/6/27 11:37
 *
 * leetcode: 【977】有序数组的平方
 * level：easy
 *
 */
public class Coding_977 {

    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新
     *
     *  示例 1：
     *
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     *  示例 2：
     *
     * 输入：nums = [-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     *
     *
     *  提示：
     *
     *  1 <= nums.length <= 104
     *  -104 <= nums[i] <= 104
     *  nums 已按 非递减顺序 排序
     *
     *  进阶：
     *
     *  请你设计时间复杂度为 O(n) 的算法解决本问题
     */

    /**
     * 数组nums是递增的，取值范围 -104 <= nums[i] <= 104
     * 那么数组平方的最大值就在数组的两端，不是最左边就是最右边，不可能是中间
     * 采用双指针指向头和尾，判断平方之后谁最大，最大的赋值给新数组的最后一位
     *
     *
     *
     * 采用了一次循环所以 时间复杂度：O(n)
     * 创建了一个新数组和三个变量 空间复杂度：O(n) + 3 = O(n)
     * @param nums
     * @return
     */
    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int index = nums.length - 1;
        int left = 0;
        int right = nums.length - 1;
        while( left <= right ){
            //
            if (nums[left] * nums[left] > nums[right] * nums[right]){
                result[index--] = nums[left] * nums[left];
                left++;
            }else{
                result[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println(JSON.toJSONString(sortedSquares(nums)));
    }
}
