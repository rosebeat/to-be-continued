package com.example.leetcode.hot100;

import com.example.util.ListNode;

/**
 * @author: kai·yang
 * @Date: 2024/7/4 20:16
 * @Description:
 *
 *
 * LeetCode: 【142】环线链表II
 * Difficulty：medium
 * <link> https://leetcode.cn/problems/linked-list-cycle-ii/description/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class Hot_xxx_142 {


    /**
     * 快慢指针
     *
     * 思路：
     *   快指针fast 每次走两步，慢指针slow每次走一步
     *
     *  分为两种情况讨论
     *   1. 链表无环
     *      fast 先为null，直接返回null
     *   2. 链表有环
     *      2.1. 记 环外部分 长度为 a， 环长度为 b
     *      2.2 当 fast 和 slow 在环上相遇时，fast肯定比slow多走 n个环长度
     *      2.3 记 slow走过的长度为s，则fast走过的长度为2s，
     *          fast = 2s = s + n*b， 其中 n*b 表示fast比slow多走的距离
     *          s = n*b
     *          slow指针走过的距离是 n*b,也就是走了 n 个环的长度
     *          链表的总长度为  a + b， 所以slow 再走 a 就能到达入口
     *
     *      2.4 所以当 fast 和 slow 相遇时，fast指针从投开始，一次走一步，当fast和slow 再次相遇，就是环形入口
     *
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head){
        //每次走两步
        ListNode fast = head;
        //每次走一步
        ListNode slow = head;
        while( fast != null)  {
            //fast为null 说明不存在环，直接跳出
            if (fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            //第一次相遇
            if (fast == slow){
                //fast 从头开始 一次走一步，直到 fast和slow再次相遇
                fast = head;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }

        return null;
    }


}
