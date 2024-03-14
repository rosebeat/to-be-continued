package com.example.leetcode.tree;

import com.example.util.TreeNode;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author kai·yang
 * @Date 2023/7/5 16:23
 *
 * leetcode: 【二叉树的锯齿形层次遍历】
 * level：medium
 * <link>https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 */
public class Coding_103 {

    /**
     * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下
     *
     *  示例 1：
     *
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[[3],[20,9],[15,7]]
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
     *  -100 <= Node.val <= 100
     *
     *  Related Topics 树 广度优先搜索 二叉树
     */


    /**
     * 即先从左往右，再从右往左进行遍历
     *
     * 按照正常的层次遍历，根据同层级的节点反转对应的结果即可
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isOrderLeft = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> itemLevel = new LinkedList<>();
            for (int i = 0; i < size; i++){
                TreeNode poll = queue.poll();
                itemLevel.add(poll.val);
                if ( poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
            }
            //反转结果
            if (!isOrderLeft){
                Collections.reverse(itemLevel);
            }
            result.add(itemLevel);
            isOrderLeft = !isOrderLeft;
        }
        return result;
    }


    /**
     * 20240304 复习
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder20240304(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        boolean isLeft = true;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> item = new ArrayList<>();
            for (int i = 0; i < levelSize; i++){
                TreeNode poll = queue.poll();
                item.add(poll.val);
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
            }
            if (!isLeft){
                Collections.reverse(item);
            }
            result.add(item);
            isLeft = !isLeft;
        }

        return result;
    }


}
