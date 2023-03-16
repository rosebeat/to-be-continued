package com.example.leetcode.list;

import com.example.leetcode.list.source.DoubleListNode;

/**
 * @author kai·yang
 * @Date 2023/3/16 15:26
 *
 * 反转双链表
 *
 */
public class ReverseDoubleList {


    /**
     * 方式一： 循环实现
     * @param head
     * @return
     */
    public static DoubleListNode reverse(DoubleListNode head){
        //已经反转完成的节点
        DoubleListNode finish = null;
        //下一个要反转的节点
        DoubleListNode next = null;
        while(head != null){
            next = head.getNext();
            head.setPre(next);
            head.setNext(finish);
            finish = head;
            head = next;
        }

        return finish;
    }


    /**
     * 方式二： 递归
     * @param head
     * @return
     */
    public DoubleListNode reverseV2(DoubleListNode head){

        return null;
    }


    public static void main(String[] args) {
        DoubleListNode six = new DoubleListNode(6);
        DoubleListNode five = new DoubleListNode(5);
        DoubleListNode four = new DoubleListNode(4);
        DoubleListNode three = new DoubleListNode(3);
        DoubleListNode two = new DoubleListNode(2);
        DoubleListNode root = new DoubleListNode(1);
        root.setNext(two);
        two.setNext(three);two.setPre(root);
        three.setNext(four);three.setPre(two);
        four.setNext(five);four.setPre(three);
        five.setNext(six);five.setPre(four);
        System.out.println(root.toString());
        DoubleListNode reverse = reverse(root);
        System.out.println(reverse.toString());
    }

}
