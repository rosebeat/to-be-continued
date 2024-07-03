package com.example.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: kai·yang
 * @Date: 2024/6/27 20:59
 * @Description:
 *
 * LeetCode: 【1】两数之和
 */
public class Hot_xxx_1 {


    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (mp.containsKey(target - nums[i])){
                return new int[]{mp.get(target - nums[i]), i};
            }
            mp.put(nums[i], i);
        }
        return new int[0];
    }

}


