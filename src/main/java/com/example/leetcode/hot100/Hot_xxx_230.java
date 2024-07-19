package com.example.leetcode.hot100;

import com.example.util.TreeNode;

import java.util.Stack;

/**
 * @author: kai·yang
 * @Date: 2024/7/18 11:34
 * @Description:
 *
 * LeetCode: 【230】二叉搜索树中第K小的元素
 * Difficulty: medium
 * <link> https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_xxx_230 {


    /**
     *给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：root = [3,1,4,null,2], k = 1
     * 输出：1
     * 示例 2：
     *
     *
     * 输入：root = [5,3,6,2,4,null,null,1], k = 3
     * 输出：3
     *
     *
     *
     *
     * 提示：
     *
     * 树中的节点数为 n 。
     * 1 <= k <= n <= 104
     * 0 <= Node.val <= 104
     *
     *
     * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
     */

    /**
     * 莫里斯中序遍历
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        TreeNode x = root;
        int ans = 0;
        while(x != null){
            TreeNode left = x.left;
            if (left != null){
                TreeNode predecessor = left;
                if (predecessor.right != null && predecessor.right != x){
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null){
                    predecessor.right = x;
                    x = x.left;
                }else{
                    // x 的左子树已经遍历完毕
                    // 将X加入结果集，x指向x的右节点
                    k--;
                    ans = x.val;
                    predecessor.right = null;
                    x = x.right;
                }

            }else{
                k--;
                ans = x.val;
                x = x.right;
            }
            if (0 == k){
                return ans;
            }
        }
        return ans;
    }


    public int kthSmallestV2(TreeNode root, int k){
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){

            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0){
                break;
            }
            root = root.right;
        }
        return root.val;
    }

}
