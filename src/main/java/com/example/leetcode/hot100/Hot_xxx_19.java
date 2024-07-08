package com.example.leetcode.hot100;

import com.example.util.ListNode;

/**
 * @author: kai·yang
 * @Date: 2024/7/8 11:17
 * @Description:
 *
 * LeetCode: 【19】 删除链表的倒数第 N 个结点
 * Difficulty: medium
 * <link> https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_xxx_19 {


    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * 示例 2：
     *
     * 输入：head = [1], n = 1
     * 输出：[]
     * 示例 3：
     *
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     *
     *
     * 提示：
     *
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     *
     *
     * 进阶：你能尝试使用一趟扫描实现吗？
     */


    /**
     * 遍历
     *  1、第一次遍历计算出链表长度 L
     *  2、第二次遍历删除指定位置上的数据， L - n 就是要删除节点的前继节点
     *
     *  时间复杂度：O(n), 但是使用了两次遍历
     *  空间复杂度：O(1)
     *
     * @param head
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n){
        int l = 0;
        ListNode first = head;
        while(first != null){
            first = first.next;
            ++l;
        }
        //设置一个前置节点，删除倒数第 n 个节点，找到它的前继节点好操作
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        for (int i = 0; i < l - n; i++){
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;

    }


    /**
     * 双指针： 类似于固定窗口的思维
     *
     *  1、 first 指针先走 n 步
     *
     *  2、 second 指针 等first 走完 n 步，才能开始移动
     *
     *  3、当 first 指针指向 null （first走完了链表）时， second 指针指向的位置就是 要删除节点的 前继节点
     *
     *
     *
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndV2(ListNode head, int n){
        //设置一个前置节点，second 指针指向这个前继节点
        ListNode dummy = new ListNode(-1, head);
        ListNode first = head;
        ListNode second = dummy;
        while(first != null){
            first = first.next;


            //first 指针先走 n 步
            //之后first 和 second 同时移动
            //first指针指向null时，second 指针位置为要删除节点的前继节点
            if(n <= 0){
                second = second.next;
            }
            --n;
        }
        //second 指针位置为要删除节点的前继节点
        second.next = second.next.next;
        return dummy.next;
    }



}
