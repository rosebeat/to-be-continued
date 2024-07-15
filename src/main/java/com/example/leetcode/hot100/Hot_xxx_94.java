package com.example.leetcode.hot100;

import com.example.util.ListNode;
import com.example.util.TreeNode;
import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: kai·yang
 * @Date: 2024/7/11 20:58
 * @Description:
 *
 *
 * LeetCode： 【94】二叉树的中序遍历
 * Difficulty：easy
 * <link> https://leetcode.cn/problems/binary-tree-inorder-traversal/description/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class Hot_xxx_94 {


    /**
     *
     * 递归
     *
     *
     * @param head
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode head){
        List<Integer> result = new ArrayList<>();
        inorder(head, result);
        return result;
    }


    public void inorder(TreeNode head, List<Integer> list){
        if (head == null){
            return;
        }
        inorder(head.left, list);
        list.add(head.val);
        inorder(head.right, list);
    }


    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalV2(TreeNode root){
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while(current != null || !stack.isEmpty()){
            if (current != null){
                stack.push(current);
                //压栈
                current = current.left;
            }else{
                TreeNode pop = stack.pop();
                result.add(pop.val);
                //处理右子树
                current = pop.right;
            }
        }
        return result;
    }


    /**
     * Morris(莫里斯) 中序遍历，可以将非递归的中序遍历空间复杂度将为O(1)
     *
     * Morris遍历答题思路：记当前遍历的节点为 X
     *      1、如果 X 没有左子树，则将 X 加入到结果集，然后 X = X。right
     *      2、如果 X 有左子树，则找到左子树最右侧的节点记为 predecessor（左子树一直right）
     *          2.1、如果predecessor 的右节点为空，则将predecessor的右节点指向 X，即 predecessor。right = X， 然后访问左孩子 X = X。left
     *          2.2、如果predecessor的右节点不为空，此时predecessor的右孩子指向X，则说明 X 的左子树已经遍历完毕，则将 predecessor的右孩子置为空，
     *              X加入结果集，X指向右孩子，X = X。right
     *      3、重复以上步骤
     *
     * @return
     */
    public List<Integer> inorderMorris(TreeNode root){
        List<Integer> result = new ArrayList<>();
        TreeNode x = root;
        while (x != null){

            if (x.left != null){
                //找到左子树最右侧节点（即为左子树中序遍历中最后一个节点）
                TreeNode predecessor = x.left;
                while(predecessor.right != null && predecessor.right != x){
                    predecessor = predecessor.right;
                }
                //将当前节点的 左子树最右侧节点的right之前当前节点X
                if (predecessor.right == null){
                    predecessor.right = x;
                    x = x.left;

                }
                // 当前节点的左子树已经遍历完毕
                else{
                    result.add(x.val);
                    predecessor.right = null;
                    x = x.right;
                }
            }else{
                result.add(x.val);
                x = x.right;
            }
        }
        return result;
    }

}
