package com.example.interview.bytedance;

/**
 * @Ahthor k·Young
 * @Date 2024/10/30 13:10
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【31】下一个排列
 * Difficulty: medium
 * Tag: 双指针
 */
public class Medium_Coding_31 {


    /**
     * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
     *
     * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
     * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
     *
     * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
     * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
     * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
     * 给你一个整数数组 nums ，找出 nums 的下一个排列。
     *
     * 必须 原地 修改，只允许使用额外常数空间。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[1,3,2]
     * 示例 2：
     *
     * 输入：nums = [3,2,1]
     * 输出：[1,2,3]
     * 示例 3：
     *
     * 输入：nums = [1,1,5]
     * 输出：[1,5,1]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 100
     */


    /**
     * 算法推导
     * 如何得到这样的排列顺序？这是本文的重点。我们可以这样来分析：
     *
     * 1、我们希望下一个数 比当前数大，这样才满足 “下一个排列” 的定义。因此只需要 将后面的「大数」与前面的「小数」交换，就能得到一个更大的数。
     *    比如 123456，将 5 和 6 交换就能得到一个更大的数 123465。
     * 2、我们还希望下一个数 增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需要：
     *      a.在 尽可能靠右的低位 进行交换，需要 从后向前 查找
     *      b.将一个 尽可能小的「大数」 与前面的「小数」交换。比如 123465，下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换
     *      c.将「大数」换到前面后，需要将「大数」后面的所有数 重置为升序，升序排列就是最小的排列。以 123465 为例：首先按照上一步，交换 5 和 4，
     *      得到 123564；然后需要将 5 之后的数重置为升序，得到 123546。显然 123546 比 123564 更小，123546 就是 123465 的下一个排列
     *
     *
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if(nums ==null || nums.length < 2){
            return;
        }
        int len = nums.length;
        int left = len - 2;
        int right = len - 1;
        while( left >=0 ){
            //从后向前找第一个降序 相邻元素
            if(nums[left] < nums[right]){
                right = len - 1;
                //找到left下标之后的 第一个比left小的位置
                while(right > left && nums[left] >= nums[right]){
                    right--;
                }
                swap(nums, left, right);
                descend(nums, left + 1, len - 1);
                return;
            }else{
                left--;
                right--;
            }
        }
        //走到这里说明数组是降序，已经是最大的了，直接降序排列
        descend(nums, 0, len - 1);
    }

    /**
     *
     * @param nums
     * @param targetIndex
     * @return
     */
    public int findFirstMax(int[] nums, int targetIndex){
        int minMax = Integer.MAX_VALUE;
        int index = -1;
        for (int i = nums.length - 1; i > targetIndex; i--){
            if(nums[i] > nums[targetIndex]){
                index = nums[i] <= minMax ? i : index;
                minMax = Math.min(nums[i], minMax);
            }
        }
        return index;
    }


    public void descend(int[] nums, int begin, int end){
        while (begin < end){
            swap(nums, begin++, end--);
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
