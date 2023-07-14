package com.example.leetcode.tree;

import com.example.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kai·yang
 * @Date 2023/7/14 10:04
 *
 * leetcode: 【114】二叉树展开为链表
 * level: medium
 * <link>https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 * company: 字节
 */
public class Coding_114 {

    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     *
     *  展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 nu
     *  展开后的单链表应该与二叉树 先序遍历 顺序相同。
     *
     *
     *  示例 1：
     *
     * 输入：root = [1,2,5,3,4,null,6]
     * 输出：[1,null,2,null,3,null,4,null,5,null,6]
     *
     *  示例 2：
     *
     * 输入：root = []
     * 输出：[]
     *
     *  示例 3：
     *
     * 输入：root = [0]
     * 输出：[0]
     *
     *
     *  提示：
     *
     *  树中结点数在范围 [0, 2000] 内
     *  -100 <= Node.val <= 100
     *
     *
     *  进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
     *  Related Topics 栈 树 深度优先搜索 链表 二叉树
     */


    /**
     * 方法一：先序遍历
     * 通过先序遍历获取到各个节点的顺序，在修改左孩子和右孩子的引用
     *
     * 时间复杂度：O(n)
     * 空间复杂度: O(n)
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        List<TreeNode> order = new ArrayList<>();
        preorder(root, order);
        for (int i = 1; i < order.size(); i++) {
            TreeNode before = order.get(i - 1);
            TreeNode cur = order.get(i);
            before.left = null;
            before.right = cur;
        }
    }

    private void preorder(TreeNode root, List<TreeNode> order){
        if (root == null){
            return;
        }
        order.add(root);
        preorder(root.left, order);
        preorder(root.right, order);
    }


    /**
     * 迭代法
     *
     * 时间复杂度：O(n)
     * 空间复杂度: O(n)
     * @param root
     */
    public void flattenV2(TreeNode root){
        //双向链表，实现栈结构
        Deque<TreeNode> que = new LinkedList<>();
        //压栈
        que.push(root);
        TreeNode prev = new TreeNode();
        while(!que.isEmpty()){
            //弹出
            TreeNode pop = que.pop();
            prev.left = null;
            prev.right = pop;
            if (pop.right != null){
                que.push(pop.right);
            }
            if (pop.left != null){
                que.push(pop.left);
            }
            prev = pop;
        }
    }


    /**
     * 类似于莫里斯中序遍历
     *
     * 思路：假设当前遍历的节点为 X
     *  分两种种情况处理：
     *    1、X 没有左孩子， X 直接指向右孩子，即 X = X.right
     *
     *    2、X 有左孩子， 找到 X 左子树最右侧节点（先序遍历最后一个节点），记为 predecessor
     *       2.1 predecessor 右孩子指向 X 的右孩子，即 predecessor.right = X.right
     *       2.2 X 的右孩子指向最孩子，X 的左孩子置为 null ,即 X.right = X.left， X.left = null
     *    3、重复以上步骤，遍历完整棵树
     *
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param root
     */
    public void flattenV3(TreeNode root){
         TreeNode x = root;
        while(x != null){
            TreeNode left = x.left;
            //有左子树
            if(left != null){
                //找到左子树最右侧节点（先序遍历最后一个节点）
                TreeNode predecessor = left;
                while(predecessor.right != null){
                    predecessor = predecessor.right;
                }
                predecessor.right = x.right;
                x.right = x.left;
                x.left = null;
                x = x.right;

            }else{
                root = root.right;
            }
        }
    }
}
