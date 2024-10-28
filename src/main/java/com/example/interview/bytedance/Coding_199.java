package com.example.interview.bytedance;

import com.example.util.TreeNode;

import java.util.*;

/**
 * @Ahthor k·Young
 * @Date 2024/10/28 10:40
 * @Version 1.0
 * @Desc
 *
 * 字节面试算法汇总
 * LeetCode: 【199】二叉树的右视图
 * Difficulty: medium
 *
 */
public class Coding_199 {


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
     * 广度优先
     * 基于二叉树的层次遍历
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode poll = queue.poll();
                if (poll.left != null){
                    queue.add(poll.left);
                }
                if (poll.right != null){
                    queue.add(poll.right);
                }
                if (i == size - 1){
                    res.add(poll.val);
                }
            }

        }
        return res;
    }


    /**
     * 深度优先 -- 递归版本
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideViewV2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        return res;
    }


    public void dfs(List<Integer> res, TreeNode root, int d){
        if (root == null){
            return;
        }
        // 这个深度首次遇到，添加到结果集
        if (d == res.size()){
            res.add(root.val);
        }
        //必须先进行右子树查找
        dfs(res, root.right, d + 1);
        //左子树
        dfs(res, root.left, d + 1);
    }


    /**
     * 深度优先 -- 非递归版本
     * @param root
     * @return
     */
    public List<Integer> rightSideViewV3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        int d = 0;
        Stack<TreeNode> stack = new Stack<>();
        Map<Integer, Boolean> map = new HashMap<>();
        Stack<Integer> depthStack = new Stack<>();
        stack.push(root);
        depthStack.push(d);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            Integer dd = depthStack.pop();
            if (pop != null){
                //是否是第一次添加
                if (!map.containsKey(dd)){
                    res.add(pop.val);
                }
                stack.push(pop.left);
                stack.push(pop.right);
                depthStack.push(d + 1);
                depthStack.push(d + 1);
            }
        }
        return res;
    }



}
