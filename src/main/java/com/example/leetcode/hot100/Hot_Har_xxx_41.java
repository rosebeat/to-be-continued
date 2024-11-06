package com.example.leetcode.hot100;


/**
 * @Ahthor k·Young
 * @Date 2024/11/6 11:07
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【41】缺失的第一个正数
 * Difficulty: hard
 * <link> https://leetcode.cn/problems/first-missing-positive/description/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class Hot_Har_xxx_41 {


    /**
     * 原地哈希法：
     * 1、由于题目要求我们「只能使用常数级别的空间」，而要找的数一定在 [1, N + 1] 左闭右闭（这里 N 是数组的长度）这个区间里。因此，
     *    我们可以就把原始的数组当做哈希表来使用。事实上，哈希表其实本身也是一个数组；
     *
     * 2、我们要找的数就在 [1, N + 1] 里，最后 N + 1 这个元素我们不用找。因为在前面的 N 个元素都找不到的情况下，我们才返回 N + 1；
     *
     * 3、那么，我们可以采取这样的思路：就把 1 这个数放到下标为 0 的位置， 2 这个数放到下标为 1 的位置，按照这种思路整理一遍数组。
     *    然后我们再遍历一次数组，第 1 个遇到的它的值不等于下标的那个数，就是我们要找的缺失的第一个正数。

     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int min = 1;
        int n = nums.length;
        //
        for (int i = 0; i < n; i++){
            //如果nums[i] 元素 没有在 nums[i] - 1 的位置上则交换，直到 元素i 在位置 i- 1处，或者越界
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                swap(nums, nums[i] - 1, i);
            }
        }
        for(int i = 0; i< n; i++){
            if (nums[i] != (i +1)){
                return i + 1;
            }
        }
        //如果都满足返回 数组长度 + 1
        return n + 1;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
