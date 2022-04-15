package com.example.leetcode.string;

/**
 * @author kai·yang
 * @Date 2022/4/8 15:53
 */
public class Coding_14 {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     *  如果不存在公共前缀，返回空字符串 ""。
     * @param strs
     * @return
     */

    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if (strs == null) {
            return prefix;
        }
        if (strs.length ==1){
            return strs[0];
        }
        //以其中一个为基准拆分，判断其余的是否以该字串开头
        String first = strs[0];
        for (int n = 1; n < first.toCharArray().length; n++){
            String subFirst = first.substring(0, n);
            boolean flag = true;
            for (int i = 1; i < strs.length; i++){
                if (!strs[i].startsWith(subFirst)){
                    flag = false;
                }
            }
            if (flag){
                prefix = subFirst;
            }
        }
        return prefix;
    }


}
