package com.example.leetcode.tree;

import com.example.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author kai·yang
 * @Date 2023/7/11 15:23
 *
 * leetcode: 【226】翻转二叉树
 * level：easy
 *
 */
public class Coding_226 {

    /**
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     *
     *  示例 1：
     *
     *
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     *
     *  示例 2：
     *
     *
     * 输入：root = [2,1,3]
     * 输出：[2,3,1]
     *
     *  示例 3：
     *
     * 输入：root = []
     * 输出：[]
     *
     *
     *  提示：
     *
     *  树中节点数目范围在 [0, 100] 内
     *  -100 <= Node.val <= 100
     *
     *  Related Topics 树 深度优先搜索 广度优先搜索 二叉树
     */


    /**
     * 递归
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        invertTree(root.right);
        invertTree(root.left);
        swap(root);
        return root;
    }


    /**
     * 遍历翻转
     * @param root
     * @return
     */
    public TreeNode invertTreeV2(TreeNode root){
        if (root == null){
            return null;
        }
        Deque<TreeNode> que = new ArrayDeque<>();
        que.offer(root);
        while(!que.isEmpty()){
            TreeNode pop = que.pop();
            swap(pop);
            if (pop.left != null){
                que.offer(pop.left);
            }
            if (pop.right != null){
                que.offer(pop.right);
            }
        }
        return root;
    }

    private void swap(TreeNode node){
        TreeNode left = node.left;
        node.left = node.right;
        node.right = left;
    }
}
