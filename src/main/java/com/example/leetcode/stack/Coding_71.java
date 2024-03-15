package com.example.leetcode.stack;



import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author: kai·yang
 * @Date: 2024/3/15 10:38
 * @Description:
 *
 * leetcode: 【71】简化路径
 * level：easy
 * <link>https://leetcode.cn/problems/simplify-path/description/
 */
public class Coding_71 {



    public static String simplifyPath(String path) {
        if (path == null || path.equals("")){
            return path;
        }
        //leetcode  不支持 StringJoiner
        StringJoiner sj = new StringJoiner("/");
        Deque<String> d = new ArrayDeque<>();
        String[] split = path.split("/");
        for (String item : split){
            if (item != null && !item.equals("")){
                switch (item){
                    case ".": continue;
                    case "..":
                        if (!d.isEmpty()){
                            d.removeLast();
                        }
                        break;
                    default: d.offerLast(item);
                }
            }
        }
        while(!d.isEmpty()){
            sj.add(d.pollFirst());
        }
        return "/" + sj.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }
}
