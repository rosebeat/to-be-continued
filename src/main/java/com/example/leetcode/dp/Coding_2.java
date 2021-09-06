package com.example.leetcode.dp;

import com.example.leetcode.dp.source.ListNode;

/**
 * @author kai·yang
 * @Date 2021/7/7 16:48
 */


/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 *  请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 *  你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *
 *  示例 1：
 *
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class Coding_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tail = null;
        ListNode head = null;
        int carry = 0;
        while (l1 != null || l2 != null){
            int value1 = l1 != null ? l1.val : 0;
            int value2 = l2 != null ? l2.val : 0;
            int value = (value1 + value2 + carry) % 10;
            carry = (value1 + value2 + carry) / 10;
            if (head == null){
                head = tail = new ListNode(value);

            }else{
                tail.next = new ListNode(value);
                tail = tail.next;
            }
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (carry != 0){
            tail.next = new ListNode(carry,null);
        }
        return head;
    }

}
