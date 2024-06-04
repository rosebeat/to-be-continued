package com.example.leetcode.hot100;

import com.alibaba.fastjson2.JSON;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: kai·yang
 * @Date: 2024/6/4 15:17
 * @Description:
 *
 * LeetCode: 【49】字母异位词分组
 * Difficulty: medium
 * <link>https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_002_49 {

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     *
     * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
     *
     *
     *
     * 示例 1:
     *
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 示例 2:
     *
     * 输入: strs = [""]
     * 输出: [[""]]
     * 示例 3:
     *
     * 输入: strs = ["a"]
     * 输出: [["a"]]
     *
     *
     * 提示：
     *
     * 1 <= strs.length <= 104
     * 0 <= strs[i].length <= 100
     * strs[i] 仅包含小写字母
     */



    /**
     * 排序：
     *      字母相同，当时排列顺序不一致， 那么对字符串排序得到的结果是一致的
     *
     *      所以对每个字符串进行排序，通过哈希表存储
     *
     *
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mapping = new HashMap<>();
        for (String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key  = new String(chars);
            List<String> item = mapping.get(key) == null ? new ArrayList<>() : mapping.get(key);
            item.add(s);
            mapping.put(key, item);
        }

        return new ArrayList<List<String>>(mapping.values());
    }



    public static List<List<String>> groupAnagrams2(String[] args){

        Map<String, List<String>> collect = Arrays.stream(args).collect(Collectors.groupingBy(s -> {
            //返回s排序后的结果
            //按排序后的结果进行 group by
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }));


        return new ArrayList<>(collect.values());
    }

    public static void main(String[] args) {
        String[] group = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(JSON.toJSONString(groupAnagrams2(group)));
    }

}
