package com.example.leetcode.array;

import com.alibaba.fastjson2.JSON;

/**
 * @author kai·yang
 * @Date 2023/6/27 16:51
 *
 * leetcode: 【59】螺旋矩阵II
 * level：medium
 *
 */
public class Coding_59 {

    /**
     *给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵
     *
     *  示例 1：
     *
     * 输入：n = 3
     * 输出：[[1,2,3],[8,9,4],[7,6,5]]
     *
     *  示例 2：
     *
     * 输入：n = 1
     * 输出：[[1]]
     *
     *
     *  提示：
     *
     *  1 <= n <= 20
     *
     *  Related Topics 数组 矩阵 模拟
     */


    /**
     * 模拟法，
     *   顶部：从左向右填充：填充的行肯定在[left,right]区间
     *   右侧：从上向下填充：填充的列肯定在[top,bottom]区间
     *   底部：从右向左填充：填充的行肯定在[right,left]区间
     *   左侧：从下向上填充：填充的列肯定在[bottom,top]区间
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        //上 边界
        int t = 0;
        //左 边界
        int l = 0;
        //右 边界
        int r = n - 1;
        //下 边界
        int b = n - 1;
        int num = 1;
        while(num <= n * n){
            //上面从左到右填充
            for (int i = l; i <= r; i++){
                result[t][i] = num++;
            }
            //顶部填充完成，向下移动一行
            t++;
            //右侧从上到下填充
            for (int i = t; i <= b; i++){
                result[i][r] = num++;
            }
            //右侧填充完成，向左移动一列
            r--;
            //上面 从右到左填充
            for (int i = r; i >= l; i--){
                result[b][i] = num++;
            }
            //底部填充完成，向上移动一行
            b--;
            //左侧 从下倒上填充
            for (int i = b; i >= t; i--){
                result[i][l] = num++;
            }
            //左侧填充完成，向右移动一列
            l++;
        }

        return result;
    }


    public static int[][] generateMatrixV2(int n){
        int[][] result = new int[n][n];

        return result;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(generateMatrix(4)));
    }

}
