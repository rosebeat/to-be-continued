package com.example.leetcode.hot100;

import com.example.util.ListNode;

/**
 * @author: kai·yang
 * @Date: 2024/7/3 17:59
 * @Description:
 *
 * LeetCode：【160】相交链表
 * Difficulty：medium
 * <link> https://leetcode.cn/problems/intersection-of-two-linked-lists/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class Hot_xxx_160 {


    public ListNode getIntersectionNode(ListNode nodeA, ListNode nodeB){
        //这里不用判空是因为，如果有个链表为空在while中有处理
        ListNode a = nodeA;
        ListNode b = nodeB;
        while(a != b){
            a = a == null ? nodeB : a.next;
            b = b == null ? nodeA : b.next;
        }
        return a;
    }

}
