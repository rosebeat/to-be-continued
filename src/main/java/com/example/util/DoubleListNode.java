package com.example.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kai·yang
 * @Date 2023/3/16 15:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoubleListNode {

    private int value;

    private DoubleListNode pre;

    private DoubleListNode next;

    public DoubleListNode(int value){
        this.value = value;
        this.pre = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return "DoubleListNode{" +
                "value=" + value +
                ", pre=" + (pre == null ? null : pre.getValue()) +
                ", next=" + next +
                '}';
    }
}
