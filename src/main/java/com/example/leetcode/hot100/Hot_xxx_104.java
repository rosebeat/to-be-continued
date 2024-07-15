package com.example.leetcode.hot100;

import com.example.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: kai·yang
 * @Date: 2024/7/15 11:53
 * @Description:
 *
 *
 * LeetCode: 【104】二叉树的最大深度
 * Difficulty：easy
 * <link> https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_xxx_104 {


    /**
     *给定一个二叉树 root ，返回其最大深度。
     *
     * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
     *
     *
     *
     * 示例 1：
     *         3
     *       / \
     *      9  20
     *        /  \
     *       15   7

     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：3
     * 示例 2：
     *
     * 输入：root = [1,null,2]
     * 输出：2
     *
     *
     * 提示：
     *
     * 树中节点的数量在 [0, 104] 区间内。
     *
     */


    /**
     * 深度优先
     *
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        //计算左子树深度
        int left = maxDepth(root.left);
        //计算右子树深度
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }


    /**
     * 广度优先
     *
     * @param root
     * @return
     */
    public int maxDepthV2(TreeNode root){
        if(root == null){
            return 0;
        }
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //控制层数
        while(!queue.isEmpty()){
            //每一层的数量
            int size = queue.size();
            //每一层元素
            while(size > 0){
                TreeNode poll = queue.poll();
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }


}
