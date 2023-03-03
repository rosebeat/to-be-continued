package com.example.leetcode.tree;

import com.example.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kai·yang
 * @Date 2023/2/1 17:15
 *
 * leetcode:
 *  description: 【94】 二叉树的中序遍历
 *  level：easy
 *
 */
public class Coding_94 {

    /**
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     *
     *  示例 1：
     *
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     *
     *  示例 2：
     *
     * 输入：root = []
     * 输出：[]
     */


    /**
     * 二叉树中序遍历
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderT(root, result);
        return result;
    }

    //中根（中序）遍历
    public static void inorderT(TreeNode root, List valueList){
        if (root == null){
            return ;
        }
        //左节点
        inorderT(root.getLeft(), valueList);

        valueList.add(root.getVal());
        System.out.println(root.getVal());
        //右节点
        inorderT(root.getRight(), valueList);

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        root.setRight(two);
        two.setLeft(three);
        List<Integer> integers = Coding_94.inorderTraversal(root);
        integers.forEach(i -> System.out.println(i));

    }

}
