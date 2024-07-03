package com.example.leetcode.hot100;

import com.alibaba.fastjson2.JSON;

/**
 * @author: kai·yang
 * @Date: 2024/7/2 19:24
 * @Description:
 *
 * LeetCode: 【238】 除自身以外数组的乘积
 * Difficulty: medium
 * <link> https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class Hot_xxx_238 {


    /**
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     *
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     *
     * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,4]
     * 输出: [24,12,8,6]
     * 示例 2:
     *
     * 输入: nums = [-1,1,0,-3,3]
     * 输出: [0,0,9,0,0]
     *
     *
     * 提示：
     *
     * 2 <= nums.length <= 105
     * -30 <= nums[i] <= 30
     * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
     *
     *
     * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
     */


    /**
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        //先计算每个元素左边的乘积，放在result对应的位置上
        result[0] = 1;
        for (int i = 1; i < nums.length; i ++){
            result[i] = result[i - 1] * nums[i - 1];
        }
        //使用一个变量累计右侧乘积
        int right = 1;
        //计算右侧乘积
        for (int i = nums.length - 1; i >=0; i--){
            //最后一个元素（右边第一个元素）的右侧乘积是 1
            result[i] *= right;
            //累计右侧乘积
            right *= nums[i];
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(JSON.toJSON(productExceptSelf(nums)));
    }

}
