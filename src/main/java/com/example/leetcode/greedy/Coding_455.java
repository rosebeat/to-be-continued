package com.example.leetcode.greedy;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author kai·yang
 * @Date 2023/5/5 15:16
 *
 * leetcode: 【455】分发饼干
 * level：easy
 */

public class Coding_455 {

    /**
     * 问题描述：
     *   假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
     *    对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并
     *   ]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足
     *
     *    示例 1:
     *
     *   输入: g = [1,2,3], s = [1,1]
     *   输出: 1
     *   解释:
     *   你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
     *   虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
     *   所以你应该输出1。
     *
     *    示例 2:
     *
     *   输入: g = [1,2], s = [1,2,3]
     *   输出: 2
     *   解释:
     *   你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
     *   你拥有的饼干数量和尺寸都足以让所有孩子满足。
     *   所以你应该输出2.
     *
     *
     *    提示：
     *
     *    1 <= g.length <= 3 * 104
     *    0 <= s.length <= 3 * 104
     *    1 <= g[i], s[j] <= 231 - 1
     *
     *    Related Topics 贪心 数组 双指针 排序
     *
     *
     * 思路：
     *   能够是最多的孩子获得饼干，在满足 s[j] >= g[i] 情况下取最小的一个饼干
     *
     */

    public static int findContentChildren(int[] g, int[] s) {
        //针对孩子和饼干进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int sIndex = 0;
        //小孩
        for (int i = 0; i < g.length; i++){
            //饼干
            for (; sIndex < s.length; sIndex++){
                if (g[i] <= s[sIndex]){
                    result++;
                    sIndex++;
                    break;
                }
            }
            //如果当前所有饼干不满足条件，则直接返回结果
            if (result <= i){
                return result;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.println(findContentChildren(g, s));
    }



}
