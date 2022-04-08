package com.example.leetcode.greedy;

/**
 * @author kai·yang
 * @Date 2022/4/8 10:47
 */
public class Coding_33 {

    public static int storewater(int[] bucket, int[] vat){
        if (bucket == null || vat == null){
            return 0;
        }
        //最少需要次数
        int time = 0;
        for (int i = 0; i < bucket.length; i++){
            //当前水缸所需的操作次数
            int itemTime = 0;
            //水桶增加容量，所需的操作次数
            int  after =  vat[i] == 0 ? 0 : (int)Math.ceil((double)vat[i] / (bucket[i] + 1)) + 1;
            //没有增加水桶容量的操作，所需要的次数
            //如果水桶容量为0，则使用after
            int  before = bucket[i] == 0 ? after : (int)Math.ceil((double)vat[i] / (bucket[i]));
            //同一水缸取最小值
            itemTime = Math.min(after, before);
            System.out.println(itemTime);
            //不同水缸取最大操作次数
            time = Math.max(time, itemTime);
        }
        return time;
    }


    public static void main(String[] args) {
        int[] a = {2,27,24,75};
        int[] b = {53,52,28,82};
        System.out.println(storeWaterThree(a, b));
    }


    public static int storeWaterTwo(int[] bucket, int[] vat) {
        int maxVat = 0;
        for(int v : vat) {maxVat = Math.max(v, maxVat);}
        if (maxVat == 0) {
            return 0;
        }
        //最大容量为0，代表不需蓄水，直接返回0
        int ans = 10001;
        //枚举倒水次数1-10000
        for (int pour = 1; pour <= 10000; pour++) {
            if (pour >= ans) {break;}
            int upgrade = 0;
            for (int i = 0; i < vat.length; i++) { //枚举每个水桶，计算总升级次数
                int cur = (int)Math.ceil((double)vat[i] / pour - bucket[i]); //容量/倒水次数-初始蓄水量=升级次数
                upgrade += cur > 0 ? cur : 0;
                if (upgrade >= ans) {break;}
            }
            ans = Math.min(ans, upgrade + pour); //倒水次数 + 总升级次数 = 总次数
        }
        return ans;
    }


    public static int storeWaterThree(int[] bucket, int[] vat) {
        // 由于 0 <= bucket[i], vat[i] <= 10^4
        // 所以倒水次数最多由容量为 1 的桶，倒满容量为 10000 的缸，共 10000 次
        int n = bucket.length;
        // 当前总次数
        int curTotal;
        // 最少总次数
        int minTotal = Integer.MAX_VALUE;
        // 枚举倒水次数
        for (int pour = 1; pour <= 10000; pour++) {
            curTotal = pour;
            if (curTotal >= minTotal) {
                // 剪枝
                break;
            }
            //      (水桶升级次数 + 水桶容量) * 倒水次数 >= 水缸容量
            // 得到 水桶升级次数 >= (水缸容量 / 倒水次数) - 水桶容量
            // 即   水桶升级次数 = Math.ceil(水缸容量 / 倒水次数) - 水桶容量
            // 同时 水桶升级次数 >= 0
            // 则   水桶升级次数 = Math.max(Math.ceil(水缸容量 / 倒水次数) - 水桶容量, 0)
            for (int i = 0; i < n; i++) {
                curTotal += Math.max(Math.ceil(vat[i] * 1.0 / pour) - bucket[i], 0);
                if (curTotal >= minTotal) {
                    // 剪枝
                    break;
                }
            }
            minTotal = Math.min(minTotal, curTotal);
        }
        return minTotal;
    }
}
