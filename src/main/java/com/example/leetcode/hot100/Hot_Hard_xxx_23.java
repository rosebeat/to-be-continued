package com.example.leetcode.hot100;

import com.example.util.ListNode;

import java.util.PriorityQueue;

/**
 * @Ahthor k·Young
 * @Date 2024/11/1 16:19
 * @Version 1.0
 * @Desc
 *
 * LeetCode: 【23】合并K个升序链表
 * Difficulty: hard
 * <link>https://leetcode.cn/problems/merge-k-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_Hard_xxx_23 {


    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     *
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     *
     *
     * 示例 1：
     *
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 示例 2：
     *
     * 输入：lists = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：lists = [[]]
     * 输出：[]
     *
     *
     * 提示：
     *
     * k == lists.length
     * 0 <= k <= 10^4
     * 0 <= lists[i].length <= 500
     * -10^4 <= lists[i][j] <= 10^4
     * lists[i] 按 升序 排列
     * lists[i].length 的总和不超过 10^4
     */

    /**
     * 通过遍历，从后往前 把链表合并到 第一个链表中
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int r = lists.length - 1;
        while(0 < r){
            ListNode merge = merge(lists[0], lists[r]);
            lists[0] = merge;
            r--;
        }
        return lists[0];
    }


    /**
     * 使用优先队列的 最小堆
     *
     * 合并后链表
     *      第一个节点，肯定是其中一个链表的头节点（因为链表已经排好序）
     *      第二个节点，可能是某个几点的头节点，或者是first节点的下一个节点
     *
     *  按照这个过程继续思考，每当我们找到一个节点值最小的节点 x，就把节点 x.next 加入「可能是最小节点」的集合中。
     *
     * 因此，我们需要一个数据结构，它支持：
     *    a. 从数据结构中找到并移除最小节点。
     *    b. 插入节点。
     *
     * 这可以用最小堆实现。初始把所有链表的头节点入堆，然后不断弹出堆中最小节点 x，如果 x.next 不为空就加入堆中。循环直到堆为空。把弹出的节点
     * 按顺序拼接起来，就得到了答案。
     *
     * @param lists
     * @return
     */
    public ListNode mergeKListsV2(ListNode[] lists){
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        //加入所有头节点
        for( ListNode head : lists){
            if (head != null){
                pq.add(head);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        //循环到小根堆为空
        while(!pq.isEmpty()){
            //弹出当前最小的节点
            ListNode poll = pq.poll();
            cur.next = poll;
            cur = cur.next;
            //如果下一个节点不为空，将他加入到小根堆中
            if (poll.next != null){
                pq.add(poll.next);
            }
        }
        return dummy.next;
    }


    /**
     * 分而合并
     * @param lists
     * @return
     */
    public ListNode mergeKListsV3(ListNode[] lists){
        ListNode res = mergeK(lists, 0, lists.length);
        return res;
    }

    /**
     * 二分 左闭右闭区间
     * @param lists
     * @param l
     * @param r
     * @return
     */
    public ListNode mergeK(ListNode[] lists, int l, int r){
        if (l == r){
            return lists[l];
        }
        if ( l > r){
            return null;
        }
        int mid = l + ((r - l)) >> 1;
        ListNode left = mergeK(lists, l, mid);
        ListNode right = mergeK(lists, mid + 1, r);
        return merge(left, right);
    }


    /**
     * 合并两个链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode finish = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                finish.next = l1;
                l1 = l1.next;
            }else{
                finish.next = l2;
                l2 = l2.next;
            }
            finish = finish.next;
        }
        finish.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
