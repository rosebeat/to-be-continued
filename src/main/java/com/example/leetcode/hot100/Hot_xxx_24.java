package com.example.leetcode.hot100;

import com.example.util.ListNode;

/**
 * @author: kai·yang
 * @Date: 2024/7/8 16:53
 * @Description:
 *
 * LeetCode: 【24】两两交换链表中的位置
 *
 */
public class Hot_xxx_24 {


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
     *
     * 从前向后交换，采用遍历的方式
     *
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head){
        //设置一个虚机节点
        ListNode dummy = new ListNode(-1, head);
        //表示当前已经交换完成部分的最后一个节点
        ListNode current = dummy;
        //交换对中第一个节点
        ListNode first = null;
        //交换对中第二个节点
        ListNode second = null;
        while(current.next != null && current.next.next != null){

            first = current.next;
            second = current.next.next;
            //第一个节点 next 指向 second 的next
            first.next = second.next;
            //交换完成部分最后一个节点next 指向second
            current.next = second;
            //交换对中第二个节点next 指向 first
            second.next = first;
            //设置交换完成部分的最后一个节点
            current = first;
        }

        return dummy.next;
    }


    /**
     * 采用递归的方式从后向前交换
     *
     *
     *
     * @param head
     * @return
     */
    public ListNode swapPairsV2(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        //当前节点的下一个节点
        ListNode next = head.next;
        //递归调用，从链表尾部开始交换， 返回叫完成的第一个节点
        ListNode nnext = swapPairsV2(next.next);
        //head 为交换对中的第一个节点，next为第二个节点
        //将第一个节点的next 指向链表尾部已经交换完成部分的第一个节点
        head.next = nnext;
        //第二个节点的next 指向第一个节点
        next.next = head;
        //返回叫完成的第一个位置的节点
        return next;
    }



}
