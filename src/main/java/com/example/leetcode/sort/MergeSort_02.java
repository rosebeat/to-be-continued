package com.example.leetcode.sort;

import java.util.Arrays;

/**
 * @author kai·yang
 * @Date 2022/10/28 14:19
 *
 * 归并排序
 */
public class MergeSort_02 {


    public static int[] sort(int[] array){
        if (array.length <= 1){
            return array;
        }
        int mid = array.length / 2;
        //copyOfRange() 左闭右开
        int[] left  = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return mergeArray(sort(left), sort(right));
    }


    /**
     *
     * @param left 已排好序左边
     * @param right 已排好序右边
     * @return
     */
    public static int[] mergeArray(int[] left, int[] right){

        int[] result = new int[left.length + right.length];
        for (int i = 0,leftIndex = 0,rightIndex = 0; i < result.length; i ++){
            //当 left 数组数据都已经排序进结果集中后，取右边的数组 right
            if (leftIndex >= left.length){
                result[i] = right[rightIndex];
                rightIndex++;
            }else if (rightIndex >= right.length){
                // 当right 中的数组数据都已经排序进结果集中后， 取左边的数组 left
                result[i] = left[leftIndex];
                leftIndex++;
            }else if (left[leftIndex] > right[rightIndex]){
                // 左边的数据大于右边的数据 升序排序取最小值
                result[i] = right[rightIndex++];
            }else{
                // 左边的数据小于右边的数据 升序排序取最小值
                result[i] = left[leftIndex++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {20, 92, 60, 50, 40, 30, 70, 80, 100, 90};
        for (int i : sort(arr)){
            System.out.print(i + ",");
        }
    }

}
