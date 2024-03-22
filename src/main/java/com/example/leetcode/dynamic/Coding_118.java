package com.example.leetcode.dynamic;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: kai·yang
 * @Date: 2024/3/21 15:42
 * @Description:
 *
 * LeetCode: 【118】 杨辉三角
 * Difficulty: easy
 * <link> https://leetcode.cn/problems/pascals-triangle/description/
 */
public class Coding_118 {


    /**
     *给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     *
     *  在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     *
     *  示例 1:
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {

        //杨辉三角的核心：
        //
        int[][] dArray = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++){
            dArray[i][0] = 1;
        }
        for (int i = 1; i < numRows; i++){
            for (int j = 1; j <= i; j++){
                dArray[i][j] = dArray[i - 1][j] + dArray[i - 1][j - 1];
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            List<Integer> item = new ArrayList<>();
            for (int j = 0; j <= i; j++){
                item.add(dArray[i][j]);
            }
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(generate(5)));
    }

}
