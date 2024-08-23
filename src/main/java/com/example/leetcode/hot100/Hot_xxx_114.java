package com.example.leetcode.hot100;

import com.example.util.TreeNode;

/**
 * @author: kai·yang
 * @Date: 2024/7/23 11:17
 * @Description:
 *
 * LeetCode: 【114】二叉树展开为链表
 * Difficulty：medium
 * <link>https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_xxx_114 {


    /**
     *给你二叉树的根结点 root ，请你将它展开为一个单链表：
     *
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     *
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,2,5,3,4,null,6]
     * 输出：[1,null,2,null,3,null,4,null,5,null,6]
     * 示例 2：
     *
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：root = [0]
     * 输出：[0]
     *
     *
     * 提示：
     *
     * 树中结点数在范围 [0, 2000] 内
     * -100 <= Node.val <= 100
     *
     *
     * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
     */


    /**
     * 方法一：
     *  1、将右子树接到左子树最右侧节点上
     *  2、左子树指向根节点的右孩子节点，根节点左孩子指向null
     *  3、当前节点指向右节点，重复以上步骤
     * @param root
     */
    public void flatten(TreeNode root){
        TreeNode current = root;
        while(current != null){

            //没有左子树
            if(current.left == null){
                current = current.right;
            }else{
                //找到左子树 最右侧的节点
                TreeNode per = current.left;
                while (per.right != null){
                    per = per.right;
                }
                //将当前节点的右子树 接到 左子树最右侧的节点上
                per.right = current.right;
                //当前节点的左子树指向 右子树
                current.right = current.left;
                //当前节点的左子树置为null
                current.left = null;
                //指向下一个节点
                current = current.right;
            }
        }


    }

}
