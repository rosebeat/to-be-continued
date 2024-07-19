package com.example.leetcode.hot100;

import com.example.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: kai·yang
 * @Date: 2024/7/17 10:21
 * @Description:
 *
 * LeetCode: 【102】二叉树的层次遍历
 * Difficulty：medium
 * <link>https://leetcode.cn/problems/binary-tree-level-order-traversal/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_xxx_102 {


    /**
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[[3],[9,20],[15,7]]
     * 示例 2：
     *
     * 输入：root = [1]
     * 输出：[[1]]
     * 示例 3：
     *
     * 输入：root = []
     * 输出：[]
     *
     *
     * 提示：
     *
     * 树中节点数目在范围 [0, 2000] 内
     * -1000 <= Node.val <= 1000
     */

    /**
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            //计算每一层元素个数
            int levelSize = queue.size();
            List<Integer> levelItem = new ArrayList<>();
            for (int i = 0; i < levelSize; i++){
                TreeNode poll = queue.poll();
                levelItem.add(poll.val);
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
            }
            result.add(levelItem);
        }
        return result;
    }

}
