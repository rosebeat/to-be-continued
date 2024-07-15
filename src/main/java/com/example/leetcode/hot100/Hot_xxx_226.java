package com.example.leetcode.hot100;

import com.example.util.TreeNode;

import java.util.Stack;

/**
 * @author: kai·yang
 * @Date: 2024/7/15 15:56
 * @Description:
 *
 * LeetCode: 【226】反转二叉树
 * Difficulty：easy
 * <link>
 */
public class Hot_xxx_226 {


    /**
     *
     */


    /**
     *
     * 深度优先，从叶子节点开始交换
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


    public TreeNode invertTreeV2(TreeNode root){
        if (root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            //交换该节点的左右节点
            swap(pop);
            if (pop.left != null){
                stack.push(pop.left);
            }
            if (pop.right != null){
                stack.push(pop.right);
            }
        }
        return root;
    }

    public void swap(TreeNode node){
        TreeNode left = node.left;
        node.left = node.right;
        node.right = left;
    }



}
