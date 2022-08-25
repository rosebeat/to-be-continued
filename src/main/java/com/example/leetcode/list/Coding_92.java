package com.example.leetcode.list;

import com.example.leetcode.list.source.ListNode;

/**
 * @author kai·yang
 * @Date 2022/6/28 17:36
 *
 * subject: 反转链表II【92】
 * level: medium
 */
public class Coding_92 {


    /**
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
     * 表节点，返回 反转后的链表 。
     */


    /**
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {


        return head;
    }


    /**
     * 反转链表前 N 个
     * @param head
     * @param n
     * @return
     */
    ListNode temp = null;
    public ListNode reverseN(ListNode head, int n ){
        if (n == 1){
            temp = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = temp;
        return last;
    }

}
