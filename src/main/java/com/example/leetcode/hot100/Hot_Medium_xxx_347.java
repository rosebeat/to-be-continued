package com.example.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Ahthor k·Young
 * @Date 2024/11/6 10:50
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【347】前K个高频元素
 *
 */
public class Hot_Medium_xxx_347 {


    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 示例 2:
     *
     * 输入: nums = [1], k = 1
     * 输出: [1]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 105
     * k 的取值范围是 [1, 数组中不相同的元素的个数]
     * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
     *
     *
     * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
     */


    /**
     * 利用java自带的优先队列，其原理也是大根堆和小根堆的原理
     *
     * 或者根据 快排来解决
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {

        int[] res = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        //优先队列，大根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a) );
        for(Integer i: map.keySet()){
            pq.add(i);
        }
        for(int x = 0; x < k; x++){
            res[x] = pq.poll();
        }
        return res;
    }



}
