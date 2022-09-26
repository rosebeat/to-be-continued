package com.example.leetcode.maths;

/**
 * @author kai·yang
 * @Date 2022/9/20 14:43
 *
 *  leetcode:
 *      subject: 35.搜索插入位置
 *      level: easy
 */
public class Coding_35 {

    /**
     * desc:
     *  给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *  请必须使用时间复杂度为 O(log n) 的算法。
     *
     * 分析：
     *  一个有序数组，采用时间复杂度为O(log n)，可知需要采用二分查找法
     *
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int mid = length / 2;
        int right = length;
        while(left < right){
            if (nums[mid] == target){
                return mid;
            }else if ( nums[mid] < target){
                left = right + 1;
                mid = right + (length - right) / 2;
            }else {
                right = mid;
                mid = right / 2;

            }
        }
        return right ;
    }


    public static void main(String[] args) {
       int[] nums = {1,3,5,6};
       int target = 2;
        System.out.println(searchInsert(nums, target));
    }

}
