package com.example.leetcode.tree;

import com.example.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kai·yang
 * @Date 2023/7/20 11:28
 *
 * leetcode: 【513】找树左下角的值
 * level：medium
 * <link> https://leetcode.cn/problems/find-bottom-left-tree-value/
 */
public class Coding_513 {

    /**
     * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
     *  假设二叉树中至少有一个节点。
     *
     *  示例 1:
     *
     *
     * 输入: root = [2,1,3]
     * 输出: 1
     *
     *  示例 2:
     *
     * 输入: [1,2,3,4,null,5,6,null,null,7]
     * 输出: 7
     *
     *  提示:
     *
     *  二叉树的节点个数的范围是 [1,104]
     *  -231 <= Node.val <= 231 - 1
     *
     *  Related Topics 树 深度优先搜索 广度优先搜索 二叉树
     */


    /**
     * 广度优先遍历
     *
     * 使用广度优先遍历 从 右 向 左 依次遍历节点，最后一个节点即为 最底层左侧节点（不一定是左节点）
     * 1、使用队列依次把该节点的 非空右节点和非空左节点依次放入队列中，这样即可 实现从右往左遍历
     *
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        int result = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            TreeNode poll = que.poll();
            if (poll.right != null) {
                que.offer(poll.right);
            }
            if (poll.left != null) {
                que.offer(poll.left);
            }
            result = poll.val;
        }
        return result;
    }


    /**
     * 最大高度
     */
    int maxH = 0;
    int ans = 0;

    /**
     * 深度优先遍历
     * 先遍历左子树，再遍历右子树 比较当前高度和最大高度
     * @param root
     * @return
     */
    public int findBottomLeftValueV2(TreeNode root){
        doFind(root, 0);
        return ans;
    }

    public void doFind(TreeNode root, int high){
        if (root == null){
            return;
        }
        high++;
        doFind(root.left, high);
        doFind(root.right, high);
        if (high > maxH){
            maxH = high;
            ans = root.val;
        }
    }
}
