package com.example.leetcode.list;

import com.example.leetcode.list.source.ListNode;

/**
 * @author kai·yang
 * @Date 2023/6/29 10:57
 *
 * leetcode: 【24】两两交换链表中的节点
 * level：medium
 * <link> https://leetcode.cn/problems/swap-nodes-in-pairs/
 */
public class Coding_24 {


    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     *
     *  示例 1：
     *
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     *
     *  示例 2：
     *
     * 输入：head = []
     * 输出：[]
     *
     *  示例 3：
     *
     * 输入：head = [1]
     * 输出：[1]
     *
     *
     *  提示：
     *
     *  链表中节点的数目在范围 [0, 100] 内
     *  0 <= Node.val <= 100
     *
     *  Related Topics 递归 链表
     */


    /**
     * 从前向后交换
     * 遍历实现
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        //设置一个虚拟节点，表示已经已经交换完成部分的最后一个节点
        ListNode pre = new ListNode(-1, head);
        //当前已经完成交换部分的最后一个节点
        ListNode current = pre;
        //两个节点中 第一个节点
        ListNode first = null;
        //两个节点中 第二个节点
        ListNode second = null;
        while( current.next != null && current.next.next != null){
            first = current.next;
            second = current.next.next;
            //交换对中 第一个节点next指向第二个节点next
            first.next = second.next;
            //当前已经完成交换的链表的最后一个节点的next指向 交换对中第二个节点
            current.next = second;
            //交换对中第二个节点next指向第一个节点
            second.next = first;
            //设置已完成交换的链表的最后一个节点
            current = first;
        }
        return pre.next;
    }


    /**
     * 从后向前交换
     * 递归
     * @param head
     * @return
     */
    public static ListNode swapPairsV2(ListNode head) {

        // base case 退出提交
        if(head == null || head.next == null) return head;
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        // 进行递归
        //从链表尾部开始交换，返回交换完成部分的第一个节点
        ListNode newNode = swapPairsV2(next.next);
        // head 是交换对中的第一个节点，next是第二个节点
        //将第二个节点的next指向第一个节点
        next.next = head;
        //将第一个节点的next 指向链表尾部已经交换完成部分的第一个节点
        head.next = newNode;
        return next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.setNext(two);
        ListNode three = new ListNode(3);
        two.setNext(three);
        ListNode four = new ListNode(4);
        three.setNext(four);
        //System.out.println(swapPairs(one));
        System.out.println(swapPairsV2(one));

    }

}
