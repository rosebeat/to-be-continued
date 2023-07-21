package com.example.leetcode.tree;

import com.example.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kai·yang
 * @Date 2023/7/21 14:18
 *
 * leetcode: 【106】从中序与后序遍历序列构造二叉树
 * level：medium
 * <link>https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class Coding_106 {

    /**
     *给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， post
     * 返回这颗 二叉树
     *
     *  示例 1:
     *
     * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
     * 输出：[3,9,20,null,null,15,7]
     *
     *  示例 2:
     *
     * 输入：inorder = [-1], postorder = [-1]
     * 输出：[-1]
     *
     *
     *  提示:
     *
     *  1 <= inorder.length <= 3000
     *  postorder.length == inorder.length
     *  -3000 <= inorder[i], postorder[i] <= 3000
     *  inorder 和 postorder 都由 不同 的值组成
     *  postorder 中每一个值都在 inorder 中
     *  inorder 保证是树的中序遍历
     *  postorder 保证是树的后序遍历
     *
     *  Related Topics 树 数组 哈希表 分治 二叉树
     */


    Map<Integer, Integer> position = new HashMap<>();
    int[] post;


    /**
     *
     * 中序遍历的顺序是每次遍历左孩子，再遍历根节点，最后遍历右孩子。
     * 后序遍历的顺序是每次遍历左孩子，再遍历右孩子，最后遍历根节点。
     *
     * 后序遍历最后一个节点既是根节点
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post = postorder;
        for (int i = 0; i < inorder.length; i++){
            position.put(inorder[i], i);
        }
        TreeNode root = doBuild(0, inorder.length - 1, 0, postorder.length - 1);
        return root;
    }

    /**
     *
     * @param inStart 中序遍历起始位置
     * @param inEnd 中序遍历终止位置
     * @param postStart 后续遍历起始位置
     * @param postEnd 后续遍历终止位置
     * @return
     */
    public TreeNode doBuild(int inStart, int inEnd, int postStart, int postEnd){
        if (inEnd < inStart || postEnd < postStart){
            return null;
        }
        //跟节点值
        int rootValue = post[postEnd];
        //根节点在中序遍历中的位置
        int inRootPosition = position.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        //左子树
        root.left = doBuild(inStart, inRootPosition - 1, postStart, postStart + inRootPosition - inStart - 1 );
        //右子树
        root.right = doBuild(inRootPosition + 1, inEnd, postStart + inRootPosition - inStart,  postEnd - 1);
        return root;
    }
}
