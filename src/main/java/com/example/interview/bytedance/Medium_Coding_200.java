package com.example.interview.bytedance;

/**
 * @Ahthor k·Young
 * @Date 2024/10/29 14:54
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【200】岛屿的数量
 * Difficulty: medium
 * Tag: 深度优先，数组，矩阵
 *
 */
public class Medium_Coding_200 {


    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     *
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     *
     *
     * 示例 1：
     *
     * 输入：grid = [
     *   ["1","1","1","1","0"],
     *   ["1","1","0","1","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","0","0","0"]
     * ]
     * 输出：1
     * 示例 2：
     *
     * 输入：grid = [
     *   ["1","1","0","0","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","1","0","0"],
     *   ["0","0","0","1","1"]
     * ]
     * 输出：3
     *
     *
     * 提示：
     *
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 300
     * grid[i][j] 的值为 '0' 或 '1'
     */

    /**
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        //设置访问表示，表示那些陆地已经被访问
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        //依次遍历每个网格，判断是否形成岛屿
        for (int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[0].length; y++ ){
                //是陆地并且没有被访问过
                if (grid[x][y] == '1' && !visited[x][y]){
                    dfs(grid, visited, x, y);
                    count++;
                }
            }
        }
        return count;
    }


    public void dfs(char[][] grid, boolean[][] visited, int x, int y){
        //是否越界
        if (!inArea(grid, x, y)){
            return;
        }
        //已经被访问过，或者是海洋
        if (visited[x][y] || grid[x][y] == '0'){
            return;
        }
        //设置已访问标识
        visited[x][y] = true;
        //递归，依次向4个方向寻找
        //前后
        dfs(grid, visited, x + 1, y);
        dfs(grid, visited, x - 1, y);
        //上下
        dfs(grid, visited, x, y + 1);
        dfs(grid, visited, x, y - 1);

    }

    /**
     * 是否在区间
     * @param grid
     * @param x
     * @param y
     * @return
     */
    public boolean inArea(char[][] grid, int x, int y){
        return 0 <= x && x < grid.length && 0 <=y && y < grid[0].length;
    }

}
