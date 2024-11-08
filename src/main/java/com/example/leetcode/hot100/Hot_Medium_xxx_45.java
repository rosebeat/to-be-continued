package com.example.leetcode.hot100;

/**
 * @Ahthor k·Young
 * @Date 2024/11/8 14:35
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【45】跳跃游戏II
 * Difficulty: medium
 * <link>https://leetcode.cn/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_Medium_xxx_45 {

    /**
     * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
     *
     * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
     *
     * 0 <= j <= nums[i]
     * i + j < n
     * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     * 示例 2:
     *
     * 输入: nums = [2,3,0,1,4]
     * 输出: 2
     *
     *
     * 提示:
     *
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 1000
     * 题目保证可以到达 nums[n-1]
     */

    /**
     *
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {

        int n = nums.length;
        //下一次跳跃能够到达的最远位置
        int maxPos = 0;
        //记录当前跳跃能到达的最大位置下标，初始值为0，也就是第一个元素
        int stepEnd = 0;
        //跳跃次数
        int ans = 0;
        for (int i = 0; i < n - 1; i++){
            maxPos = Math.max(maxPos, i + nums[i]);
            //如果到达了当前跳跃的最远位置，那么就一定要跳了，下次跳跃的边界就是maxPos，次数 + 1
            if (i == stepEnd){
                stepEnd = maxPos;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
