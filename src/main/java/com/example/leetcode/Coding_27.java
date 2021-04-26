package com.example.leetcode;

public class Coding_27 {

    /**
     * 27 移除元素
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int end = nums.length;
        for (int i = 0; i < end; i++ ){
            if (nums[i] == val ){
                swap(nums, i, --end);
                i--;
            }
        }
        return end;
    }

    public static void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

}
