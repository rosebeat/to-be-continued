package com.example.interview.bytedance;

import java.util.Arrays;

/**
 * @Ahthor k·Young
 * @Date 2024/10/28 10:18
 * @Version 1.0
 * @Desc
 *
 * 字节算法汇总
 *
 * LeetCode: 【455】分发饼干
 * Difficulty: easy
 *
 */
public class Coding_455 {


    /**
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
     *
     * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，
     * 我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是满足尽可能多的孩子，并输出这个最大数值。
     *
     *
     * 示例 1:
     *
     * 输入: g = [1,2,3], s = [1,1]
     * 输出: 1
     * 解释:
     * 你有三个孩子和两块小饼干，3 个孩子的胃口值分别是：1,2,3。
     * 虽然你有两块小饼干，由于他们的尺寸都是 1，你只能让胃口值是 1 的孩子满足。
     * 所以你应该输出 1。
     * 示例 2:
     *
     * 输入: g = [1,2], s = [1,2,3]
     * 输出: 2
     * 解释:
     * 你有两个孩子和三块小饼干，2 个孩子的胃口值分别是 1,2。
     * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
     * 所以你应该输出 2。
     *
     *
     * 提示：
     *
     * 1 <= g.length <= 3 * 104
     * 0 <= s.length <= 3 * 104
     * 1 <= g[i], s[j] <= 231 - 1
     */

    /**
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        int i = 0;
        int j = 0;
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(i < g.length && j < s.length){
            //胃口小于饼干的大小，满足
            if(g[i] <= s[j]){
                count++;
                i++;
                j++;
            }else{
                //不满足，饼干先前移动
                //因为胃口和饼干大小已经升序排序，所以当前饼干不满足时，饼干要向后移动一位
                j++;
            }
        }
        return count;
    }
}
