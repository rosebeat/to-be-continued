package com.example.leetcode.dp;

import com.example.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: kai·yang
 * @Date: 2024/3/28 17:51
 * @Description:
 *
 * LeetCode: 【95】不同的二叉搜索树II
 * Difficulty: medium
 * <link> https://leetcode.cn/problems/unique-binary-search-trees-ii/description/
 */
public class Coding_95 {


    /**
     * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
     *
     *  示例 1：
     *
     * 输入：n = 3
     * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
     *
     *  示例 2：
     *
     * 输入：n = 1
     * 输出：[[1]]
     *
     *  提示：
     *
     *  1 <= n <= 8

     *  Related Topics 树 二叉搜索树 动态规划 回溯 二叉树
     *  👍 1539 👎 0
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0){
            return new ArrayList<TreeNode>();
        }
        return doGenerateTrees(1, n);
    }


    /**
     * 回溯
     * @param start
     * @param end
     * @return
     */
    public List<TreeNode> doGenerateTrees(int start, int end){
        List<TreeNode> result = new ArrayList<>();
        //已经是叶子节点
        if (start > end){
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++){
            //所有可行的左子树集合
            List<TreeNode> leftTrees = doGenerateTrees(start, i - 1);
            //所有可行的右子树集合
            List<TreeNode> rightTrees = doGenerateTrees(i + 1, end);
            //从左子树集合中选出一棵，从右子树集合选出一棵，拼接到根节点
            for (TreeNode left : leftTrees){
                for (TreeNode right : rightTrees){
                    TreeNode curNode = new TreeNode(i);
                    curNode.left = left;
                    curNode.right = right;
                    result.add(curNode);
                }
            }
        }
        return result;
    }
}
