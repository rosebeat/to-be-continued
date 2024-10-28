package com.example.leetcode.hot100;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Ahthor k·Young
 * @Date 2024/10/25 9:49
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【22】括号生成
 * Difficulty: medium
 * <link>https://leetcode.cn/problems/generate-parentheses/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 回溯法
 */
public class Hot_xxx_22 {

    /**
     *数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     *
     * 输入：n = 1
     * 输出：["()"]
     *
     *
     * 提示：
     *
     * 1 <= n <= 8
     */


    /**
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0) {
            return res;
        }
        StringBuilder item = new StringBuilder();
        backtrack(res, item, 0, 0, n);
        return res;
    }


    /**
     *
     * 回溯，深度优先
     * 思路： 一个位置上 选择 '(' 还是 ')' 取决于 当前已经使用的 '('的数量，
     *      1、如果已经使用 '(' 数量大于 ')' 数量，则当前位置可以同时使用 '(' 或者 ')'
     *      2、如果已经使用 '(' 数量等于 ')' 数量，则当前位置只能使用 '('
     *      3、如果已经使用 '(' 数量小于 ')' 数量，组合是**错误的**
     *   综上，要使用 ')' 括号的条件是，'('使用数量必须大于 ')'
     *
     *
     * @param res 结果集
     * @param item 每一种组合
     * @param left 左括号已使用数量
     * @param right 右括号已使用数量
     * @param max 最大值
     */
    public void backtrack(List<String> res, StringBuilder item, int left, int right, int max){
        //长度相等后加入结果集
        if (item.length() == 2 * max){
            res.add(item.toString());
            return;
        }
        //不能超过最个数
        if (left < max){
            item.append("(");
            backtrack(res, item, left + 1, right, max);
            //回溯，删除前面添加的括号
            item.deleteCharAt(item.length() - 1);
        }
        //左括号已经使用的数量必须大于右括号的数量，当前位置才可以使用右括号
        if(right < left){
            item.append(")");
            backtrack(res, item, left, right + 1, max);
            //回溯，删除前面添加的括号
            item.deleteCharAt(item.length() - 1);
        }
    }


    /**
     * 使用队列，广度优先
     *
     * 将queue换位Stack，就是深度优先
     * @param n
     * @return
     */
    public List<String> generateParenthesisV2(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0) {
            return res;
        }
        Queue<CNode> queue = new LinkedList<>();
        CNode root = new CNode(0, 0, new StringBuilder());
        queue.add(root);
        while(!queue.isEmpty()){
            CNode poll = queue.poll();
            if (poll.item.length() == 2 * n){
                res.add(poll.item.toString());
            }
            if (poll.left < n){
                queue.add(new CNode(poll.left + 1, poll.right, new StringBuilder(poll.item.toString()).append("(")));
            }
            if (poll.left > poll.right){
                queue.add(new CNode(poll.left, poll.right + 1, new StringBuilder(poll.item.toString()).append(")")));
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Hot_xxx_22 x = new Hot_xxx_22();
        System.out.println(JSON.toJSONString(x.generateParenthesisV2(2)));
    }



}


class CNode{

    int left;

    int right;

    StringBuilder item;

    public CNode(int left, int right, StringBuilder item){
        this.left = left;
        this.right = right;
        this.item = item;
    }
}
