package com.example.leetcode.hot100;

import com.alibaba.fastjson2.JSON;

import java.util.*;

/**
 * @Ahthor k·Young
 * @Date 2024/10/24 15:09
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【39】组合总和
 * Difficulty: medium
 * <link>
 */
public class Hot_xxx_39 {

    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     *
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     *
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
     *
     *
     *
     * 示例 1：
     *
     * 输入：candidates = [2,3,6,7], target = 7
     * 输出：[[2,2,3],[7]]
     * 解释：
     * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
     * 7 也是一个候选， 7 = 7 。
     * 仅有这两种组合。
     * 示例 2：
     *
     * 输入: candidates = [2,3,5], target = 8
     * 输出: [[2,2,2,2],[2,3,3],[3,5]]
     * 示例 3：
     *
     * 输入: candidates = [2], target = 1
     * 输出: []
     *
     *
     * 提示：
     *
     * 1 <= candidates.length <= 30
     * 2 <= candidates[i] <= 40
     * candidates 的所有元素 互不相同
     * 1 <= target <= 40
     */


    /**
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, res, path, candidates.length, 0);
        return res;
    }


    /**
     *
     * @param candidates 数组
     * @param target 目标值
     * @param res 结果集
     * @param path 每种情况
     * @param n 数组长度
     * @param begin 要选取元素的下标
     */
    public void backtrack(int[] candidates, int target, List<List<Integer>> res, Deque<Integer> path, int n, int begin) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < n; i++){
            //剪支，前提要排序
            if (target - candidates[i] < 0) {
                break;
            }
            path.addLast(candidates[i]);
            //开始位置 为 i ，因为每个元素可以重复选择，不重复就是 i+ 1
            backtrack(candidates, target - candidates[i], res, path, n, i);
            //回溯前一个元素
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Hot_xxx_39 t = new Hot_xxx_39();
        System.out.println(JSON.toJSONString(t.combinationSum(new int[]{2, 3, 6, 7}, 7)));
    }

}
