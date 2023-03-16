package com.example.leetcode.list;

import com.example.leetcode.list.source.ListNode;

/**
 * @author kai·yang
 * @Date 2023/3/16 11:32
 *
 * 反转单链表
 *
 */

public class ReverseList {

    /**
     * 方式一： 采用while循环实现反转链表
     * 单链表 反转链表
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head){
        //已经完成反转的节点
        ListNode finish = null;
        //下次要反转的节点
        ListNode next = null;
        while(head != null){
            //每次抓取一下当前节点的next
            next = head.next;
            head.next = finish;
            finish = head;
            head = next;
        }
        return finish;
    }

    /**
     * 方法二： 递归实现 单链表反转
     * @param head
     * @return
     */
    public static ListNode reverseV2(ListNode head){
        if ( head.next == null){
            return head;
        }
        //每次抓取一下当前节点的next，真正的用于反转链表
        ListNode next = head.next;
        //递归记录最后一个节点
        ListNode itemNode = reverseV2(head.next);
        //将next 的next 指向前一个节点(next = head.next)
        next.next = head;
        //将当前节点指向 null 此时 next 节点已经完成了反转
        head.next = null;
        //每次将最后一个节点返回
        return itemNode;
    }



    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        root.setNext(two);
        two.setNext(three);
        three.setNext(four);
        four.setNext(five);
        five.setNext(six);
        ListNode reverse = reverse(root);
        System.out.println(reverse.toString());
        System.out.println("---------");
        System.out.println(reverseV2(reverse).toString());
    }


}
