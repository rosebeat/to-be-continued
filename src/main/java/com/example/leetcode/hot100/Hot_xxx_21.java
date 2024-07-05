package com.example.leetcode.hot100;

import com.example.util.ListNode;

/**
 * @author: kai·yang
 * @Date: 2024/7/5 17:28
 * @Description:
 *
 * LeetCode：【21】合并两个有序链表
 * Difficulty: easy
 * <link> https://leetcode.cn/problems/merge-two-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_xxx_21 {


    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * 示例 2：
     *
     * 输入：l1 = [], l2 = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     *
     *
     * 提示：
     *
     * 两个链表的节点数目范围是 [0, 50]
     * -100 <= Node.val <= 100
     * l1 和 l2 均按 非递减顺序 排列
     *
     *
     */

    /**
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null){
            return null;
        }
        ListNode a = list1;
        ListNode b = list2;
        ListNode newHead = new ListNode();
        ListNode current = newHead;
        while(a != null && b != null){
            if (a.val <= b.val){
                current.next = a;
                current = a;
                a = a.next;

            }else{
                current.next = b;
                current = b;
                b = b.next;
            }
        }
        if (a == null){
            current.next = b;
        }
        if (b == null){
            current.next = a;
        }
        return newHead.next;
    }

}
