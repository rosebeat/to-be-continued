package com.example.leetcode.hot100;

/**
 * @Ahthor k·Young
 * @Date 2024/10/25 11:36
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【79】单词搜索
 * Difficulty: medium
 * <link> https://leetcode.cn/problems/word-search/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 回溯法
 */
public class Hot_xxx_79 {

    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     */

    /**
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        //以每个格子为头开始检索是否可以构成word
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if(check(board, visited, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }


    /**
     *
     * @param board 给定的二位字符数组
     * @param visited 是否被访问过
     * @param word 给定单词
     * @param i 行
     * @param j 列
     * @param k 要匹配的单词中字符的位置
     * @return
     */
    public boolean check(char[][] board, boolean[][] visited, String word,int i, int j, int k){
        //二维数组中的字符是否和word中 'k'位置上的字符相等
        if (board[i][j] != word.charAt(k)){
            return false;
        }
        if (k == word.length() - 1){
            return true;
        }
        boolean result = false;
        visited[i][j] = true;
        //寻找方向,上下左右
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        //遍历寻找方向
        for (int[] d : direction){
            int newI = i + d[0];
            int newJ = j + d[1];
            //是否越界判断, 是否已经访问过判断
            if ( (newI >= 0 && newI < board.length)  &&  (newJ >= 0 && newJ < board[0].length) && !visited[newI][newJ]){
                if(check(board, visited, word, newI, newJ, k + 1)){
                    result = true;
                    break;
                }
            }
        }
        //恢复未访问，如果未成功，需要以别的格子为头重新开始检索
        visited[i][j] = false;
        return result;
    }

}
