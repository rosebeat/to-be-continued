package com.example.leetcode.sort;


import java.util.Stack;

/**
 * @author kai·yang
 * @Date 2024/2/27 16:47
 *
 * 快排
 */
public class QuickSort {

    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        process(arr, 0, arr.length - 1);

    }

    /**
     * 递归版本
     * @param arr
     * @param L
     * @param R
     */
    public static void process(int[] arr, int L, int R){
        if (L >= R){
            return;
        }
        int[] equalsP =  partition(arr, L, R);
        //左区间
        process(arr, L,equalsP[0] - 1);
        //有区间
        process(arr, equalsP[1] + 1, R);

    }

    static class Job{
        int L;
        int R;
        public Job(int left, int right){
            L = left;
            R = right;
        }
    }

    /**
     * 迭代方式
     * @param arr
     */
    public static void process2(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        Stack<Job> stack = new Stack<>();
        stack.push(new Job(0, arr.length - 1));
        while(!stack.isEmpty()){
            Job pop = stack.pop();
            int[] equalE = partition(arr, pop.L, pop.R);
            //有小于区域
            if (equalE[0] > pop.L){
                stack.push(new Job(pop.L, equalE[0] - 1));
            }
            //有大于区域
            if (equalE[1] < pop.R){
                stack.push(new Job(equalE[1] + 1, pop.R));
            }
        }
    }




    /**
     * 选定一个数 P，小于P的放在左侧（不一定有序），大于P的放在右侧（不一定有序）
     *
     * @param arr 数组
     * @param L 开始位置
     * @param R 结束位置
     * @return
     */
    public static int[] partition(int[] arr, int L, int R){
        //选择最右侧为目标进行分类
        int p = arr[R];
        //开始时要移动元素位置,起始位置第一个元素
        int index = L;
        //左侧 小于P 的最右侧位置
        int lessR = L - 1;
        //右侧 大于P 的最左侧位置，
        int moreL = R;
        //左右边界重合则便利完成
        while (index < moreL) {
            //当前位置元素 小于P 左侧右边界 + 1（lessR + 1）位置 和当前位置交换，左侧有边界右移一位，index++
            if (arr[index] < p) {
                swap(arr, ++lessR, index++);
            }
            //当前位置元素 大于P 右侧左边界 - 1（moreL - 1）位置 和当前位置交换，右侧左边界左移一位，index不变
            else if (arr[index] > p) {
                 swap(arr, --moreL, index);
            }
            //当前位置元素 等于P index++
            else {
                index++;
            }
        }
        //目标值 和 右侧左边界 交换
        swap(arr, R, moreL);
        //返回 等于 P 的区间下标
        return  new int[]{lessR + 1, moreL};
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


    public static void main(String[] args){
        int[] arr = {4,5,2,7,9,5,6,0,1,5};
        //int[] partition = partition(arr, 0, arr.length - 1);
        //System.out.println(JSON.toJSONString(partition));
        print(arr);
        quickSort(arr);
        print(arr);
        System.out.println("迭代");
        int[] arr2 = {4,5,2,7,9,5,6,0,1,5};
        print(arr2);
        process2(arr2);
        print(arr2);
    }

}
