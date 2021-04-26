package com.example.leetcode.dp;

public class Coding_1518 {


    /**
     * 1518:换酒问题
     * @param numBottles
     * @param numExchange
     * @return
     */
    public int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles <= 0 || numExchange < 0){
            return 0;
        }
        //当前持有的啤酒瓶数量
        int have = numBottles;
        //当前喝了几瓶啤酒
        int sum = numBottles;
        while (have >= numExchange){
            //当前持有的酒瓶可以兑换多少酒
            int temp = have/numExchange;
            //还剩几个酒瓶
            int remainder = have%numExchange;
            //当前持有的酒瓶数量 = 兑换的啤酒 + 剩余的酒瓶
            have = temp + remainder;
            sum += temp;
        }
        return sum;
    }


}
