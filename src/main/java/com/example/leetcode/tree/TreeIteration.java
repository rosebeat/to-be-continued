package com.example.leetcode.tree;

import com.example.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author kai·yang
 * @Date 2023/7/10 15:07
 */
public class TreeIteration {


    /**
     * 先序遍历
     * 循环遍历版本
     * @param root
     * @return
     */
    public List<Integer> preorder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            result.add(pop.val);
            //栈先进后出，所以先压右子树
            if (pop.right != null){
                stack.push(pop.right);
            }
            if (pop.left != null){
                stack.push(pop.left);
            }
        }
        return result;
    }


    /**
     * 中序遍历
     * 循环遍历版本
     * @param root
     * @return
     */
    public List<Integer> inorder(TreeNode root){
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current != null || !stack.isEmpty()){
            if (current != null){
                stack.push(current);
                current = current.left;
            }else{
                TreeNode pop = stack.pop();
                result.add(pop.val);
                current = pop.right;
            }
        }
        return result;
    }


    /**
     * Morris(莫里斯)中序遍历
     *
     * 思路与算法：
     *      Morris 遍历算法是另一种遍历二叉树的方法，它能将非递归的中序遍历空间复杂度降为 O(1)。
     *
     * Morris 遍历算法整体步骤如下（假设当前遍历到的节点为 x）：
     *   1、如果 x 没有左孩子，则将x加入结果集中，x指向右孩子，即 x=x.right
     *   2、如果 x 有左孩子，则找到 x 左子树中最右节点（左子树 中序遍历最后一个节点） 记为：predecessor 根据 predecessor 是否有右孩子进行如下操作
     *     2.1、如果 predecessor 没有右孩子，则 predecessor的右孩子指向 x，即 predecessor.right = x，然后访问左孩子，即 x=x.left
     *     2.2、如果 predecessor 不为空，此时 predecessor 右孩子指向 x，则说明 x 左子树已经遍历完成，将predecessor右孩子置为空，将x
     *          加入结果集，然后访问 x 右孩子，即 x = x.right
     *   3、重复以上步骤，直至访问完整棵树
     * @param root
     * @return
     */
    public List<Integer> inorderV2(TreeNode root){
        List<Integer> result = new ArrayList<>();
        while(root != null){
            TreeNode left = root.left;
            //找到 x 左子树最右节点(左子树中序遍历最后一个节点)
            if (left != null){
                TreeNode predecessor = left;
                if (predecessor.right != null && predecessor.right != root){
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null){
                    predecessor.right = root;
                    root = root.left;
                }
                //说明 x 左子树已经遍历完毕，断开 predecessor 右孩子指向x连接，开始遍历 x 右子树
                else {
                    result.add(root.val);
                    //断开连接
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // x 没有左孩子，x直接加入结果集，遍历右孩子
            else{
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }


    /**
     * 后续遍历
     * 循环遍历版本
     *
     * 中右左  ->  反转之后  左右中
     * @param root
     * @return
     */
    public List<Integer> postorder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            result.add(pop.val);
            //这里和先序遍历 左右顺序相反
            if (pop.left != null){
                stack.push(pop.left);
            }
            if (pop.right != null){
                stack.push(pop.right);
            }
        }
        //反转结果集
        Collections.reverse(result);
        return result;
    }
}
