package com.example.leetcode.hot100;

import com.example.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: kai·yang
 * @Date: 2024/8/23 16:01
 * @Description:
 *
 * LeetCode: 【105】前序遍历和中序遍历构造一个棵树
 * Difficulty：medium
 * <link> https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_xxx_105 {

    Map<Integer, Integer> inorderMapping = new HashMap<>();


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMapping.put(inorder[i], i);
        }

        return doBuildTree(preorder, 0, 0, inorder.length - 1);
    }


    /**
     * 递归构造一棵树
     * @param preorder
     * @param rootIndex
     * @param left
     * @param right
     * @return
     */
    public TreeNode doBuildTree(int[] preorder, int rootIndex, int left, int right){
        if (left > right){
            return null;
        }
        TreeNode root = new TreeNode(preorder[rootIndex]);
        //获取中序遍历中 root 节点的下标
        int inorderRootIndex = inorderMapping.get(preorder[rootIndex]);
        //递归构造左子树
        root.left = doBuildTree(preorder, rootIndex + 1, left, inorderRootIndex - 1);

        //递归构造右子树
        // inorderRootIndex - left 计算左子树的长度， 右子树在 root节点在先序遍历中的位置
        root.right = doBuildTree(preorder, rootIndex + (inorderRootIndex - left) + 1, inorderRootIndex + 1, right);
        return root;
    }


    /**
     * 迭代版本
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode doBuildTree(int[] preorder, int[] inorder){


        return null;
    }

}
