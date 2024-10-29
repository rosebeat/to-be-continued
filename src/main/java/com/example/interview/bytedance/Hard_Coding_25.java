package com.example.interview.bytedance;

import com.example.util.ListNode;

/**
 * @Ahthor k·Young
 * @Date 2024/10/29 14:10
 * @Version 1.0
 * @Desc
 *
 * LeeCode: 【25】K个一组反转链表
 * Difficulty: hard
 * Tag: 递归，链表
 */
public class Hard_Coding_25 {


    /**
     * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     */



    /**
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode preGroup = dummy;
        while(true){
            ListNode start = preGroup.next;
            //获取每一组的结束节点
            ListNode end = start;
            for(int i = 0; i < k - 1 && end != null; i++){
                end = end.next;
            }
            //剩余的几点不够K个，不翻转
            if (end == null){
                break;
            }
            //记录下一组的头节点
            ListNode nextStart = end.next;
            //断开与下一组的连接
            end.next = null;
            //当前组反转之后的头节点
            ListNode newStart = reverseNode(start);
            preGroup.next = newStart;
            //反转前的头节点，变为尾节点， 更新下一组的前缀节点
            preGroup = start;
            start.next = nextStart;
        }
        return dummy.next;
    }


    /**
     * 反转链表，返回新链表头节点
     * @param head
     * @return
     */
    public ListNode reverseNode( ListNode head ){
        //待反转节点
        ListNode cur = head;
        //反转完成的节点
        ListNode finish = null;
        while(cur != null){
            //抓取下一个节点
            ListNode next = cur.next;
            //待反转的节点指向反转完成的节点
            cur.next = finish;
            //更新完成节点
            finish = cur;
            //更新待反转节点
            cur = next;
        }
        return finish;
    }


}
