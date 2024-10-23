package com.example.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Ahthor k·Young
 * @Date 2024/10/23 15:48
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【47】全排序II
 * Difficulty: medium
 * <link>https://leetcode.cn/problems/permutations-ii/solutions/9917/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
 */
public class Hot_xxx_47 {


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        boolean[] used = new boolean[n];
        Deque<Integer> element = new ArrayDeque<>();
        backTrace(nums, element, used, res, n, 0);
        return res;
    }


    /**
     *
     * @param nums 原数组
     * @param element 每一种组合方式
     * @param used 每个位置上的元素是否被使用
     * @param res 结果集
     * @param n 数组长度
     * @param begin 每种组合方式中要确定的元素下标
     */
    public void backTrace(int[] nums, Deque<Integer> element, boolean[] used, List<List<Integer>> res, int n, int begin){
        if (begin == n){
            res.add(new ArrayList<>(element));
            return;
        }
        for (int i = 0; i < n; i++){
            if (used[i]){
                continue;
            }
            //剪支
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            element.addLast(nums[i]);
            used[i] = true;
            backTrace(nums, element, used, res, n, begin + 1);
            //回溯
            used[i] = false;
            element.removeLast();
        }




    }

}
