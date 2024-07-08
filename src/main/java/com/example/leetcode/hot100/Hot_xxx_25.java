package com.example.leetcode.hot100;

import com.example.util.ListNode;

/**
 * @author: kai·yang
 * @Date: 2024/7/8 17:29
 * @Description:
 *
 *
 * LeetCode: 【25】K 个一组翻转链表
 * Difficulty：hard
 * <link> https://leetcode.cn/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class Hot_xxx_25 {


    /**
     * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[2,1,4,3,5]
     * 示例 2：
     *
     *
     *
     * 输入：head = [1,2,3,4,5], k = 3
     * 输出：[3,2,1,4,5]
     *
     *
     * 提示：
     * 链表中的节点数目为 n
     * 1 <= k <= n <= 5000
     * 0 <= Node.val <= 1000
     *
     *
     * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
     */


    /**
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = k - 1;
        ListNode  current = head;
        ListNode currentHead = head;
        ListNode pre = new ListNode(-1, head);
        ListNode newHead = null;
        boolean isHead = true;
        while(current != null){
            n--;
            current = current.next;
            if (n == 0){
                pre.next = reverse(currentHead, current);
                if (isHead){
                    newHead = pre.next;
                    isHead = false;
                }
                pre = currentHead;
                currentHead = current.next;
                n = k - 1;

            }


        }
        return newHead;
    }



    public ListNode reverse(ListNode head, ListNode targetNode){
        ListNode targetNodeNext = targetNode.next;
        ListNode finish = targetNodeNext;
        ListNode current = head;
        while(current != targetNodeNext){
            ListNode next = current.next;
            current.next = finish;
            finish = current;
            current = next;
        }
        return finish;
    }


}
