package com.example.leetcode.hot100;

/**
 * @Ahthor k·Young
 * @Date 2024/11/8 11:21
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【55】跳跃游戏
 * Difficulty: medium
 * <link>https://leetcode.cn/problems/jump-game/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_Medium_xxx_55 {

    /**
     * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * 示例 2：
     *
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 105
     */

    /**
     * 贪心
     * 只要存在一个位置x，它本身可以到达，并且它跳跃的最大长度为 x + nums[x], 如果这个值大于 y，即 x + nums[x] >= y, 那么位置y也可以到达
     *  也就是说 对于一个可以到达的x， 它使的 x+1，x+2 ………… x + nums[x] 这些连续的位置都可以到达
     *
     *  实时维护一个可以最远到达的位置 max， 那么小于等于 max 的位置都可以到达，在前进过程中再根据当前位置的跳跃距离实时更新最远可以到达的位置max
     *  如果 max 已经大于等于 数组中组后一个元素（即 nums.length - 1）, 说明可以到达 直接返回true
     *  如果 i 已经到达max位置，说明无法到达 最后一个元素直接返回 false
     *
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {

        //当前最远能到达的元素下标，也就是距离，初始值为第一个元素位置
        int max = 0;
        for( int i = 0; i <= max; i++){
            int temp = i + nums[i];
            //更新最远到达距离
            max = Math.max(max, temp);
            //当前最元到达距离，已经可以到达 最后一个元素直接跳出
            if (max >= nums.length -1){
                return true;
            }
        }
        return false;
    }

}
