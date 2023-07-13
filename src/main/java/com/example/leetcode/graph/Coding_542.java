package com.example.leetcode.graph;

/**
 * @author kai·yang
 * @Date 2023/7/13 14:59
 *
 * leetcode: 【542】 01矩阵
 * level: easy
 * <link> https://leetcode.cn/problems/01-matrix/
 */
public class Coding_542 {

    /**
     * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
     *  两个相邻元素间的距离为 1 。
     *
     *  示例 1：
     *
     *
     * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
     * 输出：[[0,0,0],[0,1,0],[0,0,0]]
     *
     *  示例 2：
     *
     *
     * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
     * 输出：[[0,0,0],[0,1,0],[1,2,1]]
     *
     *
     *  提示：
     *
     *  m == mat.length
     *  n == mat[i].length
     *  1 <= m, n <= 104
     *  1 <= m * n <= 104
     *  mat[i][j] is either 0 or 1.
     *  mat 中至少有一个 0
     *
     *  Related Topics 广度优先搜索 数组 动态规划 矩阵
     */


    public int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][];
        return result;
    }
}
