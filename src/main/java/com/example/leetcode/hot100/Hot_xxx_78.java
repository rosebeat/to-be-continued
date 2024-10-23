package com.example.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Ahthor k·Young
 * @Date 2024/10/22 14:35
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【78】子集
 * Difficulty: medium
 * <link>https://leetcode.cn/problems/subsets/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_xxx_78 {


    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
     * 子集
     * （幂集）。
     *
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     *
     * 输入：nums = [0]
     * 输出：[[],[0]]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * nums 中的所有元素 互不相同
     */

    /**
     * 每一个元素选不选可以用一个二进制位 0/1 表示，1代表选中
     * 例：以三个元素集合为例[1,2,3]
     *    000 {}
     *    001 {1}
     *    010 {2}
     *    011 {1,2}
     *    100 {3}
     *    101 {1,3}
     *    110 {2,3}
     *    111 {1,2,3}
     * 二进制的最大上限为：2^n -1
     *  即 枚举 0 ~ 2^n -1 的数据
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        //枚举所有二进制
        for (int mask = 0; mask < (1 << len); mask++) {
            List<Integer> item = new ArrayList<>();
            for (int i = 0; i < len; i++){
                // 1 << i 集合中第几个元素
                // mask & (1 << i) 代表该元素是否被选中
                if ( (mask & (1 << i)) != 0){
                    item.add(nums[i]);
                }
            }
            res.add(item);
        }
        return res;
    }

}
