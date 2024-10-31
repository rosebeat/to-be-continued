package com.example.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Ahthor k·Young
 * @Date 2024/10/31 14:42
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【155】最小栈
 * Difficulty: medium
 *
 */
public class MinStack_155 {


    /**
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     *
     * 实现 MinStack 类:
     *
     * MinStack() 初始化堆栈对象。
     * void push(int val) 将元素val推入堆栈。
     * void pop() 删除堆栈顶部的元素。
     * int top() 获取堆栈顶部的元素。
     * int getMin() 获取堆栈中的最小元素。
     *
     *
     * 示例 1:
     *
     * 输入：
     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
     * [[],[-2],[0],[-3],[],[],[],[]]
     *
     * 输出：
     * [null,null,null,null,-3,null,0,-2]
     *
     * 解释：
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     *
     *
     * 提示：
     *
     * -231 <= val <= 231 - 1
     * pop、top 和 getMin 操作总是在 非空栈 上调用
     * push, pop, top, and getMin最多被调用 3 * 104 次
     */

    /**
     * 使用双向队列实现栈的操作
     */
    Stack<Integer> data;

    Stack<Integer> helper;

    public MinStack_155() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int val) {
        data.push(val);
        if (!helper.isEmpty()){
            if (helper.peek() >= val){
                helper.push(val);
            }
        }else{
            helper.push(val);
        }
    }

    public void pop() {
        if (!data.isEmpty()){
            int dPop = data.pop();
            if (dPop == helper.peek()){
                helper.pop();
            }
        }
    }

    public int top() {
        if (!data.isEmpty()){
            return data.peek();
        }
        throw new RuntimeException("Stack is empty");
    }

    public int getMin() {
        if (!data.isEmpty()){
            return helper.peek();
        }
        throw new RuntimeException("Stack is empty");
    }
}
