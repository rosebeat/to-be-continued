package com.example.leetcode.hot100;

import com.example.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: kai·yang
 * @Date: 2024/7/16 11:08
 * @Description:
 *
 *
 * LeetCode；【101】对称二叉树
 * Difficulyt：easy
 * <link>https://leetcode.cn/problems/symmetric-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_xxx_101 {


    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     *
     *
     *
     * 示例 1：
     *          1
     *       /     \
     *      2       2
     *    /  \    /  \
     *   3    4  3    4
     *
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * 示例 2：
     *
     *
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     *
     *
     * 提示：
     *
     * 树中节点数目在范围 [1, 1000] 内
     * -100 <= Node.val <= 100
     *
     *
     * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
     */


    /**
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root){
        return root == null || check(root, root);
    }


    public boolean check(TreeNode l, TreeNode r){
        if (l == null && r == null){
            return true;
        }
        if (l == null || r == null || l.val != r.val){
            return false;
        }
        //分别检查左右节点，同时相等才是对称
        return check(l.left, r.right) && check(l.right, r.left);
    }


    /**
     * 迭代
     * @param root
     * @return
     */
    public boolean isSymmetricV2(TreeNode root){
        if (root == null){
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        //把根节点添加两次，避免额外的判断
        q.offer(root);
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode l = q.poll();
            TreeNode r = q.poll();
            if (l == null && r == null){
                continue;
            }
            if (l == null || r == null){
                return false;
            }
            if (l.val != r.val){
                return false;
            }
            // 两棵树的 左右节点比较
            q.offer(l.left);
            q.offer(r.right);

            // 两棵树的 右左节点比较
            q.offer(l.right);
            q.offer(l.left);

        }
        return true;
    }


}
