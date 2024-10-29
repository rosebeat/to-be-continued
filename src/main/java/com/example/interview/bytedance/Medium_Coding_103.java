package com.example.interview.bytedance;

import com.example.util.TreeNode;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @Ahthor k·Young
 * @Date 2024/10/29 13:47
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【103】二叉树的锯齿遍历
 * Difficulty: medium
 * Tag: 二叉树
 */
public class Medium_Coding_103 {


    /**
     * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
     */

    /**
     * 反转链表
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean reverse = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> item = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                item.add(poll.val);
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
            }
            //反转链表
            if (reverse){
                Collections.reverse(item);
            }
            res.add(item);
            reverse = !reverse;
        }
        return res;
    }


    /**
     * 基于双端链表
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrderV2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isLeft = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            Deque<Integer> item = new ArrayDeque<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                //从左往右，每个元素加在链表的最后面，反之加载最前面
                if (isLeft){
                    item.addLast(poll.val);
                }else{
                    item.addFirst(poll.val);
                }
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
            }
            res.add(new ArrayList<>(item));
            isLeft = !isLeft;
        }
        return res;
    }
}
