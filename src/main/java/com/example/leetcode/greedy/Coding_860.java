package com.example.leetcode.greedy;

/**
 * @author kai·yang
 * @Date 2023/6/2 10:56
 *
 * leetcode: 【860】 柠檬水找零
 *
 * level: easy
 *
 */
public class Coding_860 {


    /**
     * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
     *  每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
     *  注意，一开始你手头没有任何零钱。
     *  给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
     *
     *  示例 1：
     *
     * 输入：bills = [5,5,5,10,20]
     * 输出：true
     * 解释：
     * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
     * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
     * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
     * 由于所有客户都得到了正确的找零，所以我们输出 true。
     *
     *  示例 2：
     *
     * 输入：bills = [5,5,10,10,20]
     * 输出：false
     * 解释：
     * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
     * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
     * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
     * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
     *
     *
     *  提示：
     *
     *  1 <= bills.length <= 105
     *  bills[i] 不是 5 就是 10 或是 20
     *
     *  Related Topics 贪心 数组
     */

    /**
     * 解决思路一致，优化V1
     * @param bills
     * @return
     */
    public static boolean lemonadeChangeV2(int[] bills) {
        //5块钱数量
        int fiveNum = 0;
        //10块钱数量
        int tenNum = 0;
        for (int i = 0; i < bills.length; i++){
            switch(bills[i]){
                //如果是5 fiveNum 加一
                case 5 :
                    fiveNum++;
                    break;
                //如果是10  fiveNum减一, tenNum加一，在最后统一判断fiveNum个数是否越界
                case 10 :
                    fiveNum--;
                    tenNum++;
                    break;
                //如果是20  找零方式有两种 5 10  和  5 5 5
                //如果有10 优先用10找零，如果5块数量足够的话，找零不是问题
                case 20:
                    if (tenNum > 0){
                        tenNum--;
                        fiveNum--;
                    }else{
                        fiveNum -= 3;
                    }

            }
            //判断5块数量是否越界（ 数量小于0，出现负数）
            if ( fiveNum < 0 ){
                return false;
            }

        }
        return true;
    }



    public boolean lemonadeChangeV1(int[] bills) {
        if (bills == null ){
            return true;
        }
        //手中总金额
        int sum = 0;
        //5块钱数量
        int fiveNum = 0;
        //10块钱数量
        int tenNum = 0;
        for (int i = 0; i < bills.length; i++){
            switch(bills[i]){
                // 5块 不用找零，fiveNum加一，总金额加5
                case 5 :
                    sum += 5;
                    fiveNum++;
                    break;
                //10块  需要找零5，判断总金额和fiveNum数量
                //此处可以不用判断总金额，直接判断fiveNum数量即可
                case 10 :
                    if ( sum >= 5 && fiveNum > 0){
                        sum += 5;
                        fiveNum--;
                        tenNum++;
                        break;
                    }
                    return false;
                //20块  有两种找零方式 5 10  和  5 5 5
                //如果有10 优先用10找零，如果5块数量足够的话，找零不是问题
                case 20:
                    if ( fiveNum >=3 || (fiveNum > 0 && tenNum > 0)){
                        sum += 5;
                        if (tenNum > 0){
                            tenNum--;
                            fiveNum--;
                        }else{
                            fiveNum -= 3;
                        }
                        break;
                    }
                    return false;
            }
        }
        return true;
    }





    public static void main(String[] args) {
        int[] arr = {5,5,5,5,20,20,5,5,20,5};
        int[] arr1 = {5,5,5,10,5,20,5,10,5,20};
        int[] arr2 = {5,5,5,10,5,5,10,20,20,20};
        System.out.println(lemonadeChangeV2(arr2));
    }


}
