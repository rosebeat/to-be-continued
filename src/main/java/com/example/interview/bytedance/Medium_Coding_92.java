package com.example.interview.bytedance;

import com.example.util.ListNode;

/**
 * @Ahthor k·Young
 * @Date 2024/10/30 14:04
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【92】反转链表II
 * Difficulty: medium
 * Tag: 链表
 */
public class Medium_Coding_92 {


    /**
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表
     */

    /**
     * 找到left的前一个节点，便于断开连接 和 与新的子链表连接
     * 找到right的next节点，便于断开连接 和 与新的子链表尾部连接
     *
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode( -1, head);
        //需要反转的子链表的前一个节点
        ListNode slow = dummy;
        //需要反转的子链表尾节点
        ListNode fast = dummy;
        while( (right > 0) || (left) > 0){
            if (--left > 0){
                slow = slow.next;
            }
            if (right-- > 0){
                fast = fast.next;
            }
        }
        //反转之后的子链表尾部需要指向next节点
        ListNode next = fast.next;
        //断开与next的连接，便于反转
        fast.next = null;
        //需要反转的子链表的头节点
        ListNode  reverseHead = slow.next;
        //断开与需要反转部分的连接
        slow.next = null;
        //反转链表
        ListNode newReverseHead = reverseListNode(reverseHead);
        //前一个节点指向新链表的头节点
        slow.next = newReverseHead;
        //原来的头节点反转后变为尾节点，指向next
        reverseHead.next = next;
        return dummy.next;
    }


    /**
     * 反转链表
     * @param head
     * @return 返回新链表的头节点
     */
    public static ListNode reverseListNode(ListNode head){
        ListNode curNode = head;
        ListNode finish = null;
        while (curNode != null) {
            ListNode next = curNode.next;
            curNode.next = finish;
            finish = curNode;
            curNode = next;
        }
        return finish;
    }


    public static void main(String[] args) {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        reverseBetween(one, 2,4);
    }
}
