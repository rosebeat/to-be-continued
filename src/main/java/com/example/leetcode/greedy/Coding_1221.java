package com.example.leetcode.greedy;

import java.util.Stack;

/**
 * @author kai·yang
 * @Date 2023/6/21 15:08
 * leetcode: 【1221】分割平和字符串
 * level：easy
 */
public class Coding_1221 {

    /**
     * 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
     *  给你一个平衡字符串 s，请你将它分割成尽可能多的子字符串，并满足：
     *
     *  每个子字符串都是平衡字符串。
     *
     *  返回可以通过分割得到的平衡字符串的 最大数量 。
     *
     *  示例 1：
     *
     * 输入：s = "RLRRLLRLRL"
     * 输出：4
     * 解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
     *
     *  示例 2：
     *
     * 输入：s = "RLRRRLLRLL"
     * 输出：2
     * 解释：s 可以分割为 "RL"、"RRRLLRLL"，每个子字符串中都包含相同数量的 'L' 和 'R' 。
     * 注意，s 无法分割为 "RL"、"RR"、"RL"、"LR"、"LL" 因为第 2 个和第 5 个子字符串不是平衡字符串。
     *  示例 3：
     *
     * 输入：s = "LLLLRRRR"
     * 输出：1
     * 解释：s 只能保持原样 "LLLLRRRR" 。
     *
     *
     *  提示：
     *
     *  2 <= s.length <= 1000
     *  s[i] = 'L' 或 'R'
     *  s 是一个 平衡 字符串
     *
     *  Related Topics 贪心 字符串 计数
     */


    /**
     * 思路：
     *   1、一个平衡字符串，在顺序去掉一个 子平衡字符串 剩下的也是平衡的
     *   2、使用栈的方式进行压栈，当遇到栈顶字符和即将压入的字符 不一致时则弹出栈顶字符并且当前字符不入栈
     *   3、当栈为空时，则说明前面的字符串是一个 子平衡字符串
     *   4、当字符串只有一个位时：L或者R 也满足情况
     * @param s
     * @return
     */
    public static int balancedStringSplit(String s) {
        int subCount = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()){
                subCount++;
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.peek() != s.charAt(i)){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        return subCount;
    }


    /**
     * 根据题意，对于一个平衡字符串 s，若 s 能从中间某处分割成左右两个子串，若其中一个是平衡字符串，则另一个的 L 和 R 字符的数量必然是相同的，所以也一定是平衡字符串。
     *
     * 为了最大化分割数量，我们可以不断循环，每次从 s 中分割出一个最短的平衡前缀，由于剩余部分也是平衡字符串，我们可以将其当作 s 继续分割，直至 s 为空时，结束循环。
     *
     * 代码实现中，可以在遍历 s 时用一个变量 d 维护 L 和 R 字符的数量之差，当 d=0 时就说明找到了一个平衡字符串，将答案加一。
     * @param s
     * @return
     */
    public static int balancedStringSplitV2(String s) {
        //子平衡字符串个数
        int subCount = 0;
        //L 与 R 差值
        int d = 0;
        for (int i = 0; i < s.length(); ++i) {
            d = s.charAt(i) == 'L' ? d + 1 : d - 1;
            if (d == 0) {
                ++subCount;
            }
        }
        return subCount;
    }


    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
        System.out.println(balancedStringSplitV2("R"));
    }
}
