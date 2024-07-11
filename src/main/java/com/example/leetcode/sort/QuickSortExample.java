package com.example.leetcode.sort;

/**
 * @author: kai·yang
 * @Date: 2024/7/10 17:43
 * @Description:
 */
public class QuickSortExample {


    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: ");
        printArray(arr);
    }

    // 快速排序函数
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi是分区操作返回的索引，arr[pi]的左边都比arr[pi]小，右边都比arr[pi]大
            int pi = partition(arr, low, high);

            // 分别对左子数组和右子数组进行递归排序
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // 这个函数负责找到分区的索引，即pivot的位置
    static int partition(int[] arr, int low, int high) {
        // 选择最后一个元素作为基准
        int pivot = arr[high];
        int i = (low - 1); // i是小于pivot的元素的索引

        for (int j = low; j < high; j++) {
            // 如果当前元素小于或等于pivot
            if (arr[j] <= pivot) {
                i++;

                // 交换arr[i]和arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 把pivot放到正确的位置上
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // 返回pivot的位置
        return i + 1;
    }

    // 打印数组的函数
    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
