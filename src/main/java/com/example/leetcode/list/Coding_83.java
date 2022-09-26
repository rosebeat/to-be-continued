package com.example.leetcode.list;

import com.example.leetcode.list.source.ListNode;

/**
 * @author kai·yang
 * @Date 2022/9/26 14:50
 */
public class Coding_83 {



    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while(head != null){
            int val1 = head.val;
            ListNode next = head.next;
            if (next != null){
                int nextValue = next.val;
                if (val1 == nextValue){
                    ListNode nnext = next.next;
                    head.next = nnext;
                }else{
                    head = next;
                }
            }else{
                break;
            }
        }
        return node;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);

        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
        ListNode reuslt = deleteDuplicates(n1);
        System.out.println("==========================");
    }

}
