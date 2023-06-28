package com.example.leetcode.list;

import com.example.leetcode.list.source.ListNode;

/**
 * @author kai·yang
 * @Date 2022/4/11 17:30
 *
 * leetcode；【203】移除链表元素
 * level： easy
 * <link> https://leetcode.cn/problems/remove-linked-list-elements/
 *
 */
public class Coding_203 {


    /**
     *给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所
     *
     *  示例 1：
     *
     * 输入：head = [1,2,6,3,4,5,6], val = 6
     * 输出：[1,2,3,4,5]
     *
     *  示例 2：
     *
     * 输入：head = [], val = 1
     * 输出：[]
     *
     *  示例 3：
     *
     * 输入：head = [7,7,7,7], val = 7
     * 输出：[]
     *
     *
     *  提示：
     *
     *  列表中的节点数目在范围 [0, 104] 内
     *  1 <= Node.val <= 50
     *  0 <= val <= 50
     *
     *  Related Topics 递归 链表
     */


    /**
     * 遍历链表
     * @param head
     * @return
     */
    public static ListNode removedElements(ListNode head, int val){
        if (head == null){
            return null;
        }
        //添加一个新头节点，处理头节点为目标值的情况
        ListNode newNode = new ListNode(-1000);
        newNode.next = head;
        //前一个节点
        ListNode preNode = newNode;
        while(preNode.next != null){
            if(preNode.next.val == val){
                preNode.next = preNode.next.next;
            }else{
                preNode = preNode.next;
            }
        }
        return newNode.next;
    }


    /**
     * 递归
     * @param head
     * @param val
     * @return
     */
    public static ListNode removedElementsTwo(ListNode head, int val){
        if (head == null){
            return head;
        }
        if(head.val == val){
            //如果等于目前值
            //当前节点的指针 指向下个节点
            head = removedElementsTwo(head.next, val);
        }else{
            //维持原状
            //当前节点的next指针，指向下个节点
            head.next = removedElementsTwo(head.next, val);
        }

       return head;
    }


    public static void main(String[] args) {
        //1,2,6,3,4,5,6
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.setNext(two);
        ListNode three = new ListNode(6);
        two.setNext(three);
        ListNode four = new ListNode(3);
        three.setNext(four);
        ListNode five = new ListNode(4);
        four.setNext(five);
        ListNode six = new ListNode(5);
        five.setNext(six);
        ListNode seven = new ListNode(6);
        six.setNext(seven);
        System.out.println(removedElements(one, 6));
        System.out.println(removedElementsTwo(one, 6));
    }
}
