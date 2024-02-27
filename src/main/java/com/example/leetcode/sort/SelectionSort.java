package com.example.leetcode.sort;

/**
 * @author kai·yang
 * @Date 2024/2/27 16:46
 *
 * 选择排序
 */
public class SelectionSort {


    public static void selectionSort(int[] arrays){
        if (arrays == null || arrays.length < 2){
            return;
        }
        int N = arrays.length;
        for (int i = 0; i < N; i++){
            int minValueIndex = i;
            //找到i之后最小的数下标和i进行交换
            for (int j = i + 1; j < N; j++){
                minValueIndex = arrays[j] < arrays[minValueIndex] ? j : minValueIndex;
            }
            swap(arrays, i, minValueIndex);
        }

    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {

    }

}
