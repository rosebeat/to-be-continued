package com.example.interview.bytedance;

import com.alibaba.fastjson2.JSON;

/**
 * @Ahthor k·Young
 * @Date 2024/10/28 10:32
 * @Version 1.0
 * @Desc
 *
 * 字节面试算法汇总
 * LeetCode: 【344】反转字符串
 * Difficulty: easy
 *
 */
public class Coding_344 {



    /**
     *编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     *
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = ["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     * 示例 2：
     *
     * 输入：s = ["H","a","n","n","a","h"]
     * 输出：["h","a","n","n","a","H"]
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 105
     * s[i] 都是 ASCII 码表中的可打印字符
     * @param s
     */
    public void reverseString(char[] s) {
        int h = 0;
        int t = s.length - 1;
        while(h < t){
            swap(h++, t--, s);
        }
    }


    public void swap(int h, int t, char[] s){
        char temp = s[h];
        s[h] = s[t];
        s[t] = temp;
    }

    public static void main(String[] args) {
        Coding_344 c = new Coding_344();
        char[] s = {'h','e','l','l','o'};
        System.out.println("反转前：" + JSON.toJSONString(s));
        c.reverseString(s);
        System.out.println("反转后：" + JSON.toJSONString(s));
    }
}
