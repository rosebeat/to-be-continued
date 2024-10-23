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
     * 递归
     * 树的直径 ==
     * 记当前节点为 X，X节点左子树的最大深度为L， X节点右子树的最大深度为R， 那么以X为起始位置的最大节点数为：L + R + 1
     * 那么树的宽度 等于 最大节点树 减一
     *
     * @param root
     * @return
     */

    //树的最长节点数
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root){
        if (root == null){
            return 0;
        }
        depth(root);
        //最长路径
        return ans - 1;
    }

    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        //以该节点出发，左子树和右子树最多节点数
        ans = Math.max(ans, l + r + 1);
        return Math.max(l, r) + 1;
    }




}
