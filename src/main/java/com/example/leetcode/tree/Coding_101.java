package com.example.leetcode.tree;

import com.example.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author kai·yang
 * @Date 2023/7/12 15:34
 *
 * leetcode: 【101】对称二叉树(symmetric tree)
 * level: easy
 *
 */
public class Coding_101 {


    /**
     *给你一个二叉树的根节点 root ， 检查它是否轴对称。
     *
     *  示例 1：
     *
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     *
     *  示例 2：
     *
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     *
     *
     *  提示：
     *
     *  树中节点数目在范围 [1, 1000] 内
     *  -100 <= Node.val <= 100
     *
     *
     *  进阶：你可以运用递归和迭代两种方法解决这个问题吗？
     *  Related Topics 树 深度优先搜索 广度优先搜索 二叉树
     */


    /**
     * 迭代法
     * 使用队列进行比较左右子树
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        Deque<TreeNode> que= new LinkedList<>();
        que.offer(root.left);
        que.offer(root.right);
        while(!que.isEmpty()){
            TreeNode left = que.poll();
            TreeNode right = que.poll();
            if (left == null && right == null){
                continue;
            }
            if (left == null || right == null || left.val != right.val){
                return false;
            }
            //注意添加顺序，左右子树要对称添加
            que.offer(left.left);
            que.offer(right.right);
            que.offer(left.right);
            que.offer(right.left);
        }
        return true;
    }


    /**
     * 递归
     * @param root
     * @return
     */
    public boolean isSymmetricV2(TreeNode root){
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        boolean outer = check(left.left, right.right);

        boolean inner = check(left.right, right.left);
        return outer && inner;
    }
}
