package com.example.leetcode.list.source;

import lombok.NoArgsConstructor;

/**
 * @author kai·yang
 * @Date 2023/7/4 16:46
 */
@NoArgsConstructor
public class RandomNode {

    public int val;

    /**
     * 指向下一个节点
     */
    public RandomNode next;

    /**
     * 随机指针，该指针可以指向链表中的任何节点或空节点
     */
    public RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}
