package com.example.leetcode.tree;

import com.example.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kai·yang
 * @Date 2023/7/14 15:36
 *
 * leetcode: 【104】二叉树的最大深度
 * level：easy
 * <link> https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 */
public class Coding_104 {

    /**
     * 给定一个二叉树，找出其最大深度。
     *  二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *  说明: 叶子节点是指没有子节点的节点。
     *  示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *      3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *  返回它的最大深度 3 。
     *  Related Topics 树 深度优先搜索 广度优先搜索 二叉树
     */


    /**
     *
     * DFS(深度优先)
     * 递归查找
     *
     * 二叉树的高度 = MAX(leftD, rightD) + 1
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftD = maxDepth(root.left);
        int rightD = maxDepth(root.right);
        return Math.max(leftD, rightD) + 1;
    }


    /**
     * 根据二叉树的层次遍历计算深度
     * BDS(广度优先)
     * @param root
     * @return
     */
    public int maxDepthV2(TreeNode root){
        if (root == null) {
            return 0;
        }
        int deep = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            for (int i = 0; i < size; i++){
                TreeNode poll = que.poll();
                if (poll.left != null){
                    que.offer(poll.left);
                }
                if (poll.right != null){
                    que.offer(poll.right);
                }
            }
            deep += 1;
        }
        return deep;
    }

}
