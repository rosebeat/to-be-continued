package com.example.leetcode.backtracking;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kai·yang
 * @Date 2023/7/28 15:13
 *
 * leetcode: 【216】组合总和III
 * level：medium
 * <link> https://leetcode.cn/problems/combination-sum-iii/solutions/409198/zu-he-zong-he-iii-by-leetcode-solution/
 */
public class Coding_216 {

    /**
     * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
     *
     *  只使用数字1到9
     *  每个数字 最多使用一次
     *
     *  返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
     *
     *  示例 1:
     *
     * 输入: k = 3, n = 7
     * 输出: [[1,2,4]]
     * 解释:
     * 1 + 2 + 4 = 7
     * 没有其他符合的组合了。
     *  示例 2:
     *
     * 输入: k = 3, n = 9
     * 输出: [[1,2,6], [1,3,5], [2,3,4]]
     * 解释:
     * 1 + 2 + 6 = 9
     * 1 + 3 + 5 = 9
     * 2 + 3 + 4 = 9
     * 没有其他符合的组合了。
     *  示例 3:
     *
     * 输入: k = 4, n = 1
     * 输出: []
     * 解释: 不存在有效的组合。
     * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
     *
     *
     *  提示:
     *
     *  2 <= k <= 9
     *  1 <= n <= 60
     *
     *  Related Topics 数组 回溯
     */

    /**
     * 递归实现组合型枚举
     *
     * 从 n 个当中选 k 个的所有方案对应的枚举是组合型枚举。
     * @param k
     * @param n
     * @return
     */
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(1, 9, k, n, result, temp);
        return result;
    }


    /**
     *
     * @param cur 当前值
     * @param n 最大值
     * @param k 集合大小
     * @param sum 集合总和
     * @param result 结果集
     * @param temp 已被选中得数字
     */
    public static void dfs(int cur, int n, int k, int sum, List<List<Integer>> result ,List<Integer> temp){
        //减枝操作 temp.size() + (n - cur + 1) < k
        //如果当前选中的个数 + 没有选中的个数 小于 k， 即使未选中的全部选中也无法构造出一个长度为 k 的序列
        if (temp.size() + (n - cur + 1) < k || temp.size() > k){
            return;
        }
        if (temp.size() == k){
            int curSum = 0;
            for (int x : temp){
                curSum += x;
            }
            if (curSum == sum){
                result.add(new ArrayList<>(temp));
                return;
            }
        }
        //选中当前位置
        temp.add(cur);
        dfs(cur + 1, n, k, sum, result, temp);
        //不选中当前位置
        temp.remove(temp.size() - 1);
        dfs(cur + 1, n, k, sum, result, temp);
    }


    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum3(3, 7);
        System.out.println(JSON.toJSONString(lists));
    }
}
