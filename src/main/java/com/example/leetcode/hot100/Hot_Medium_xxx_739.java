package com.example.leetcode.hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Ahthor k·Young
 * @Date 2024/11/4 11:04
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【739】每日温度
 * Difficulty: medium
 * <link> https://leetcode.cn/problems/daily-temperatures/solutions/283196/mei-ri-wen-du-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked
 * Tag: 栈
 */
public class Hot_Medium_xxx_739 {


    /**
     * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
     * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
     *
     *
     *
     * 示例 1:
     *
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     * 示例 2:
     *
     * 输入: temperatures = [30,40,50,60]
     * 输出: [1,1,1,0]
     * 示例 3:
     *
     * 输入: temperatures = [30,60,90]
     * 输出: [1,1,0]
     *
     *
     * 提示：
     *
     * 1 <= temperatures.length <= 105
     * 30 <= temperatures[i] <= 100
     */

    /**
     * 从左往右 单调栈
     * 栈中存储的是 温度下标，且从 栈底 到 栈顶 温度是单调递减的，如果一个下标出现在单调栈中，说明没有找到比他更大的温度下标
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        //存储温度下标
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++){
            int temp = temperatures[i];
            //找了比栈顶大的温度下标
            while(!stack.isEmpty() && temp > temperatures[stack.peek()]){
                //弹出上一个较小的温度下标
                int preIndex = stack.pop();
                //设置值
                res[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return res;
    }

}
