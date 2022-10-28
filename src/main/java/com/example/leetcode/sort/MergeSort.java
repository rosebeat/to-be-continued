package com.example.leetcode.sort;


/**
 * @author kai·yang
 * @Date 2022/10/27 15:49
 * @Desc 归并排序
 */
public class MergeSort {

    public static int[] mergeArray(int[] array){
        int len = array.length;
        int[] temp = new int[len];
        mergeSort(array, 0, len - 1, temp);
        return array;
    }


    public static void mergeSort(int[] array, int left, int right, int[] temp){
        if (left == right){
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(array, left, mid, temp);
        mergeSort(array, mid + 1, right, temp);

        for (int i = left; i <= right; i++){
            temp[i] = array[i];
        }

        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++){
            if (i == mid + 1 ){
                array[k] = temp[j];
                j++;
            }else if (j == right + 1){
                array[k] = temp[i];
                i++;
            }else if (temp[i] <= temp[j]) {
                array[k] = temp[i];
                i++;
            }else{
                array[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {20, 92, 60, 50, 40, 30, 70, 80, 100, 90};
        for (int i : mergeArray(arr)){
            System.out.print(i + ",");
        }
    }


}
