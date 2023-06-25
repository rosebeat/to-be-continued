package com.example.leetcode.greedy;

/**
 * @author kai·yang
 * @Date 2023/6/25 17:03
 *
 * leetcode: 【11】盛最多水的容器
 * level：medium
 *
 */
public class Coding_11 {

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
     * 思路：
     *      根据题意可知，容器盛水的多少由短边缘决定
     *      假如 容器由L1 和  L2 构成，L1 < L2，V = (L2 - L1)*L1
     *      1、使用两个指针，指向数组头 H 和数组尾 T
     *      2、V = ( T - H ) * min(H, T)
     *      3、小的那一侧向前（向后）移动
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int h = 0;
        int t = height.length - 1;
        int maxV = 0;
        while (h < t){
            maxV = Math.max(maxV, (t - h) * Math.min(height[t], height[h]));
            if (height[t] < height[h]){
                t--;
            }else{
                h++;
            }
        }
        return maxV;
    }


    /**
     * 代码优化
     * @param height
     * @return
     */
    public static int maxAreaV2(int[] height) {
        int h = 0;
        int t = height.length - 1;
        int maxV = 0;
        while (h < t){
            maxV = height[t] < height[h] ? Math.max(maxV, (t - h) * height[t--]) :
                    Math.max(maxV, (t - h) * height[h++]);
        }
        return maxV;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
        System.out.println(maxAreaV2(height));
    }
}
