package com.example.leetcode.hot100;

/**
 * @author: kai·yang
 * @Date: 2024/7/11 11:27
 * @Description:
 *
 * LeetCode: 【35】 搜索插入位置
 * Difficulty：easy
 * <link>https://leetcode.cn/problems/search-insert-position/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_xxx_35 {


    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 请必须使用时间复杂度为 O(log n) 的算法。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     * 示例 2:
     *
     * 输入: nums = [1,3,5,6], target = 2
     * 输出: 1
     * 示例 3:
     *
     * 输入: nums = [1,3,5,6], target = 7
     * 输出: 4
     *
     *
     * 提示:
     *
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 为 无重复元素 的 升序 排列数组
     * -104 <= target <= 104
     */


    /**
     * 二分查找法
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target){

        int left = 0;
        int right = nums.length - 1;
        //这里没有等于，因为到left和right指向同一个元素时，该元素与target比较有三种情况：小于，等于，大于
        //小于和等于属于一种情况，因为target小于等于该元素时都是要返回该元素的位置
        //target大于该元素时，那么返回的位置就是该元素下标 加1 的位置
        while(left <= right){
            int mid = (right - left) >> 1 + left;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return nums[left] < target ? left + 1 : left;
    }


    /**
     * 二分查找法 优化
     *
     * 假设我们插入的原咋位置为 pos，则有
     *
     *  nums[pos - 1] < target <= nums[pos]
     *  如果存在这个值，我们返回的索引也是pos，因此我们可以把这两个条件合并得出：在一个有序集合中找第一个大于等于target的下标
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsertV2(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        //如果数组中找不到第一个大于等于target的元素，那么它插入的位置是最后一个
        int ans = nums.length;
        while(left <= right){
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }


}
