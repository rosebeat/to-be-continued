package com.example.leetcode.string;

/**
 * @author kai·yang
 * @Date 2022/4/7 15:46
 */


import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 */
public class Coding_13 {

    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *  例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V +
     * II 。
     *  通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
     *  减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     *  I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     *  X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     *  C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * @param s
     * @return
     */


    /**
     * 方案一：暴力枚举
     * @param s
     * @return
     */
    public static int romaToIntOne(String s){
        Map<String, Integer> romaNum = new HashMap<>(16);
        romaNum.put("I",1);
        romaNum.put("V", 5);
        romaNum.put("X", 10);
        romaNum.put("L", 50);
        romaNum.put("C", 100);
        romaNum.put("D", 500);
        romaNum.put("M", 1000);
        romaNum.put("IV", 4);
        romaNum.put("IX", 9);
        romaNum.put("XL", 40);
        romaNum.put("XC", 90);
        romaNum.put("CD", 400);
        romaNum.put("CM", 900);
        int sum = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            String f = String.valueOf(chars[i]);

            String se = "####";
            if (i < chars.length - 1){
                se = String.valueOf(chars[i+1]);
            }
            if(romaNum.get(f+se) == null){
                sum += romaNum.get(f);
            }else{
                sum += romaNum.get(f+se);
                ++i;
            }
        }
        return sum;
    }


    /**
     * 方案二：
     * 根据题干可知：
     *  1、罗马数字由 I V X L C D M 组成
     *  2、小数在大数的左边则,大数减小数，如：IV= 5-1 =4;
     *  3、小数在大数的右边则,大数加小数，如：VI= 5+1 =6;
     *
     *  保留当前位的值，当遍历到下一位的时，对比保留值与遍历位的大小关系，再确定保留值为加还是减。最后一位做加法即可。
     * @param s
     * @return
     */
    public static int romaToIntTwo(String s){
        int sum = 0;
        for (int i =1; i < s.toCharArray().length; i++){
            int a = getInt(s.charAt(i - 1));
            int b = getInt(s.charAt(i));
            if (a < b ){
                sum -= a;
            }else {
                sum += a;
            }
        }
        sum += getInt(s.charAt(s.length() -1));
        return sum;
    }

    public static int getInt(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default : return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(romaToIntTwo("XXVII"));
    }

}
