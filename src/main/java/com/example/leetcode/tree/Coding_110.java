package com.example.leetcode.tree;

import com.example.util.TreeNode;

/**
 * @author kai·yang
 * @Date 2023/7/18 16:54
 *
 * leetcode: 【110】平衡二叉树
 * level：easy
 * <link>https://leetcode.cn/problems/balanced-binary-tree/
 */
public class Coding_110 {

    /**
     *给定一个二叉树，判断它是否是高度平衡的二叉树。
     *  本题中，一棵高度平衡二叉树定义为：
     *
     *  一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     *
     *
     *  示例 1：
     *
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：true
     *
     *  示例 2：
     *
     * 输入：root = [1,2,2,3,3,null,null,4,4]
     * 输出：false
     *
     *  示例 3：
     *
     * 输入：root = []
     * 输出：true
     *
     *
     *  提示：
     *
     *  树中的节点数在范围 [0, 5000] 内
     *  -104 <= Node.val <= 104
     *
     *  Related Topics 树 深度优先搜索 二叉树
     */


    public boolean isBalanced(TreeNode root) {
        return down(root) != -1;
    }


    public int down(TreeNode root){
        if (root == null){
            return 0;
        }
        //左子树高度
        int left = down(root.left);
        if (left == -1){
            return -1;
        }
        //右子树高度
        int right = down(root.right);
        if (right == -1){
            return -1;
        }
        //如果差值大于 1 返回 -1，反之返回该节点树的高度
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}
