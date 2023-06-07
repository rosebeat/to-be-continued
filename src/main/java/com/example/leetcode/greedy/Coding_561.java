package com.example.leetcode.greedy;

import java.util.Arrays;

/**
 * @author kai·yang
 * @Date 2023/5/8 15:31
 *
 * leetcode: 【561】 数组拆分
 * level：easy
 */
public class Coding_561 {


    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            if ( (i + 1) % 2 == 1){
                sum += nums[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {6,2,6,5,1,2};
        System.out.println(arrayPairSum(nums));
    }

}
