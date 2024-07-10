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
    public static ListNode reverseKGroup(ListNode head, int k) {
        int n = k - 1;
        //设置一个虚拟节点方便操作
        ListNode dummy = new ListNode(-1, head);
        //子链表的前继节点
        ListNode pre = dummy;
        //子链表的后继节点
        ListNode tail = head;
        while(tail != null){

            //如果 n 等于 0 说明改子链表需要反转
            if (n == 0){
                ListNode next = tail.next;
                //0 位置是头节点，1 位置是尾节点
                ListNode[] reverse = reverse(head, tail);
                //前继节点next指向反转后子链表头指针
                pre.next = reverse[0];
                //修改前继节点
                pre = reverse[1];
                //修改新子链表头指针
                head = next;
                //修改尾指针
                tail = next;
                n = k - 1;
                continue;
            }
            n--;
            tail = tail.next;

        }
        return dummy.next;
    }


    /**
     * 返回 反转后链表的头和尾
     * @param head
     * @param targetNode
     * @return
     */
    public static  ListNode[] reverse(ListNode head, ListNode targetNode){
        ListNode finish = targetNode.next;
        ListNode pre = head;
        while(finish != targetNode){
            ListNode next = pre.next;
            pre.next = finish;
            finish = pre;
            pre = next;
        }
        return new ListNode[]{targetNode, head};
    }


    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
//        one.next = two;
//        two.next = three;
//        three.next = four;
//        four.next = five;
        ListNode listNode = reverseKGroup(one, 1);

    }


}
