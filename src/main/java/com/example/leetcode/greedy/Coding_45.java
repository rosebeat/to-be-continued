package com.example.leetcode.greedy;

/**
 * @author kai·yang
 * @Date 2023/6/26 10:12
 *
 * leetcode: 【45】跳跃游戏II
 * level：medium
 *
 */
public class Coding_45 {

    /**
     * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
     *  每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处
     *
     *  0 <= j <= nums[i]
     *  i + j < n
     *
     *  返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
     *
     *  示例 1:
     *
     * 输入: nums = [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     *
     *  示例 2:
     *
     * 输入: nums = [2,3,0,1,4]
     * 输出: 2
     *
     *
     *  提示:
     *
     *  1 <= nums.length <= 104
     *  0 <= nums[i] <= 1000
     *  题目保证可以到达 nums[n-1]
     *
     *  Related Topics 贪心 数组 动态规划
     */


    /**
     *
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int minJump = 0;

        for(int i = 0; i < nums.length;){
            int nextIndex = i + 1;
            boolean flag = false;
            //找到当前位置能够跳跃的位置上的最大跳跃距离
            //也就是说当前位置能够跳跃的位置的 下标 加 这个位置能够跳跃的距离  最远的就是下一步跳跃的位置
            for (int j = 1; j <= nums[i] && j + i < nums.length; j++) {
                nextIndex = nums[nextIndex] + nextIndex > nums[i + j] + i+ j && j + i < nums.length - 1 ? nextIndex : i + j;
                flag = true;
            }
            i = nextIndex;
            minJump = flag ? minJump + 1 : minJump;
        }
        return minJump;
    }

    public static int jumpV2(int[] nums){
        int minJump = 0;

        return minJump;
    }



    public static void main(String[] args) {
        int[] nums = {10,9,8,7,6,5,4,3,2,1,1,0};
        System.out.println(jump(nums));
    }

}
