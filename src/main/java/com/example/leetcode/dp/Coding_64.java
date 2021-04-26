package com.example.leetcode.dp;

public class Coding_64 {

    /**
     * 64: 最小路径和
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        /*
         *思路
         *dp[i][j] 为右下角坐标
         *  只能向下或者上左移动，所以到达dp[i][j]有两种方式：
         *      1、dp[i-1][j]
         *      2、dp[i][j-1]
         *  故：从1和2中选取最小的，行走路径总和最小
         */
        if (grid == null || grid.length ==0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        //初始化第一行和第一列，路径总和 等于 前n项和
        for (int i = 1; i < m; i++){
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < n; j++){
            grid[0][j] += grid[0][j - 1];
        }
        for (int x = 1; x < m; x++){
            for (int y = 1; y < n; y++){
                grid[x][y] += Math.min(grid[x - 1][y], grid[x][y -1]);
            }
        }
        return grid[m-1][n-1];
    }


}
