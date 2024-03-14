package com.example.leetcode.sort;

/**
 * @author: kai·yang
 * @Date: 2024/3/14 17:26
 * @Description:
 */
public class BinarySearch {


    /**
     * 二分查找法， 有序数组中是否存在 等于target 这个数
     * @param sortedArr 递增有序数组
     * @param target 目标值
     * @return
     */
    public boolean find(int[] sortedArr, int target){
        if (sortedArr == null || sortedArr.length == 0){
            return false;
        }
        //左边界
        int L = 0;
        int R = sortedArr.length - 1;
        while(L <= R){
            int mid = (R - L) + L;
            //相等，找到了
            if (target == sortedArr[mid]){
                return true;
            }else if (target < sortedArr[mid]){
                //比中间值小，右边界 指向 mid - 1的位置
                R = mid - 1;
            }else{
                //比中间值大，左边界 指向 mid + 1 的位置
                L = mid + 1;
            }
        }
        //找不到返回false
        return false;
    }


    /**
     * arr 有序且递增， 找到 大于等于 num 最左侧边界下标，没有返回 -1
     * @param sortedArr
     * @param num
     * @return
     */
    public int mostLeftNoLessNumIndex(int[] sortedArr, int num){
        if (sortedArr == null || sortedArr.length == 0){
            return -1;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int index = -1;
        while( L <= R){
            int midIndex = (R - L) + L;
            //当前位置 >= num，右边界指向 midIndex - 1
            if (sortedArr[midIndex] >= num){
                index = midIndex;
                R = midIndex - 1;
            }else{
                L = midIndex + 1;
            }
        }
        return index;
    }








}
