package com.example.leetcode.tree;

import com.example.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kai·yang
 * @Date 2023/7/13 14:23
 *
 * leetcode: 【102】二叉树的层次遍历
 * level：easy
 * <link> https://leetcode.cn/problems/binary-tree-level-order-traversal/
 */
public class Coding_102 {

    /**
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层
     *
     *  示例 1：
     *
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[[3],[9,20],[15,7]]
     *
     *  示例 2：
     *
     * 输入：root = [1]
     * 输出：[[1]]
     *
     *  示例 3：
     *
     * 输入：root = []
     * 输出：[]
     *
     *
     *  提示：
     *
     *  树中节点数目在范围 [0, 2000] 内
     *  -1000 <= Node.val <= 1000
     *
     *  Related Topics 树 广度优先搜索 二叉树
     */


    /**
     * BFS(breadth first search) 宽度优先遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            //当前层级节点数量
            int levelSize = que.size();
            List<Integer> item = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = que.poll();
                item.add(poll.val);
                if (poll.left != null) {
                    que.offer(poll.left);
                }

                if (poll.right != null) {
                    que.offer(poll.right);
                }
            }
            result.add(item);
        }
        return result;
    }

}
