package com.example.leetcode.hot100;

/**
 * @author: kai·yang
 * @Date: 2024/6/27 14:22
 * @Description:
 *
 * LeetCode: 【42】接雨水
 * Difficulty: hard
 * <link> https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class Hot_xxx_42 {


    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * 示例 2：
     *
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     *
     *
     * 提示：
     *
     * n == height.length
     * 1 <= n <= 2 * 104
     * 0 <= height[i] <= 105
     */


    /**
     *
     *
     * 动态规划
     *
     * 解题思路：
     *      对于下标 i ，下雨后所能接到雨水的最大值，取决于 i 左右两侧最大高度的最小值
     *      下标 i 处能接到雨水量等于 i 左右两侧最大高度的最小值 减去 height[i]
     *
     *      1、创建两个长度为 n 的数组liftMax 和 rightMax，
     *          对于 0 <= i < n ,leftMax[i] 表示下标 i 及其左侧的位置的最大高度
     *          对于 0 <= i < n ,rightMax[i] 表示下标 i 及其右侧的位置的最大高度
     *          leftMax[0] = height[0]
     *          rightMax[n - 1] = height[n - 1]
     *
     *
     *  时间复杂度： O(n)
     *  空间复杂度： O(n)
     *
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if (height.length <= 2){
            return 0;
        }
        int sum = 0;
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        // i 左侧最大值
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // i 右侧最大值
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        //遍历每个柱子
        //第一根柱子和最后一根柱子可定不能储水，所以 i可以从1开始， 小于 （n - 1）
        for (int i = 0; i < n; i++){
            //取两侧柱子最小值
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return sum;
    }


    /**
     * 双指针
     *
     * 根据上面的动态规划可知， i 的雨水量 取决于 leftMax[i] 和 rightMax[i]
     *
     * 数组leftMax是从左向右计算， 数组rightMax是从右向左计算，所以可以用 双指针 和 两个变量 代替两个数组
     *
     *
     *  left 和 right 变量 leftMax和rightMax 初始时，
     *      left = 0, right = n - 1
     *      leftMax = 0, rightMax = 0
     *  left指针之向右移动，right指针之向左移动，在移动过程中维护 leftMax 和 rightMax
     *
     *  当两个指针没有相遇时，进行如下操作
     *  - 使用 height[left] 和 height[right] 的值更新 leftMax 和 rightMax的值
     *  - 如果 height[left] < height[right], 则必有 leftMax < rightMax, 下标left处能接的雨水量等于 leftMax - height[left]
     *    将left接到雨水量加到总量上， left 加 1（向右移动一位）
     *  - 如果 height[left] >= height[right], 则必有 leftMax >= rightMax, 下标right处能接到的雨水量 等于 rightMax - height[right]
     *    将right接到的雨水量加到总量上， right 减 1（向左移动一位）
     *
     * 两个指针相遇时，即可得到雨水总量
     *
     * @param height
     * @return
     */
    public static int trapV2(int[] height){
        if (height.length <= 2){
            return 0;
        }
        int sum = 0;

        //左指针和 左侧最大值
        int left = 0, leftMax = 0;
        // 右指针和 右侧最大值
        int right = height.length - 1, rightMax = 0;

        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(right, rightMax);
            if (height[left] < height[right]){
                sum += leftMax - height[left];
                left++;
            }else{
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;

    }



    public static void main(String[] args) {
        int[] n = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(n));
    }

}
