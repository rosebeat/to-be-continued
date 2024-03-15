package com.example.leetcode.greedy;

import java.util.Arrays;

/**
 * @author: kai·yang
 * @Date: 2024/3/15 15:25
 * @Description:
 *
 * leetcode: 【2578】最小和分割
 * level：easy
 * <link>https://leetcode.cn/problems/split-with-minimum-sum/description/
 */
public class Coding_2578 {


    /**
     *
     * @param num
     * @return
     */
    public int splitNum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        Arrays.sort(chars);
        int A = 0;
        int B = 0;
        for (int i = 0; i < chars.length; i++){
            if (i % 2 == 0){
                // A * 10 因为要在尾部加个数，所以整体 * 10 ，再加上要补的数
                // chars[i] - '0' 表示是数字几， 例如： '1' - '0' = 1
                A = A * 10 + (chars[i] - '0');
            }else{
                B = B * 10 + (chars[i] - '0');
            }
        }
        return A + B;
    }
}
