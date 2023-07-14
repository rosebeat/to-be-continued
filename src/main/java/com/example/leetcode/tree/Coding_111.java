package com.example.leetcode.tree;

import com.example.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author kai·yang
 * @Date 2023/7/14 16:39
 *
 * leetcode: 【111】二叉树的最小深度
 * level：easy
 * <link>
 */
public class Coding_111 {

    /**
     * 给定一个二叉树，找出其最小深度。
     *  最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *  说明：叶子节点是指没有子节点的节点。
     *
     *  示例 1：
     *
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：2
     *
     *  示例 2：
     *
     * 输入：root = [2,null,3,null,4,null,5,null,6]
     * 输出：5
     *
     *
     *  提示：
     *
     *  树中节点数的范围在 [0, 105] 内
     *  -1000 <= Node.val <= 1000
     *
     *  Related Topics 树 深度优先搜索 广度优先搜索 二叉树
     */


    /**
     * BDS(广度优先)
     * 层次遍历
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int minDeep = 0;
        //给while 打个 outerLoop 标签，如果有多个循环嵌套，方便直接跳出整个循环
        outerLoop:while(!que.isEmpty()){
            minDeep++;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = que.poll();
                //找到叶子节点，就直接跳出
                if (poll.left == null && poll.right == null){
                    //跳出到outerLoop
                    break outerLoop;
                }
                if (poll.left != null){
                    que.offer(poll.left);
                }
                if (poll.right != null){
                    que.offer(poll.right);
                }
            }
        }
        return minDeep;
    }
}
