package com.example.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Ahthor k·Young
 * @Date 2024/11/8 15:54
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【763】划分字母区间
 * Difficulty: medium
 * <link> https://leetcode.cn/problems/partition-labels/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 贪心
 */
public class Hot_Medium_xxx_763 {

    /**
     * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
     *
     * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
     *
     * 返回一个表示每个字符串片段的长度的列表。
     *
     *
     *
     * 示例 1：
     * 输入：s = "ababcbacadefegdehijhklij"
     * 输出：[9,7,8]
     * 解释：
     * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
     * 每个字母最多出现在一个片段中。
     * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
     * 示例 2：
     *
     * 输入：s = "eccbbbbdec"
     * 输出：[10]
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 500
     * s 仅由小写英文字母组成
     */

    /**
     *
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        //s中每个字符最后出现的位置
        int[] lastPos = new int[26];
        for (int i = 0; i< s.length(); i++){
            lastPos[s.charAt(i) - 'a'] = i;
        }
        //片段开始位置
        int start = 0;
        //片段结束位置
        int end = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            //当前字符最后出现的位置
            end = Math.max(end, lastPos[s.charAt(i) - 'a']);
            //i == end 说明start 到 end 间所有出现的字符都在这个片段中
            if (i== end){
                res.add(end - start + 1);
                //更新 新的片段开始位置
                start = end + 1;
                end = end + 1;
            }
        }
        return res;
    }
}
