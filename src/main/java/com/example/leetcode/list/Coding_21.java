package com.example.leetcode.list;

import com.example.leetcode.list.source.ListNode;

/**
 * @author kai·yang
 * @Date 2022/4/11 14:54
 *
 * time: 合并两个有序链表【21】
 * 难度： easy
 */
public class Coding_21 {


    /**
     * 方法一：
     * 遍历链表
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //记录头节点
        ListNode newList = new ListNode();
        //记录上一个节点
        ListNode preNode = newList;
        while(list1 != null && list2 != null){
            ListNode item = new ListNode();
            int value1 = list1.val;
            int value2 = list2.val;
            if (value1 > value2){
                item.val = value2;
                list2 = list2.next;
            }else{
                item.val = value1;
                list1 = list1.next;
            }
            preNode.next = item;
            preNode = item;
        }
        if (list1 == null){
            preNode.next = list2;
        }
        if (list2 == null){
            preNode.next = list1;
        }
        return newList.next;
    }


    /**
     * 方法二： 递归实现
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoListsTwo(ListNode list1, ListNode list2) {
        //终止条件
        if (list1 == null){
            return list2;
        }
        //终止条件
        if (list2 == null){
            return list1;
        }
        if (list1.val < list2.val){
            list1.next = mergeTwoListsTwo(list1.next, list2);
            return list1;
        }else {
            list2.next = mergeTwoListsTwo(list1, list2.next);
            return list2;
        }

    }
}
