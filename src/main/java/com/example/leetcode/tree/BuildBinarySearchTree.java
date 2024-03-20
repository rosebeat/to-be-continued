package com.example.leetcode.tree;

public class BuildBinarySearchTree {


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
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        //递归
        System.out.println(numTrees(4));  // 输出 5
        //动态规划
        System.out.println(dpCountBST(4));
    }
}
