package com.example.leetcode.hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Ahthor k·Young
 * @Date 2024/10/23 9:41
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【46】全排序
 * Difficulty: medium
 * <link>https://leetcode.cn/problems/permutations/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 回溯法
 *
 * TODO  回溯这种题型要好好理解 回去再看看
 *
 */
public class Hot_xxx_46 {


    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     *
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     *
     * 输入：nums = [1]
     * 输出：[[1]]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * nums 中的所有整数 互不相同
     *
     */

    /**
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
        }
        backtrack(res, temp, nums.length, 0);
        return res;
    }

    /**
     *
     * @param res 结果集
     * @param output 每一种情况
     * @param n 数组长度
     * @param begin 要替换的位置
     */
    public void backtrack(List<List<Integer>> res, ArrayList<Integer> output, int n, int begin){
        //所有位置的数都已经填完了
        if (begin == n){
            //new ArrayList<>(output) 拷贝一个新数组，原数组改动不影响新数组
            res.add(new ArrayList<>(output));
        }
        for (int i = begin; i < n; i++){
            //交换位置
            Collections.swap(output, begin, i);
            //递归填写下一个数
            backtrack(res, output, n, begin + 1);
            //回溯，将上面交换的元素复原
            Collections.swap(output, begin, i);
        }
    }

}
