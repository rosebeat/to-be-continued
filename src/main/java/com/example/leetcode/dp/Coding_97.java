package com.example.leetcode.dp;

public class Coding_97 {


    /**
     * leetCode 97题：交错字符串
     *
     */

    public boolean isInterleave(String s1, String s2, String s3) {
        int s1len = s1.length();
        int s2len = s2.length();
        int s3len = s3.length();
        if (s1len + s2len != s3len){
            return false;
        }
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        char[] ch3 = s3.toCharArray();
        boolean[][] db = new boolean[s1len +1][s2len +1];

        if (ch1[0] == ch3[0]){
            db[0][1] = true;
        }
        if (ch2[0] == ch3[0]){
            db[1][0] = true;
        }
        for (int i = 1; i <= s1len; i++ ){
            for (int j = 1; j <= s2len; j++){
                if (ch1[i] == ch3[i] && db[i-1][j] || ch2[i] == ch3[i] && db[i][j-1]){

                }else{

                }
            }
        }




        return false;
    }
}
