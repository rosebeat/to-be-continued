package com.example.leetcode.stack;


import java.util.Stack;

/**
 * @author: kai·yang
 * @Date: 2024/3/14 11:33
 * @Description:
 *
 *
 * leetcode: 【232】用栈实现队列
 * level：easy
 */
public class Coding_232 {



    class MyQueue {

        /**
         * push 操作
         */
        Stack<Integer> addStack;

        /**
         * pop  peek 操作
         */
        Stack<Integer> updateStack;

        public MyQueue() {
            addStack = new Stack<>();
            updateStack = new Stack<>();
        }

        public void push(int x) {
            addStack.push(x);
        }

        public int pop() {
            if (updateStack.isEmpty()) {
                while (!addStack.isEmpty()) {
                    updateStack.push(addStack.pop());
                }
            }
            return updateStack.pop();
        }

        public int peek() {
            if (updateStack.isEmpty()) {
                while (!addStack.isEmpty()) {
                    updateStack.push(addStack.pop());
                }
            }
            return updateStack.peek();
        }

        public boolean empty() {
            return addStack.isEmpty() && updateStack.isEmpty();
        }
    }

}
