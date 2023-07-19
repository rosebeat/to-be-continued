package com.example.leetcode.tree;

import com.example.util.TreeNode;
import lombok.val;

import java.util.*;

/**
 * @author kai·yang
 * @Date 2023/7/19 14:22
 *
 * leetcode: 【257】二叉树的所有路径
 * level：easy
 * <link> https://leetcode.cn/problems/binary-tree-paths/
 */
public class Coding_257 {

    /**
     * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
     *  叶子节点 是指没有子节点的节点。
     *
     *  示例 1：
     *
     * 输入：root = [1,2,3,null,5]
     * 输出：["1->2->5","1->3"]
     *
     *  示例 2：
     *
     * 输入：root = [1]
     * 输出：["1"]
     *
     *
     *  提示：
     *
     *  树中节点的数目在范围 [1, 100] 内
     *  -100 <= Node.val <= 100
     *
     *  Related Topics 树 深度优先搜索 字符串 回溯 二叉树
     */


    /**
     * 前序遍历深度优先
     * 迭代
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //节点
        Stack<TreeNode> node = new Stack<>();
        //线路
        Stack<String> route = new Stack<>();
        node.push(root);
        route.push(String.valueOf(root.val));

        while(!node.isEmpty()){
            TreeNode poll = node.pop();
            String itemRoute = route.pop();
            if (poll.left == null && poll.right == null) {
                result.add(itemRoute);
            }
            if (poll.right != null){
                node.push(poll.right);
                route.push(itemRoute + "->" + poll.right.val);
            }

            if (poll.left != null){
                node.push(poll.left);
                route.push(itemRoute + "->" + poll.left.val);
            }
        }
        return result;
    }


    /**
     * 先序遍历变形
     * 递归
     * @param root
     * @return
     */
    public List<String> binaryTreePathsV2(TreeNode root){
        List<String> result = new ArrayList<>();
        doPath(root, "", result);
        return result;
    }

    public void doPath(TreeNode root, String path, List<String> result){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            path = path + root.val;
            result.add(path);
            return;
        }
        //左子树
        doPath(root.left, path + root.val + "->", result);
        //右子树
        doPath(root.right, path + root.val + "->", result);
    }
}
