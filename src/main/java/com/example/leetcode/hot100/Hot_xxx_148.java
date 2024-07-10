package com.example.leetcode.hot100;

import com.example.util.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: kai·yang
 * @Date: 2024/7/10 9:56
 * @Description:
 *
 *
 * LeetCode: 【148】 排序链表
 * Difficulty：medium
 * <link>https://leetcode.cn/problems/sort-list/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_xxx_148 {


    /**
     * 有点问题， leetcode 30测试用例通过 24
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head){
        List<ListNode> item = new ArrayList<>();
        while(head != null){
            item.add(head);
            head = head.next;
        }
        if (item.size() <= 0){
            return null;
        }
        Collections.sort(item, (x ,y) ->{
            return x.val < y.val ? -1 : 1;
        });
        for(int i = 0; i < item.size() - 1; i++){
            item.get(i).next = item.get(i + 1);
        }
        item.get(item.size() - 1).next = null;
        return item.get(0);
    }







    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        System.out.println(sortList(one));
    }

}
