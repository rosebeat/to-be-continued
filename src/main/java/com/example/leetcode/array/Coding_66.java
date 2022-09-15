package com.example.leetcode.array;

import java.util.Arrays;

/**
 * @author kai·yang
 * @Date 2022/8/25 10:16
 *
 * subject：加一【66】
 * level：easy
 */
public class Coding_66 {

    /**
     * 题干：给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     *      最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *      你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     *       示例 1：
     *
     *      输入：digits = [1,2,3]
     *      输出：[1,2,4]
     *      解释：输入数组表示数字 123。
     *
     * 分析：digits[] 加一时,需要关注末尾有多少个连续的 ‘9’。
     *
     *  part 1：末尾没有9，直接加一即可
     *
     *  part 2：末尾有若干个 9，例如 [1, 2, 3, 9, 9]，那么我们只需要找出从末尾开始的第一个不为 9 的元素，即 3，将该元素加一，得到 [1, 2, 4, 9, 9]。随后将末尾的 9 全部置零，得到 [1, 2, 4, 0, 0] 并返回
     *
     *  part 3：都是9，例如 [9, 9, 9, 9, 9]，那么答案为 [1, 0, 0, 0, 0, 0]。我们只需要构造一个长度比 digits[] 多 1 的新数组，将首元素置为 1，其余元素置为 0 即可。
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int lenght = digits.length;
        for(int i = lenght - 1; i >= 0; i-- ){
            digits[i] = (digits[i] + 1) % 10;

            if (digits[i] % 10 > 0){
                return digits;
            }
        }
        // 都是 9 的情况
        int [] newDigits = new int[lenght + 1];
        newDigits[0] = 1;

        return newDigits;
    }
}
