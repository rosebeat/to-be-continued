package com.example.leetcode.list;

import com.example.leetcode.list.source.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author kai·yang
 * @Date 2023/6/29 17:11
 *
 * leetcode: 【19】 删除链表倒数第N个节点
 * level: medium
 * <link> https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
public class Coding_19 {

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     *  示例 1：
     *
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     *
     *  示例 2：
     *
     * 输入：head = [1], n = 1
     * 输出：[]
     *
     *  示例 3：
     *
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     *
     *
     *  提示：
     *
     *  链表中结点的数目为 sz
     *  1 <= sz <= 30
     *  0 <= Node.val <= 100
     *  1 <= n <= sz
     *
     *
     *  进阶：你能尝试使用一趟扫描实现吗？
     *  Related Topics 链表 双指针
     */


    /**
     * 压栈
     *
     * 遍历链表的同时将所有节点依次入栈。根据栈「先进后出」的原则，我们弹出栈的第 n 个节点就是需要删除的节点，
     * 并且目前栈顶的节点就是待删除节点的前驱节点。
     *
     *  时间复杂度：
     *      遍历一次链表： O(n)
     *  空间复杂度：
     *      把所有节点压入栈中：O(n)
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode currnet = dummyNode;
        Deque<ListNode> stack = new LinkedList<>();
        //所有元素入栈，根据栈的先进后出原则
        while(currnet != null){
            stack.push(currnet);
            currnet = currnet.next;
        }
        //依次弹出元素
        while(!stack.isEmpty()){
            if(--n == 0){
                //要删除的节点
                ListNode pop = stack.pop();
                //待删除的前驱节点
                ListNode prev = stack.peek();
                prev.next = pop.next;
                break;
            }else{
                stack.pop();
            }
        }
        return dummyNode.next;
    }


    /**
     * 双指针
     *
     * 思路：由于我们要找到倒数第 N 个节点， 可是使用两个指针对 before 和 after 对链表进行遍历
     *      当 before 比 after 超前 N 个节点（ before - after = N-1） 并且 before指向链表尾部（before为null）,
     *       after指向的位置就是待删除的节点
     *
     * 首先before 和 after 都指向 head 节点 before先向前遍历 N 次，此时 before 和 after 间隔 n-1 个节点
     * 此时同同时遍历before和after，当before遍历到链表尾部即before为null时，after刚好在倒数第N个节点上。
     * 单链表为了删除操作方便，当 after 是倒数第N个节点的前驱节点，更容易操作
     * 所以设置一个虚拟节点指向head，开始时 before 指向head，after指向虚拟节点
     * 其余操作不变当before指向链表尾部即before为null时，after刚好指向倒数第N节点的前一个节点
     * after.next即为要删除的节点
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEndV2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        //前指针
        ListNode before = head;
        //后指针
        ListNode after = dummy;
        for (int i = 0; i < n; i++) {
            before = before.next;
        }
        while(before != null){
            after = after.next;
            before = before.next;
        }
        //当before为空时，before 与 after 中间有 n 个节点，after为待删除节点的前驱节点
        after.next = after.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
