package com.example.leetcode.greedy;

/**
 * @author kai·yang
 * @Date 2023/6/26 15:19
 *
 * leetcode: 【55】跳跃游戏
 * level：medium
 *
 */
public class Coding_55 {

    /**
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     *  数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *  判断你是否能够到达最后一个下标。
     *
     *  示例 1：
     *
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     *
     *  示例 2：
     *
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     *
     *
     *  提示：
     *
     *  1 <= nums.length <= 3 * 104
     *  0 <= nums[i] <= 105
     *
     *  Related Topics 贪心 数组 动态规划
     */

    public static boolean canJump(int[] nums) {
        if (nums.length <= 1 ){
            return true;
        }
        //所能覆盖的范围
        int cover = 0;
        for(int i = 0; i <= cover; i++){
            //nums[i] + i 表示当前位置所能覆盖的最大范围
            cover = Math.max(nums[i] + i, cover);
            if (cover >= nums.length -1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }
}
