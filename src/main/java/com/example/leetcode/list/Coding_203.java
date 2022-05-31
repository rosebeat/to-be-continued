package com.example.leetcode.list;

import com.example.leetcode.list.source.ListNode;

/**
 * @author kai·yang
 * @Date 2022/4/11 17:30
 *
 * 题目；移除链表元素【203】
 * 难度： easy
 *
 */
public class Coding_203 {


    /**
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     *
     * 例：
     *  输入：head = [1,2,6,3,4,5,6], val = 6
     *  输出：[1,2,3,4,5]
     */


    /**
     * 遍历链表
     * @param node
     * @return
     */
    public ListNode removedElements(ListNode node, int val){
        ListNode newNode = new ListNode();
        ListNode preNode = newNode;
        while(node != null){
            if(node.val == val){
                preNode.next = node.next;
                preNode = node.next;
            }
            node = node.next;
        }
        return newNode.next;
    }


    /**
     * 递归
     * @param node
     * @param val
     * @return
     */
    public ListNode removedElementsTwo(ListNode node, int val){
        if (node == null){
            return node;
        }
        if(node.val == val){
            node = removedElementsTwo(node.next, val);
        }else{
            node.next = removedElementsTwo(node.next, val);
        }

       return node;
    }
}
