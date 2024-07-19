package com.example.leetcode.hot100;

import com.example.util.TreeNode;

/**
 * @author: kai·yang
 * @Date: 2024/7/17 10:34
 * @Description:
 *
 * LeetCode：【108】将有序数组转换为平衡二叉搜索树
 * Difficulty：easy
 * <link>https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_xxx_108 {


    /**
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵
     * 平衡
     *  二叉搜索树。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：nums = [-10,-3,0,5,9]
     * 输出：[0,-3,9,-10,null,5]
     * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
     *
     * 示例 2：
     *
     *
     * 输入：nums = [1,3]
     * 输出：[3,1]
     * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 按 严格递增 顺序排列
     */

    /**
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums){
        return buildTree(nums,0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int left, int right){
        if (right < left){
            return null;
        }
        //因为是平衡搜索二叉树，root节点去中间位置的元素，计算root节点的位置
        int rootIndex = ((right - left) >> 1) + left;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = buildTree(nums, left, rootIndex - 1);
        root.right = buildTree(nums, rootIndex + 1, right);
        return root;
    }

}
