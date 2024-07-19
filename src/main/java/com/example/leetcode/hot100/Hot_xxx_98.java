package com.example.leetcode.hot100;

import com.example.util.TreeNode;

import java.util.Stack;

/**
 * @author: kai·yang
 * @Date: 2024/7/17 10:55
 * @Description:
 *
 * LeetCode: 【98】 验证二叉搜索树
 * Difficulty：medium
 * <link>https://leetcode.cn/problems/validate-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class Hot_xxx_98 {

    /**
     *给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     *
     * 有效 二叉搜索树定义如下：
     *
     * 节点的左
     * 子树
     * 只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     *
     * 示例 1：
     *
     *
     * 输入：root = [2,1,3]
     * 输出：true
     * 示例 2：
     *
     *
     * 输入：root = [5,1,4,null,null,3,6]
     * 输出：false
     * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
     *
     *
     * 提示：
     *
     * 树中节点数目范围在[1, 104] 内
     * -231 <= Node.val <= 231 - 1
     */


    /**
     * 二叉搜索树的，中序遍历肯定是一个递增的有序集合，在遍历的时候判断是否符合要求
     *
     *
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root){
        if (root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        double preValue = -Double.MAX_VALUE;
        while(!stack.isEmpty() || current != null){
            if (current != null){
                stack.push(current);
                current = current.left;
            }else{
                TreeNode pop = stack.pop();
                if (preValue >= pop.val){
                    return false;
                }
                preValue = pop.val;
                current = pop.right;
            }
        }
        return true;
    }

}
