package com.example.leetcode.tree;

import com.example.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kai·yang
 * @Date 2023/7/7 15:21
 *
 * 二叉树的 前中后序递归遍历
 *
 */
public class TreeRecursion {


    /**
     * 递归
     * 先序遍历
     * @param root
     * @return
     */
    public List<Integer> preorder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        preorder(root,result);
        return result;
    }

    public void preorder(TreeNode root, List<Integer> result){
        if (root == null){
            return;
        }
        //递归先序遍历的要点：先把节点的指放入结果集，再递归左子树和右子树
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }






    /**
     * 递归
     * 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public void inorder(TreeNode root, List<Integer> result){
        if (root == null){
            return;
        }
        //递归中序遍历的要点是：左子树 -> 根 -> 右子树
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }


    /**
     * 递归
     * 后续遍历
     * @param root
     * @return
     */
    public List<Integer> postorder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }


    public void postorder(TreeNode root, List<Integer> result){
        if (root == null){
            return;
        }
        //递归中序遍历的要点是：左子树 ->  右子树 -> 根
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }
}
