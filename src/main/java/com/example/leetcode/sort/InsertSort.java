package com.example.leetcode.sort;

/**
 * @author kai·yang
 * @Date 2022/10/27 15:24
 * @Desc 插入排序
 */
public class InsertSort {

    /**
     * 插入排序
     * @param array
     * @return
     */
    public static int[] insertSort(int[] array){
        //已排好序部分 最后一个元素的下标
        int index;
        //待排序的元素
        int currentValue;
        for(int i = 0; i < array.length - 1; i++){
            index = i;
            currentValue = array[i+1];
            //把待排序的元素与前面已排号的部分逐个进行比较
            //如果待排序的元素小于排好序的某一个元素，那就把它向右（向后）移动一位，排好序的下标向左（向前）移动一位，即 index--
            //直到待排序的元素不小于已排好序的某一个元素，就将待排序的元素插入到这个元素后面
            while(index >= 0 && currentValue < array[index]){
                //待排序元素 小于当前值，当前值向后移动一位
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = currentValue;
        }
        return array;
    }


    /**
     * 插入排序第二种写法
     * @param arr
     */
    public static void insertSort2(int[] arr){
        int len = arr.length;
        for (int i = 1; i < len; i++){
            //待排序数据的位置
            int newIndex = i;
            while( newIndex - 1 >= 0 && arr[newIndex] < arr[newIndex - 1]){
                //待排序的位置比前一个小，则交换
                swap(arr, newIndex, newIndex - 1);
                newIndex--;
            }
        }

    }


    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr){
        for(int x : arr){
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4,5,3,6,9,1,0,8,2};
        print(arr);
        insertSort2(arr);
        print(arr);
    }


}
