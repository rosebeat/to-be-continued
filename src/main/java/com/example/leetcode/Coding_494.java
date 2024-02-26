package com.example.leetcode;

import java.util.HashMap;

/**
 * @author kai·yang
 * @Date 2024/2/23 10:20
 *
 *
 * leetcode
 *  description: 【494】 目标和
 *  level：easy
 */
public class Coding_494 {

    public int findTargetSumWays(int[] nums, int target) {

        return process(nums, target, 0);
    }

    /**
     * 可以自由使用数组 nums[index ....] 之后的所有数据
     *
     * 搞出target这个数，方法个数，返回
     *
     * @param nums
     * @param target
     * @param index
     * @return
     */
    public int process(int[] nums, int target, int index ){
        //没有数了
        if(nums.length == index){
            //如果 target == 0 则是一种实现方式
            return target == 0 ? 1 : 0;
        }
        return process(nums, target - nums[index],index + 1) + process(nums, target + nums[index],index + 1);

    }


    /**
     * 记忆化搜索
     *
     * dp 缓存，外层key 下标(index); 内层key 目标值(target); value 对应有多少种实现方式
     *
     * @param nums 数组
     * @param target 目标值
     * @param index 下标
     * @#param dp 缓存
     * @return
     */
    public int processV2(int[] nums, int target, int index, HashMap<Integer, HashMap<Integer, Integer>> dp){
        if (dp.containsKey(index) && dp.get(index).containsKey(target)){
            return dp.get(index).get(target);
        }

        int count = 0;
        //没有数了
        if(nums.length == index){
            //如果 target == 0 则是一种实现方式
            count = target == 0 ? 1 : 0;
        }else {
            count = processV2(nums, target - nums[index], index + 1, dp) + processV2(nums, target + nums[index], index + 1, dp);
        }
        if (!dp.containsKey(index)){
            dp.put(index, new HashMap<>());
        }
        dp.get(index).put(target, count);
        return count;
    }
}
