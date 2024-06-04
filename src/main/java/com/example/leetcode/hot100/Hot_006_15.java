package com.example.leetcode.hot100;

import java.util.List;

/**
 * @author: kai·yang
 * @Date: 2024/6/4 16:46
 * @Description:
 *
 * LeetCode: 【15】三数之和
 * Difficulty: medium
 * <link>https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class Hot_006_15 {


    /**
     * 解题思路： 排序 + 双指针
     *  1、先将 nums 排序，时间复杂度为 O(N*logN)
     *
     *
     *  2、使用3个指针， k为最左（最小）元素， 双指针 i j 分别在数组索引（k， length(nums)）两端
     *
     *  双指针 i，j 交替向中间移动，记录每个固定指针 k 满足 num[k] + num[i] + num[j] == 0 的 i，j 的组合
     *
     *    a). 当 num[k] > 0 时，直接跳出循环，因为 num[k] >= num[i] >= num[j] > 0,即 三个元素都大于0，指针k之后都无法找到解
     *    b).
     *
     *
     *
     *
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        return null;
    }

}
