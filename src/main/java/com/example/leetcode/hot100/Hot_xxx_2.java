package com.example.leetcode.hot100;

import com.example.util.ListNode;

/**
 * @author: kai·yang
 * @Date: 2024/7/5 17:51
 * @Description:
 *
 * LeetCode：【2】两数相加
 * Difficulty：medium
 * <link> https://leetcode.cn/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_xxx_2 {


    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * 示例 2：
     *
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * 示例 3：
     *
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     *
     *
     * 提示：
     *
     * 每个链表中的节点数在范围 [1, 100] 内
     * 0 <= Node.val <= 9
     * 题目数据保证列表表示的数字不含前导零
     */


    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //设置一个虚拟节点
        ListNode newHead = new ListNode(-1);
        ListNode current = newHead;
        //进位
        int c = 0;
        while(l1 != null && l2 != null){
            // (l1.val + l2.val + c) % 10 计算当前余数， C 表示后一位的 进位
            ListNode item = new ListNode((l1.val + l2.val + c) % 10);
            // 计算是否需要进位
            c = (l1.val + l2.val + c) / 10;
            current.next = item;
            current = item;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l2 != null){
            ListNode item = new ListNode((l2.val + c) % 10);
            c = (l2.val + c) / 10;
            current.next = item;
            current = item;
            l2 = l2.next;
        }

        while(l1 != null){
            ListNode item = new ListNode((l1.val + c) % 10);
            c = (l1.val + c) / 10;
            current.next = item;
            current = item;
            l1 = l1.next;
        }
        //最后还有进位 就需要新加个节点，新加的节点必然是 1
        current.next = c == 1 ? new ListNode(1) : null;
        return newHead.next;
    }

}
