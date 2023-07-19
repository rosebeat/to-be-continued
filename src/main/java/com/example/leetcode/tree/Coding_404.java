package com.example.leetcode.tree;

import com.example.util.TreeNode;

import java.util.Stack;

/**
 * @author kai·yang
 * @Date 2023/7/19 17:18
 *
 * leetcode: 【404】左叶子之和
 * level：easy
 * <link>https://leetcode.cn/problems/sum-of-left-leaves/
 */
public class Coding_404 {

    /**
     * 给定二叉树的根节点 root ，返回所有左叶子之和。
     *
     *  示例 1：
     *
     *
     * 输入: root = [3,9,20,null,null,15,7]
     * 输出: 24
     * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
     *
     *  示例 2:
     *
     * 输入: root = [1]
     * 输出: 0
     *
     *  提示:
     *
     *  节点数在 [1, 1000] 范围内
     *  -1000 <= Node.val <= 1000
     *
     *  Related Topics 树 深度优先搜索 广度优先搜索 二叉树
     */


    /**
     * 先序遍历变形 深度优先
     * 迭代
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return 0;
        }
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if (pop.left != null && pop.left.left == null && pop.left.right == null) {
                sum += pop.left.val;
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        return sum;
    }
}
