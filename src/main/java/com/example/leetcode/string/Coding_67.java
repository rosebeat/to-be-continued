package com.example.leetcode.string;


/**
 * @author kai·yang
 * @Date 2023/1/10 15:38
 *
 * leetcode
 * description: 【67】二进制求和
 * level：easy
 *
 */

public class Coding_67 {


    /**
     * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
     *
     * 输入：a = "1010", b = "1011"
     * 输出："10101"
     * @param a
     * @param bb
     * @return
     */

    public static String addBinary(String a, String bb) {
        int carry = 0;
        String sum = "";
        while ( ( null != a && !"".equals(a)) || ( null != bb && !"".equals(bb))){
            String aNum = "";
            String bNum = "";
            if ("".equals(a)){
                aNum = "0";
            }else{
                aNum = a.substring(a.length() - 1);
                a = a.substring(0, a.length() -1);
            }
            if ("".equals(bb)){
                bNum = "0";
            }else{
                bNum = bb.substring(bb.length() - 1);
                bb = bb.substring(0, bb.length() -1);
            }
            sum = "" + ( carry + Integer.valueOf(aNum) + Integer.valueOf(bNum)) % 2 + sum;
            carry = ( carry + Integer.valueOf(aNum) + Integer.valueOf(bNum)) / 2;
        }
        String result = carry == 0 ? "" + sum : "1" + sum;
        return result;
    }


    public static void main(String[] args) {
        System.out.println(addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
        System.out.println(addBinary(null, null));

    }
}
