package com.example.leetcode.tree;


/**
 * @author: kai·yang
 * @Date: 2024/3/28 14:35
 * @Description:
 *
 * LeetCode: 【96】不同的二叉搜索树
 * Difficulty：medium
 * <link> https://leetcode.cn/problems/unique-binary-search-trees/description/
 */
public class BuildBinarySearchTree {


    /**
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
     *
     *  示例 1：
     *
     * 输入：n = 3
     * 输出：5
     *
     *  示例 2：
     *
     * 输入：n = 1
     * 输出：1
     *
     */

    /**
     *
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        return countBST(1, n);
    }

    /**
     * 递归
     * @param start
     * @param end
     * @return
     */
    private static int countBST(int start, int end) {

        if (start >= end) {
            return 1;
        }
        int count = 0;
        for (int i = start; i <= end; i++) {
            //左子树数量
            int leftCount = countBST(start, i - 1);
            //右子树数量
            int rightCount = countBST(i + 1, end);
            count += leftCount * rightCount;
        }
        return count;
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    private static int dpCountBST(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        //控制构建二叉搜索树的数组长度
        for (int i = 2; i <= n; i++){
            //以那个位置的树为root节点
            for (int j = 1; j <= i; j++){
                //dp[j - 1] 相当于 以 j 为root 左子树的数量
                //dp[i - j] 相当于 以 j 为root 右子树的数量
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        //递归
        System.out.println(numTrees(4));
        //动态规划
        System.out.println(dpCountBST(4));
    }
}
