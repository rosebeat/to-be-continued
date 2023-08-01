package com.example.leetcode.dynamic;

/**
 * @author kai·yang
 * @Date 2023/8/1 17:21
 *
 * leetcode: 【62】不同路径
 * level: medium
 * <link>https://leetcode.cn/problems/unique-paths/
 */
public class Coding_62 {


    /**
     *一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     *  机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     *  问总共有多少条不同的路径？
     *
     *  示例 1：
     *
     * 输入：m = 3, n = 7
     * 输出：28
     *  示例 2：
     *
     * 输入：m = 3, n = 2
     * 输出：3
     * 解释：
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向下
     *
     *  示例 3：
     *
     * 输入：m = 7, n = 3
     * 输出：28
     *
     *  示例 4：
     *
     * 输入：m = 3, n = 3
     * 输出：6
     *
     *  提示：
     *
     *  1 <= m, n <= 100
     *  题目数据保证答案小于等于 2 * 109
     *
     *  Related Topics 数学 动态规划 组合数学
     */


    /**
     * 动态规划
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        /**
         *思路：
         *  这道题的思路和爬楼梯（斐波那契数列）类似
         *  机器人每次只能向右或者向下移动一步，所以想要走到（x,y），有两种方式可以到达:
         *      1、由(x-1, y) 向右走一步
         *      2、由(x, y-1) 向下走一步
         *  动态规划转移方程:f(x, y) = f(x-1, y) + f(x, y-1)
         *
         *  当这个网格是：1 * n(向右) 或者 n * 1(向下)的情况下，机器人只有一种行走路径
         *  所以初始化 m*n 二维数组的第一行和第一列为1
         */

        //创建一个m*n的二维数组
        int [][] result = new int[m][n];
        //当这个网格是：1 * n 或者 n * 1的情况下，机器人只有一种行走路径
        //所以初始化 m*n 二维数组的第一行和第一列为1
        for (int i = 0; i < m; i++){
            result[i][0] = 1;
        }
        for (int j = 0; j < n; j++){
            result[0][j] = 1;
        }
        //根据方程：f(x, y) = f(x-1, y) + f(x, y-1)
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                result[i][j] = result[i-1][j] + result[i][j-1];
            }
        }
        return result[m - 1][n - 1];
    }

}
