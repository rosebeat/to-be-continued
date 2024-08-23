package com.example.leetcode.hot100;

import com.example.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: kai·yang
 * @Date: 2024/7/23 10:57
 * @Description:
 *
 * LeetCode: 【199】二叉树的右视图
 * Difficulty: medium
 * <link> https://leetcode.cn/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_xxx_199 {


    /**
     * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     *
     *
     *
     * 示例 1:
     *
     *
     *
     * 输入: [1,2,3,null,5,null,4]
     * 输出: [1,3,4]
     * 示例 2:
     *
     * 输入: [1,null,3]
     * 输出: [1,3]
     * 示例 3:
     *
     * 输入: []
     * 输出: []
     *
     *
     * 提示:
     *
     * 二叉树的节点个数的范围是 [0,100]
     * -100 <= Node.val <= 100
     */


    /**
     * 解题思路：
     *      二叉树的层次遍历，每层最后一个节点，就是二叉树的右视图
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int floorSize = queue.size();
            for (int i = 0; i < floorSize; i++){
                TreeNode poll = queue.poll();
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
                //找到每层最后一个节点
                if (i == floorSize - 1){
                    result.add(poll.val);
                }
            }
        }
        return result;
    }

}
