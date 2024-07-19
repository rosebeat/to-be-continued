package com.example.leetcode.hot100;

import com.example.util.TreeNode;

/**
 * @author: kai·yang
 * @Date: 2024/7/16 11:34
 * @Description:
 *
 * LeetCode；【543】二叉树的直径
 * Difficulyt：easy
 * <link>https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_xxx_543 {

    /**
     * 给你一棵二叉树的根节点，返回该树的 直径 。
     *
     * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
     *
     * 两节点之间路径的 长度 由它们之间边数表示。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,2,3,4,5]
     * 输出：3
     * 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
     * 示例 2：
     *
     * 输入：root = [1,2]
     * 输出：1
     *
     *
     * 提示：
     *
     * 树中节点数目在范围 [1, 104] 内
     * -100 <= Node.val <= 100
     */


    /**
     *
     * 递归
     *  树的直径相当于root节点（不算root）的 左子树的最大深度 + 右子树的最大深度
     *
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root){
        if (root == null){
            return 0;
        }

        return leftRightDepth(root.left) + leftRightDepth(root.right);
    }

    public int leftRightDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int l = leftRightDepth(root.left);
        int r = leftRightDepth(root.right);
        return Math.max(l, r) + 1;
    }




}
