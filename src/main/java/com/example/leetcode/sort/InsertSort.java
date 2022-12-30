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

}
