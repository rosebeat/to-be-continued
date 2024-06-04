package com.example.leetcode.hot100;

/**
 * @author: kai·yang
 * @Date: 2024/6/4 14:31
 * @Description:
 *
 *  leetcode: 【11】盛最多水的容器
 *  difficulty：medium
 *  <link> https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_005_11 {


    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     *  找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *  返回容器可以储存的最大水量。
     *  说明：你不能倾斜容器。
     *
     *  示例 1：
     *
     *
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     *  示例 2：
     *
     * 输入：height = [1,1]
     * 输出：1
     *
     *
     *  提示：
     *
     *  n == height.length
     *  2 <= n <= 105
     *  0 <= height[i] <= 104
     *
     *  Related Topics 贪心 数组 双指针
     */



    /**
     *
     * 思路： 容积 是由较短的一条边决定的，
     *
     *      1 设 两条边为  X  Y（X < Y），则 V = （Y - X）* min(height[X], height[Y])
     *      2 使用两个指针分别指向数组的头 T 和尾 H，V = （T - H）* min(height[H], height[T])
     *      3 比较当前 容积 和之前的最大容积
     *      3 边小的一侧向前移动
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        //左指针
        int h = 0;
        //右指针
        int t = height.length - 1;
        //最大容积
        int max = 0;
        while(t > h){
            //(t - h) * Math.min(height[t], height[h])  当前位置的容积
            max = Math.max(max, (t - h) * Math.min(height[t], height[h]));
            if (height[t] < height[h]){
                t--;
            }else {
                h++;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
