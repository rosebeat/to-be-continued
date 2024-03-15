package com.example.leetcode.greedy;

/**
 * @author: kai·yang
 * @Date: 2024/3/15 16:52
 * @Description:
 *
 * leetcode: 【2591】降钱分给最多的儿童
 * difficulty：easy
 * <link>https://leetcode.cn/problems/distribute-money-to-maximum-children/description/
 *
 */
public class Coding_2591 {


    /**
     * 给你一个整数 money ，表示你总共有的钱数（单位为美元）和另一个整数 children ，表示你要将钱分配给多少个儿童。
     *  你需要按照如下规则分配：
     *
     *  所有的钱都必须被分配。
     *  每个儿童至少获得 1 美元。
     *  没有人获得 4 美元。
     *
     *  请你按照上述规则分配金钱，并返回 最多 有多少个儿童获得 恰好 8 美元。如果没有任何分配方案，返回 -1 。
     *
     *  示例 1：
     *  输入：money = 20, children = 3
     * 输出：1
     * 解释：
     * 最多获得 8 美元的儿童数为 1 。一种分配方案为：
     * - 给第一个儿童分配 8 美元。
     * - 给第二个儿童分配 9 美元。
     * - 给第三个儿童分配 3 美元。
     * 没有分配方案能让获得 8 美元的儿童数超过 1 。
     *
     *  示例 2：
     *  输入：money = 16, children = 2
     * 输出：2
     * 解释：每个儿童都可以获得 8 美元。
     *
     *
     *  提示：
     *
     *  1 <= money <= 200
     *  2 <= children <= 30
     *
     *  Related Topics 贪心 数学
     *  👍 120 👎 0
     * @param money 总钱数
     * @param children 儿童数量
     * @return
     */
    public static int distMoney(int money, int children) {
        if (money < children){
            return -1;
        }
        //每人先给一块，确保每个人都有钱
        money -= children;
        //刚好分到8块钱，那么还差7块 --->> 能给几个人分7块钱
        int haveE = money / 7;
        // 人数 和 可以分7块钱的份数，取两者最小值
        int cnt = Math.min(haveE, children);
        //
        children -= cnt;
        money -= 7 * cnt;
        //此时 剩下的 money 在 [0 , 6]范围上, 剩下的 children 大于等于 0
        //如果剩 0 个人，且 money 大于 0，那么 cnt 减 1
        //如果剩 1 个人，且 money 等于 3，那么 cnt 减 1 (题目要求不能有人分到4块钱)
        //其他情况 把钱分给其他 孩子即可， cnt就是所能分配金额刚好是8美金的人数
        if( (children == 0 && money > 0) || (children == 1 && money == 3)){
            cnt--;
        }
        return cnt;
    }


    public static void main(String[] args) {
        System.out.println(distMoney(16, 2));
    }
}
