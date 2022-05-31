package com.example.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kai·yang
 * @Date 2022/4/20 16:25
 *
 *
 * 题目：杨辉三角【118】
 * 难度： easy
 */

public class Coding_118 {

    /**
     * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     */

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);
        for (int i = 1; i < numRows; i++){
            List<Integer> item = new ArrayList<>();
            List<Integer> last = result.get( i-1 );
            for (int j = 0; j <= i; j++){

            }
        }

        return result;

    }
}
