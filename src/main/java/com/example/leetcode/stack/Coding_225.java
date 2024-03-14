package com.example.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: kai·yang
 * @Date: 2024/3/14 14:32
 * @Description:
 *
 *
 * leetcode: 【225】用队列实现栈
 * level：easy
 */
public class Coding_225 {


    /**
     * 实时保持 inQueue 为空，新元素加在 inQueue 中
     *
     * push操作时，如果 outQueue 不为空，讲元素依次加到 inQueue中，把 outQueue 指向 inQueue ，inQueue置为空
     *
     *
     */
    class MyStack {
        Queue<Integer> inQueue;
        Queue<Integer> outQueue;

        public MyStack() {
            inQueue = new LinkedList<>();
            outQueue = new LinkedList<>();
        }

        public void push(int x) {
            inQueue.offer(x);
            while (!outQueue.isEmpty()){
                inQueue.offer(outQueue.poll());
            }
            Queue<Integer> temp = inQueue;
            inQueue = outQueue;
            outQueue = temp;
        }

        public int pop() {
            return outQueue.poll();
        }

        public int top() {
           return outQueue.peek();
        }

        public boolean empty() {
            return inQueue.isEmpty() && outQueue.isEmpty();
        }
    }

}
