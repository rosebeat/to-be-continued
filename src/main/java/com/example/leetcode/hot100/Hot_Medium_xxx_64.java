package com.example.leetcode.hot100;

/**
 * @Ahthor k·Young
 * @Date 2024/11/4 16:42
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【64】最小路径和
 * Difficulty: medium
 * <link> https://leetcode.cn/problems/minimum-path-sum/description/?envType=study-plan-v2&envId=top-100-liked
 * Tag: 数组，动态规划
 */
public class Hot_Medium_xxx_64 {


    /**
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     *
     *

     * 示例 1：
     *
     *         1  3  1
     *         1  5  1
     *         4  2  1
     *
     *
     * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     * 输出：7
     * 解释：因为路径 1→3→1→1→1 的总和最小。
     * 示例 2：
     *
     * 输入：grid = [[1,2,3],[4,5,6]]
     * 输出：12
     *
     *
     * 提示：
     *
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 200
     * 0 <= grid[i][j] <= 200
     */

    /**
     *
     * 动态规划
     *    在不修改原数组的基础上，使用额外的 m*n 的空间
     *
     *  时间复杂度：O(m * n), 使用了两层for循环
     *
     *  空间复杂度：O(m * n)
     *
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int x = grid.length;
        int y = grid[0].length;
        int[][] dp = new int[x][y];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if (i == 0 && j == 0){
                    continue;
                }else if( i == 0){
                    dp[i][j] = dp[0][j - 1] + grid[0][j];
                }else if ( j == 0 ){
                    dp[i][j] = dp[i - 1][0] + grid[i][0];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[x - 1][y - 1];
    }


    /**
     *
     * 一维数组动态规划
     *
     * int[] dp 长度为 n + 1
     * 记 x 是要计算的下标
     *
     * x = Math.min( x, x -1) + grid[m][n]
     *
     *   时间复杂度：O(m * n), 使用了两层for循环
     *
     *   空间复杂度：O(m)
     *
     * @param grid
     * @return
     */
    public int minPathSumV2(int[][] grid){
        int x = grid.length;
        int y = grid[0].length;
        // 长度加一便于边界的处理
        int[] dp = new int[y + 1];
        //先把所以元素置为最大值
        for (int i = 0; i <= y; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        //dp[1], 即初始位置
        dp[1] = 0;
        for (int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++){
                dp[j + 1] = Math.min(dp[j], dp[j + 1]) + grid[i][j];
            }
        }
        return dp[y];
    }



}
