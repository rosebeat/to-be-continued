package com.example.leetcode.array;

/**
 * @author kai·yang
 * @Date 2023/1/10 10:30
 *
 *  leetcode
 *  description: 【26】 删除有序数组中的重复项
 *  level：easy
 *
 */


public class Coding_26 {


    /**
     * 删除有序数据中重复项
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0){
            return 0;
        }
        int h = 0;
        int t = 1;
        while(t < nums.length){
            if ( nums[h] != nums[t] ){
                nums[h + 1] = nums[t];
                h++;
            }
            t++;
        }
        return h + 1;
    }
}
