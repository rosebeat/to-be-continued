package com.example.interview.bytedance;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Ahthor k·Young
 * @Date 2024/10/28 13:24
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【215】数组中的第K个最大元素
 * Difficulty: medium
 * <link> https://leetcode.cn/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=bytedance-2023-fall-sprint
 * Tag: 分治，排序，队列优先
 */
public class Medium_Coding_215 {


    /**
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     *
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
     *
     *
     *
     * 示例 1:
     *
     * 输入: [3,2,1,5,6,4], k = 2
     * 输出: 5
     * 示例 2:
     *
     * 输入: [3,2,3,1,2,4,5,5,6], k = 4
     * 输出: 4
     *
     *
     * 提示：
     *
     * 1 <= k <= nums.length <= 105
     * -104 <= nums[i] <= 104
     *
     *
     */

    /**
     * 巧妙的利用Java 中的优先队列 priorityQueue 大根堆，小根堆的思想
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        //小根堆
        //大根堆还是小根堆取决于后面的 comparator 算法
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparing( x -> x));
        for( int i = 0; i < k; i++){
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++){
            Integer peek = minHeap.peek();
            if (peek < nums[i]){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }

    /**
     * 快排
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestV2(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);

        return nums[nums.length - k];
    }

    public void quickSort(int[] nums, int left, int right){
        if (left >= right){
            return;
        }
        //返回等于选定值的区间下标
        int[] partition = partition(nums, left, nums.length - 1);
        //处理左区间
        quickSort(nums, left, partition[0] - 1);
        //处理右区间
        quickSort(nums, partition[1] + 1, right);
    }

    /**
     *
     * @param nums
     * @param L 左边界
     * @param R 有边界
     * @return 返回 目标值的区间
     */
    public int[] partition(int[] nums, int L, int R){
        //选定最右侧元素为目标进行分类
        int p = nums[R];
        //开始比较的元素位置
        int index = L;
        //小于p,区间的最右侧位置
        int lessR = L - 1;
        //大于p，区间的最左侧位置
        int moreL = R;

        while(index < R){
            if (nums[index] < p){
                //小于p区间，最右侧 + 1（也就是 lessR + 1）和 index位置交换，然后index向后移动一位
                swap(nums, ++lessR, index++);
            }else if( nums[index] > p){
                //大于p区间，最左侧 - 1（也就是 more - 1）和 index位置交换，index不动
                swap(nums, index, --moreL);
            }else{
                //等于p
                index++;
            }
        }
        //p 和大于p的区间 最左侧交换，将p放在一起
        swap(nums, R, moreL);
        //返回等于p的区间下标
        return new int[]{lessR + 1, moreL};
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



}
