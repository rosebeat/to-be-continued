package com.example.leetcode.greedy;

import java.util.Arrays;

/**
 * @author kai·yang
 * @Date 2023/6/25 15:32
 *
 * leetcode: 【1710】卡车上的最大单元数
 *
 * level：easy
 */
public class Coding_1710 {
    /**
     * 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOf
     * UnitsPerBoxi] ：
     *
     *  numberOfBoxesi 是类型 i 的箱子的数量。
     *  numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
     *
     *  整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
     *  返回卡车可以装载 单元 的 最大 总数。
     *
     *  示例 1：
     *
     * 输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
     * 输出：8
     * 解释：箱子的情况如下：
     * - 1 个第一类的箱子，里面含 3 个单元。
     * - 2 个第二类的箱子，每个里面含 2 个单元。
     * - 3 个第三类的箱子，每个里面含 1 个单元。
     * 可以选择第一类和第二类的所有箱子，以及第三类的一个箱子。
     * 单元总数 = (1 * 3) + (2 * 2) + (1 * 1) = 8
     *  示例 2：
     *
     * 输入：boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
     * 输出：91
     *
     *
     *  提示：
     *
     *  1 <= boxTypes.length <= 1000
     *  1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
     *  1 <= truckSize <= 106
     *
     *  Related Topics 贪心 数组 排序
     */


    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        //根据 numberOfUnitsPerBox 降序
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int maxSize = 0;
        for (int[] x : boxTypes) {
            if (truckSize > x[0]){
                maxSize += x[0] * x[1];
                truckSize -= x[0];
            }else{
                maxSize += truckSize * x[1];
                break;
            }
        }
        return maxSize;
    }


    public static void main(String[] args) {
        int[][] boxTypes = {{5,10},{2,5},{4,7},{3,9}};
        System.out.println(maximumUnits(boxTypes, 10));
    }

}
