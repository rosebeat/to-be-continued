package com.example.leetcode.list;

import com.example.leetcode.list.source.ListNode;

/**
 * @author kai·yang
 * @Date 2022/6/28 14:48
 *
 *
 * 题目：反转链表【206】 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class Coding_206 {

    /**
     * 递归反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        /*
         * 当head.next 为链表最后一位时，head为倒数第二个
         * 将最后一位的下一位指向倒数第二位（head），倒数第二位指向null
         * 此时最后一位与倒数第二位完成了反转，其他节点不变
         */
        ListNode cu = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cu;
    }
}
