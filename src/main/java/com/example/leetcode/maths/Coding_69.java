package com.example.leetcode.maths;

/**
 * @author kai·yang
 * @Date 2023/1/11 16:14
 *
 * leetcode
 * description: 【69】x的平方根
 * level：easy
 * Related Topics: 数学 二分查找
 */
public class Coding_69 {


    /**
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     *
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     *
     * 输入：x = 8
     * 输出：2
     * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
     *
     * 0 <= x <= 231 - 1
     *
     * @param x
     * @return
     */


    /**
     * 二分查找法
     * @param x
     * @return
     */
    public static int mySqrt(long x) {
        int s = 0;
        int e = (int) ((x + 1) / 2);
        int lastNum = 0;
        //开始设置最高值为 x/2 ,因为值的平方根都会  <= (x+1)/2
        while(s < e){
            int mid = s + (e - s) / 2;
            //这里采用除法 防止溢出
            if (mid  <= x / mid){
                lastNum = mid;
                s = mid + 1;
            }else{
                e = mid;
            }
        }
        return lastNum;
    }

    /**
     * 方法二：
     *   牛顿迭代法
     * @param args
     */


    public static void main(String[] args) {
        //2147395599--46339
        //2147483647--46340
        //System.out.println(mySqrt(2147483647));
        System.out.println((int)Math.pow(2, 32) - 1 );
        System.out.println(Integer.toBinaryString((int)Math.pow(2, 32)) );
        System.out.println(Integer.parseInt("1111111111111111111111111111110", 2));
        System.out.println(Integer.toBinaryString((int)Math.pow(-2, 32)) );

    }


}
