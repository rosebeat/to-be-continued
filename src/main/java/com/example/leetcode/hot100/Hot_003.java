package com.example.leetcode.hot100;

import com.alibaba.fastjson2.JSON;

import java.util.Arrays;

/**
 *
 * LeetCode Hot 100
 *
 * @author: kai·yang
 * @Date: 2024/5/30 10:28
 * @Description:
 *
 * difficult: medium
 * <link>https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class Hot_003 {


    /**
     * 问题描述：
     *  给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *  请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     *
     * 示例 1：
     *  输入：nums = [100,4,200,1,3,2]
     *  输出：4
     *  解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     *  示例 2：
     *  输入：nums = [0,3,7,2,5,8,4,6,0,1]
     *  输出：9
     *
     *
     *
     *
     * @param nums
     * @return
     */

    public static int longestConsecutive(int[] nums) {
        if (nums.length <= 1){
            return nums.length;
        }
        //升序排序
        Arrays.sort(nums);
        System.out.println(JSON.toJSONString(nums));
        //当前节点之前最大连续长度
        int itemMax = 1;
        //当前阶段 连续长度
        int itemLength= 1;

        for (int i = 1; i < nums.length; i++){
            int diff = nums[i] - nums[i - 1];
            //相邻两个数连续, 数组有负数 要有额外判断
            if (diff == 1 || diff == -1){
                itemLength++;
            }
            //不连续 数组有负数，要有额外判断
            if (diff > 1 || diff < -1){
                //当前连续长度 和 之前最大连续长度  取最大值
                itemMax = Math.max(itemMax, itemLength);
                itemLength = 1;
            }
        }
        // 最后一段 取最大值
        return Math.max(itemMax, itemLength);
    }


    public static void main(String[] args) {
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(longestConsecutive(nums));
    }

}
