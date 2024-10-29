package com.example.interview.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Ahthor k·Young
 * @Date 2024/10/29 13:06
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【15】三数之和
 * Difficulty: medium
 *
 * Tag: 数组，双指针，排序
 *
 */
public class Medium_Coding_15 {


    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
     * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
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
     *
     *
     * 提示：
     *
     * 3 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     */

    /**
     *
     * 排序 + 双指针
     *
     *
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //对数组进行排序（升序）
        Arrays.sort(nums);
        int len = nums.length;
        //固定第一层循环，一次轮询每个元素作为 固定元素，以此向后寻找满足条件的 第二个和第三个元素
        for( int f = 0; f < len; f++ ){

            //如果所有元素都大于0，直接退出
            if (f == 0 && nums[f] > 0){
                break;
            }
            //元素重复，直接跳过
            if (f > 0 && nums[f] == nums[f - 1]){
                continue;
            }
            //双指针寻找符合条件的第二第三个元素
            int left = f + 1;
            int right = len - 1;
            while( left < right){
                int sum = nums[f] + nums[left] + nums[right];
                //符合条件
                if (sum == 0){
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[f]);
                    item.add(nums[left]);
                    item.add(nums[right]);
                    //寻找左指针和当前元素不重复的下一个元素下标
                    while(left < right && nums[left] == nums[++left]);
                    //寻找右指针和当前元素不重复的限一个元素下标
                    while(left < right && nums[right] == nums[--right]);
                }
                else if (sum < 0){
                    //数组是单调递增的，如果元素之和小于0，只能移动左指针，不能移动右指针
                    //找到下一个和当前元素重复的下标
                    while(left < right && nums[left] == nums[++left]);
                }
                else{
                    //数组是单调递增的，如果元素之和大于0，只能移动右指针，不能移动左指针
                    //找到下一个和当前元素重复的下标
                    while(left < right && nums[right] == nums[--right]);
                }

            }
        }
        return res;
    }
}
