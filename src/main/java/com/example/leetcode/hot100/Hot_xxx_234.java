package com.example.leetcode.hot100;

import com.example.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: kai·yang
 * @Date: 2024/7/3 17:30
 * @Description:
 *
 * LeetCode: 【234】回文链表
 * Difficulty：medium
 * <link> https://leetcode.cn/problems/palindrome-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class Hot_xxx_234 {


    /**
     * 给你一个单链表的头节点 head ，请你判断该链表是否为
     * 回文链表
     * 。如果是，返回 true ；否则，返回 false 。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,2,1]
     * 输出：true
     * 示例 2：
     *
     *
     * 输入：head = [1,2]
     * 输出：false
     *
     *
     * 提示：
     *
     * 链表中节点数目在范围[1, 105] 内
     * 0 <= Node.val <= 9
     *
     *
     * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */

    /**
     *  思路： 将链表转为数组， 使用数组判断是否是回文
     *
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode root = head;
        //将链表转为数组
        while(root != null){
            list.add(root.val);
            root = root.next;
        }
        int l = 0;
        int r = list.size() - 1;
        while(l < r){
            if(!list.get(l).equals(list.get(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;

    }

}
