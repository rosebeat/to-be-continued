package com.example.leetcode.tree;

import com.example.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author kai·yang
 * @Date 2023/7/17 15:01
 *
 * leetcode: 【222】完全二叉树的节点个数
 * level：medium
 * <link>https://leetcode.cn/problems/count-complete-tree-nodes/
 */
public class Coding_222 {

    /**
     * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
     *  完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并
     * 为第 h 层，则该层包含 1~ 2h 个节点。
     *
     *  示例 1：
     *
     * 输入：root = [1,2,3,4,5,6]
     * 输出：6
     *
     *  示例 2：
     *
     * 输入：root = []
     * 输出：0
     *
     *  示例 3：
     *
     * 输入：root = [1]
     * 输出：1
     *
     *
     *  提示：
     *
     *  树中节点的数目范围是[0, 5 * 104]
     *  0 <= Node.val <= 5 * 104
     *  题目数据保证输入的树是 完全二叉树
     *
     *
     *  进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
     *  Related Topics 树 深度优先搜索 二分查找 二叉树
     */


    /**
     * 迭代法
     * 二叉树的层次遍历
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            count++;
            TreeNode poll = que.poll();
            if (poll.left != null){
                que.offer(poll.left);
            }
            if (poll.right != null){
                que.offer(poll.right);
            }
        }
        return count;
    }


    /**
     * 递归
     * @param root
     * @return
     */
    public int countNodesV2(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftCount = countNodesV2(root.left);
        int rightCount = countNodesV2(root.right);
        return leftCount + rightCount + 1;
    }
}
