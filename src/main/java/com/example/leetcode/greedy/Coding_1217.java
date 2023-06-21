package com.example.leetcode.greedy;

/**
 * @author kai·yang
 * @Date 2023/6/21 14:34
 *
 * leetode: 【1217】 玩筹码
 * level：easy
 */
public class Coding_1217 {

    /**
     * 有 n 个筹码。第 i 个筹码的位置是 position[i] 。
     *  我们需要把所有筹码移到同一个位置。在一步中，我们可以将第 i 个筹码的位置从 position[i] 改变为:
     *
     *  position[i] + 2 或 position[i] - 2 ，此时 cost = 0
     *  position[i] + 1 或 position[i] - 1 ，此时 cost = 1
     *
     *  返回将所有筹码移动到同一位置上所需要的 最小代价 。
     *
     *  示例 1：
     *
     * 输入：position = [1,2,3]
     * 输出：1
     * 解释：第一步:将位置3的筹码移动到位置1，成本为0。
     * 第二步:将位置2的筹码移动到位置1，成本= 1。
     * 总成本是1。
     *
     *  示例 2：
     *
     * 输入：position = [2,2,2,3,3]
     * 输出：2
     * 解释：我们可以把位置3的两个筹码移到位置2。每一步的成本为1。总成本= 2。
     *
     *  示例 3:
     *
     * 输入：position = [1,1000000000]
     * 输出：1
     *
     *  提示：
     *
     *  1 <= position.length <= 100
     *  1 <= position[i] <= 10^9
     *
     *  Related Topics 贪心 数组 数学
     */


    /**
     * 思路：
     *  1、把一个偶数位置上的筹码 Pi  移动到 另个一 偶数位置上 Pj,  Pi < Pj  则一定存在  Pi + 2x = Pj , x>=0 ,所用花销为 0
     *  2、把一个奇数位置上的筹码 Pi  移动到 另个一 奇数位置上 Pj,  Pi < Pj  则一定存在  Pi + 2x = Pj , x>=0 ,所用花销为 0
     *  3、把偶数（奇数）位置上的筹码Pi 移动到奇数（偶数）位置上Pj   Pi < Pj  则一定存在  Pi + 2x + 1 = Pj, x >=0,所用花销为 1
     *  筹码移动分两种情况：
     *     1. 都移动到 偶数位置上，此时所需的花费为 初始位置是奇数的筹码个数
     *     2. 都移动到 奇数位置上，此时所需的花费为 初始位置是偶数的筹码个数
     *
     * @param position
     * @return
     */
    public static int minCostToMoveChips(int[] position) {
        int even = 0;
        int odd = 0;
        for (int x : position){
            if (x % 2 == 0){
                even++;
            }else{
                odd++;
            }
        }
        return even < odd ? even : odd;
    }

    public static void main(String[] args) {
        int[] position = {2,2,2,3,3};
        System.out.println(minCostToMoveChips(position));
    }
}
