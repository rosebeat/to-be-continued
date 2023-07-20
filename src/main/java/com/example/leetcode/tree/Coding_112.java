package com.example.leetcode.tree;

import com.example.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kai·yang
 * @Date 2023/7/20 16:33
 *
 * leetcode: 【112】路径总和
 * level：easy
 * <link>https://leetcode.cn/problems/path-sum/
 */
public class Coding_112 {

    /**
     * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
     *  targetSum 。如果存在，返回 true ；否则，返回 false 。
     *  叶子节点 是指没有子节点的节点。
     *
     *  示例 1：
     *
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
     * 输出：true
     * 解释：等于目标和的根节点到叶节点路径如上图所示。
     *
     *  示例 2：
     *
     * 输入：root = [1,2,3], targetSum = 5
     * 输出：false
     * 解释：树中存在两条根节点到叶子节点的路径：
     * (1 --> 2): 和为 3
     * (1 --> 3): 和为 4
     * 不存在 sum = 5 的根节点到叶子节点的路径。
     *  示例 3：
     *
     * 输入：root = [], targetSum = 0
     * 输出：false
     * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
     *
     *
     *  提示：
     *
     *  树中节点的数目在范围 [0, 5000] 内
     *  -1000 <= Node.val <= 1000
     *  -1000 <= targetSum <= 1000
     *
     *  Related Topics 树 深度优先搜索 广度优先搜索 二叉树
     */


    /**
     * 深度优先遍历
     * 递归
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return doSum(root, targetSum, 0);
    }

    public boolean doSum(TreeNode root, int targetSum, int curSum){
        if (root == null) {
            return false;
        }
        curSum += root.val;
        //是叶子节点 并且 路径和等于目标值
        if (root.left == null && root.right == null && targetSum == curSum) {
            return true;
        }
        boolean left = doSum(root.left, targetSum, curSum);
        boolean right = doSum(root.right, targetSum, curSum);
        //左子树 或者 右子树  有一个符合条件即可
        return left || right;
    }


    /**
     * 广度优先遍历
     * 迭代
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSumV2(TreeNode root, int targetSum){
        if (root == null) {
            return false;
        }
        Queue<TreeNode> node = new LinkedList<>();
        Queue<Integer> value = new LinkedList<>();
        node.offer(root);
        value.offer(root.val);
        while (!node.isEmpty()) {
            TreeNode poll = node.poll();
            int item = value.poll();
            if (poll.left == null && poll.right == null && item == targetSum){
                return true;
            }
            if (poll.left != null) {
                node.offer(poll.left);
                value.offer(poll.left.val + item);
            }
            if (poll.right != null) {
                node.offer(poll.right);
                value.offer(poll.right.val + item);
            }
        }
        return false;
    }
}
