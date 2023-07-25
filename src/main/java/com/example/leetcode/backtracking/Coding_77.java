package com.example.leetcode.backtracking;


import java.util.*;

/**
 * @author kai·yang
 * @Date 2023/7/25 17:31
 *
 * leetcode: 【77】组合
 * level：medium
 * <link>
 */
public class Coding_77 {

    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     *  你可以按 任何顺序 返回答案。
     *
     *  示例 1：
     *
     * 输入：n = 4, k = 2
     * 输出：
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4],
     * ]
     *  示例 2：
     *
     * 输入：n = 1, k = 1
     * 输出：[[1]]
     *
     *  提示：
     *
     *  1 <= n <= 20
     *  1 <= k <= n
     *
     *  Related Topics 回溯
     */


    /**
     * 回溯法
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0 || n < k ){
            return result;
        }
        Deque<Integer> que = new ArrayDeque<>();
        doCombine(n, k, 1, que, result);
       return result;
    }

    public void doCombine(int n , int k, int begin, Deque<Integer> path, List<List<Integer>> result){
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n; i++){
            path.offer(i);
            doCombine(n, k, i + 1, path, result);
            path.removeLast();
        }
    }
}
