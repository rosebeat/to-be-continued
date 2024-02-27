package com.example.leetcode.sort;

/**
 * @author kai·yang
 * @Date 2024/2/27 16:48
 *
 * 冒泡排序
 */
public class BubbleSort {



    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        int end = arr.length;
        //外层循环控制次数，和已经排好序的位置,
        for (int i = end - 1; i >=0; i--){
            for( int second = 1; second <= end; second++){
                //最大值在后面
                if (arr[second - 1] > arr[second]){
                    swap(arr, second - 1, second);
                }
            }
        }

    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){

    }

}
