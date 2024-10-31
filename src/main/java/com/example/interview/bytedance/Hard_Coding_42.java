package com.example.interview.bytedance;

/**
 * @Ahthor k·Young
 * @Date 2024/10/30 16:53
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【42】接雨水
 * Difficulty: hard
 *
 */
public class Hard_Coding_42 {


    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
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
     * 提示：na
     *
     * n == height.length
     * 1 <= n <= 2 * 104
     * 0 <= height[i] <= 105
     *
     */

    /**
     * 双指针
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        //左侧指针和左侧最大值，最大值包含当前位置本身
        int leftIndex = 0, leftMax = 0;
        //右侧指针和右侧最大值，最大值包含当前位置本身
        int rightIndex = height.length - 1, rightMax = 0;
        int sum = 0;
        while(leftIndex < rightIndex){
            //最大值包含当前位置本身
            //左侧最大值
            leftMax = Math.max(leftMax, height[leftIndex]);
            //右侧最大值
            rightMax = Math.max(rightMax, height[rightIndex]);
            //当前位置的储水量和左右最大值的最短的柱子有关
            //
            if (leftMax < rightMax){
                //左侧短，使用左侧柱子计算出水量，然后左侧下标向右移动一位
                sum += leftMax - height[leftIndex];
                leftIndex++;
            }else{
                //右侧短，使用右侧柱子计算出水量，然后右侧下标向左移动一位
                sum += rightMax - height[rightIndex];
                rightIndex--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] n = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(n));
    }

}
