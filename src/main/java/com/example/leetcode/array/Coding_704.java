package com.example.leetcode.array;

/**
 * @author kai·yang
 * @Date 2023/6/26 16:40
 *
 * leetcode: 【704】二分查找法
 * level：easy
 *
 */
public class Coding_704 {


    /**
     * 题干：
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的
     * 则返回 -1。
     *
     * 示例 1:
     *  输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     *
     *  示例 2:
     *  输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     *
     *
     *  提示：
     *
     *  你可以假设 nums 中的所有元素是不重复的。
     *  n 将在 [1, 10000]之间。
     *  nums 的每个元素都将在 [-9999, 9999]之间。
     *
     *  Related Topics 数组 二分查找
     */


    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        //二分的部分为一个左闭右开区间
        while(left < right){
            //这样写的目的 为了防止溢出
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums, 2));
    }

}
