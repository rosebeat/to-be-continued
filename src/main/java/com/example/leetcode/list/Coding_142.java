package com.example.leetcode.list;

import com.example.leetcode.list.source.ListNode;

/**
 * @author kai·yang
 * @Date 2023/6/30 16:19
 *
 * leetcode: 【142】 环形链表II
 * level：medium
 * <link>
 */
public class Coding_142 {

    /**
     * 给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     *  如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
     * 链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     *  不允许修改 链表。
     *
     *
     *
     *  示例 1：
     *
     *
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：返回索引为 1 的链表节点
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     *  示例 2：
     *
     *
     * 输入：head = [1,2], pos = 0
     * 输出：返回索引为 0 的链表节点
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     *
     *  示例 3：
     *
     *
     * 输入：head = [1], pos = -1
     * 输出：返回 null
     * 解释：链表中没有环。
     *
     *
     *  提示：
     *
     *  链表中节点的数目范围在范围 [0, 104] 内
     *  -105 <= Node.val <= 105
     *  pos 的值为 -1 或者链表中的一个有效索引
     *
     *
     *  进阶：你是否可以使用 O(1) 空间解决此题？
     *  Related Topics 哈希表 链表 双指针
     */


    /**
     * 双指针
     *
     * 使用快慢指针，快指针fast每次走两步，慢指针slow每次走一步：
     * 有两种结果，链表有环，链表无环：
     *   1、链表无环
     *     fast走到链表尾部（fast为null），直接返回null
     *   2、链表有环
     *     当 fast == slow 时 两个指针第一次在环中相遇，分析 fast 和 slow走过的步数
     *     2.1 假设 slow 走了 s 步，则fast = 2s
     *     2.2 假设
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        //快指针每次走两部
        ListNode fast = head;
        //慢指针每次走一步
        ListNode slow = head;
        while(true){
            //不存在环，直接返回null
            if (fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            //如果有环，找到第一次相遇的节点
            if (fast == slow){
                break;
            }
        }
        //快指针，重新从头节点出发，每次走一步
        fast = head;
        //
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
