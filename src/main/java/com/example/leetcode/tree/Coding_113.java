package com.example.leetcode.tree;

import com.example.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: kai·yang
 * @Date: 2024/3/20 17:53
 * @Description:
 *
 * LeetCode: 【113】 路径总和II
 * Difficulty: easy
 * <Link> https://leetcode.cn/problems/path-sum-ii/description/
 */
public class Coding_113 {


    /**
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等
     *  叶子节点 是指没有子节点的节点。
     *
     *  示例 1：
     *
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targe
     * 输出：[[5,4,11,2],[5,8,4,5]]
     *
     *  示例 2：
     *
     * 输入：root = [1,2,3], targetSum = 5
     * 输出：[]
     *
     *  示例 3：
     *
     * 输入：root = [1,2], targetSum = 0
     * 输出：[]
     *
     *  提示：
     *
     *  树中节点总数在范围 [0, 5000] 内
     *  -1000 <= Node.val <= 1000
     *  -1000 <= targetSum <= 1000
     *
     *  Related Topics 树 深度优先搜索 回溯 二叉树
     *  👍 1093 👎 0
     *
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        path(root, targetSum, result, new ArrayDeque<Integer>());
        return result;
    }

    public void path(TreeNode root, int targetSum, List<List<Integer>> pathResult, ArrayDeque<Integer> item){
        if (root == null){
            return;
        }
        item.offerLast(root.val);
        //叶子节点
        if (root.left == null && root.right == null && targetSum - root.val == 0){
            pathResult.add(new ArrayList<>(item));
        }
        //左子树
        path(root.left,targetSum - root.val, pathResult, item);
        //右子树
        path(root.right,targetSum - root.val, pathResult, item);
        //在这里弹出，因为叶子节点的 left 和 right 都是 null，直接return 所以把当前节点要移除
        item.pollLast();

    }

}
