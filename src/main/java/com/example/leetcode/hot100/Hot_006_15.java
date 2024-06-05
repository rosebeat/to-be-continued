package com.example.leetcode.hot100;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.Arrays;
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
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     *
     * 你返回所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     *
     * 示例 1：
     *
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 解释：
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
     * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
     * 注意，输出的顺序和三元组的顺序并不重要。
     * 示例 2：
     *
     * 输入：nums = [0,1,1]
     * 输出：[]
     * 解释：唯一可能的三元组和不为 0 。
     * 示例 3：
     *
     * 输入：nums = [0,0,0]
     * 输出：[[0,0,0]]
     * 解释：唯一可能的三元组和为 0 。
     */



    /**
     * 解题思路： 排序 + 双指针
     *  暴力破解时间复杂度为 O(N*N*N), 采用双指针优化 无效解，提升效率
     *
     *
     *
     *
     *  1、先将 nums 排序，时间复杂度为 O(N*logN)
     *
     *
     *  2、使用3个指针， k为最左（最小）元素， 双指针 i j 分别在数组索引（k， length(nums)）两端
     *
     *  双指针 i，j 交替向中间移动，记录每个固定指针 k 满足 num[k] + num[i] + num[j] == 0 的 i，j 的组合
     *
     *    a). 当 num[k] > 0 时，直接跳出循环，因为 num[j] >= num[i] >= num[k] >= 0,即 三个元素都大于0，指针k之后都无法找到解
     *    b). 当 k > 0 时，如果  nums[k] == nums[ k - 1] 则跳过元素nums[k], 因为 已经将 nums[k - 1] 的所有组合加到结果中
     *        再次加入会出现重复
     *    c). i, j 分别设置到数组索引两端，如果  i < j 时循环计算 s = nums[k] + nums[i] + nums[j]
     *        按照以下三种情况移动指针
     *         当 s > 0 时，j向左移动，即 j = j - 1, 并且跳过 相邻重复的 nums[j]，防止记录重复组合
     *         当 s == 0 时， 将组合记录到结果中，  i 向右移动，即 i = i + 1， j向左移动 即 j= j - 1，  并且跳过相邻重复的元素,防止记录重复组合
     *         当 s < 0 时， i 向右移动，即 i = i + 1， 并且跳过相邻重复元素 nums[i]，防止记录重复组合
     *
     *
     *
     * 复杂度分析：
     * 时间复杂度 O(N*N)：其中固定指针 k 循环复杂度 O(N)，双指针 i，j 复杂度 O(N)
     * 空间复杂度 O(1)：指针使用常数大小的额外空间。
     *
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //将nums排序
        Arrays.sort(nums);
        // 固定指针K
        for (int k = 0; k < nums.length; k++){
            //数组升序排序之后，如果nums[k] 都大于0，那么后面就没有能够满足要求的结果，直接跳出
            if (nums[k] > 0){
                break;
            }
            // 相邻元素相等，直接跳过
            if (k > 0 && nums[k] == nums[k - 1]){
                continue;
            }
            // 左指针
            int i = k + 1;
            //右指针
            int j = nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0){
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[k]);
                    item.add(nums[i]);
                    item.add(nums[j]);
                    result.add(item);
                    // i 指针向右移动，直到找到和当前位置元素不想等的位置
                    while(i < j && nums[i] == nums[++i]);
                    // j 指针向左移动，直到找到和当前位置元素不相等的位置
                    while( i < j && nums[j] == nums[--j]);
                }else if ( sum > 0){
                    // 排序后 数组时递增的，只有数组尾指针 j 向左移动，才可能出现 s <= 0 的结果
                    // j 指针向左移动，直到找到和当前位置元素不相等的位置
                    while( i < j && nums[j] == nums[--j]);
                }else{
                    // 排序后 数组时递增的，只有数组头指针 i 向右移动，才可能出现 s >= 0 的结果
                    // i 指针向右移动，直到找到和当前位置元素不想等的位置
                    while(i < j && nums[i] == nums[++i]);
                }

            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(JSON.toJSONString(threeSum(nums)));
    }

}
