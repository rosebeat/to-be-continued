package com.example.leetcode.hot100;

import com.example.util.ListNode;

/**
 * @author: kai·yang
 * @Date: 2024/7/4 16:58
 * @Description:
 *
 * LeetCode: 【206】反转链表
 * Difficulty：easy
 * <link> https://leetcode.cn/problems/reverse-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class Hot_xxx_206 {


    /**
     * 遍历版本 实现反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        ListNode root = head;
        //已经反转完成的节点
        ListNode finish = null;
        while(root != null){
            //抓一下 下一个节点
            ListNode next = root.next;
            root.next = finish;
            finish = root;
            root = next;
        }
        return finish;
    }


    /**
     * 递归版本
     * @param head
     * @return
     */
    public ListNode reverseListRecursion(ListNode head){
        // 跳出条件
        if (head == null || head.next == null){
            return head;
        }
        //抓一下当前节点的下一个节点
        ListNode next = head.next;
        //递归就是把新的根节点找到
        ListNode root = reverseListRecursion(head.next);
        //将next节点指向当前节点
        next.next = head;
        //当前节点指向null
        head.next = null;
        return root;
    }

}
