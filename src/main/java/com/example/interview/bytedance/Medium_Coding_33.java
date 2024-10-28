package com.example.interview.bytedance;

/**
 * @Ahthor k·Young
 * @Date 2024/10/28 15:33
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【33】搜索旋转排序数组
 * Difficulty: medium
 *
 * Tag: 二分
 */
public class Medium_Coding_33 {


    /**
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     *
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ...,
     * nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     *
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     *
     * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     * 示例 2：
     *
     * 输入：nums = [4,5,6,7,0,1,2], target = 3
     * 输出：-1
     * 示例 3：
     *
     * 输入：nums = [1], target = 0
     * 输出：-1
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 5000
     * -104 <= nums[i] <= 104
     * nums 中的每个值都 独一无二
     * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
     * -104 <= target <= 104
     */

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0;
        int r = len - 1;
        while(l <= r){
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target){
                return mid;
            }
            //数组可能是由两段单调递增的序列组成，
            //如果 最左侧元素 nums[left]小于等于 中间位 nums[mid]，中间位mid落在了左边单调递增序列
            //说明mid左侧区间是一定有序的（单调递增）, 右侧区间可能无序
            if(nums[l] <= nums[mid]){
                //判断mid左边 与 target的关系
                if (nums[mid] > target && nums[l] <= target){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            //说明mid左侧区间可能无序，右侧区间一定有序
            else{
                //判断mid右边与target的关系
                if(nums[mid] < target && nums[r] >= target){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

}
