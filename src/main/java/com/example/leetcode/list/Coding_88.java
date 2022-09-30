package com.example.leetcode.list;


/**
 * @author kai·yang
 * @Date 2022/9/27 15:21
 *
 * leetcode:
 *  description: 【88】合并两个有序数组
 *  level：easy
 */
public class Coding_88 {

    /**
     *
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     *  请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     *  注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并
     * 的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     *
     *  示例 1：
     *
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
     *
     */

    /**
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //数组1 有效元素下标
        int len1 = m - 1;
        //数据2 有效元素下标
        int len2 = n - 1;
        //
        int len = m + n - 1;
        while(len1 >= 0 && len2 >= 0){
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        //表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);

    }
}
