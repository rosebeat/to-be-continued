package com.example.leetcode.list;

import com.example.leetcode.list.source.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author kai·yang
 * @Date 2023/6/30 14:25
 *
 * leetcode: 【160】链表相交
 * level：medium
 * <link> https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */
public class Coding_160 {

    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     *  图示两个链表在节点 c1 开始相交：
     *
     *  题目数据 保证 整个链式结构中不存在环。
     *  注意，函数返回结果后，链表必须 保持其原始结构 。
     *  自定义评测：
     *  评测系统 的输入如下（你设计的程序 不适用 此输入）：
     *
     *  intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
     *  listA - 第一个链表
     *  listB - 第二个链表
     *  skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
     *  skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
     *
     *  评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将
     * 作正确答案 。
     *
     *  示例 1：
     *
     *
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2,
     * ipB = 3
     * 输出：Intersected at '8'
     * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
     * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
     * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     * — 请注意相交节点的值不为 1，因为在链表 A 和链表 B 之中值为 1 的节点 (A 中第二个节点和 B 中第三个节点) 是不同的节点。换句话说，它
     * 存中指向两个不同的位置，而链表 A 和链表 B 中值为 8 的节点 (A 中第三个节点，B 中第四个节点) 在内存中指向相同的位置。
     *
     *
     *  示例 2：
     *
     *
     * 输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB
     * 1
     * 输出：Intersected at '2'
     * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
     * 从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
     * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
     *
     *  示例 3：
     *
     *
     * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * 输出：null
     * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
     * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
     * 这两个链表不相交，因此返回 null 。
     *
     *
     *  提示：
     *
     *  listA 中节点数目为 m
     *  listB 中节点数目为 n
     *  1 <= m, n <= 3 * 104
     *  1 <= Node.val <= 105
     *  0 <= skipA <= m
     *  0 <= skipB <= n
     *  如果 listA 和 listB 没有交点，intersectVal 为 0
     *  如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB]
     *
     *
     *  进阶：你能否设计一个时间复杂度 O(m + n) 、仅用 O(1) 内存的解决方案？
     *  Related Topics 哈希表 链表 双指针
     */


    /**
     * 方法一：
     *    压栈，然后依次弹出 比较两个链表的节点时候相等
     * 时间复杂度： 遍历了两个链表 O(n + m)
     * 空间复杂度： 使用了两个栈存数据 O(n + m)
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Deque<ListNode> stackA = new LinkedList<>();
        Deque<ListNode> stackB = new LinkedList<>();
        while(headA != null){
            stackA.push(headA);
            headA = headA.next;
        }
        while(headB != null){
            stackB.push(headB);
            headB = headB.next;
        }
        ListNode intersection = null;
        while(!stackA.isEmpty() && !stackB.isEmpty()){
            if (stackA.peek() != stackB.peek()){
                break;
            }else{
                intersection = stackA.pop();
                stackB.pop();
            }
        }
        return intersection;
    }


    /**
     * 方法二：
     *   双指针
     *
     * 思路：
     * headA  和 headB 都不为null 才有可能相交，首先判断headA 和 headB 是否为null，为null 直接返回null
     * 设置两个指针pA 和 pB 都指向都节点依次遍历
     *    1、每遍历一次 pA 和 pB同时向下移动
     *    2、如果pA为空时，将pA指向 headB；如果pB为空时，将pB指向 headA
     *    3、当pA 和 pB指向同一个节点或者都为null时，遍历结束，返回 指向的节点或者null
     * 证明
     *    分两种情况考虑，一 ：两者相交 ，二：两者不相交
     *      1：两者相交
     *         1.1 设headA长度为 m，heaB长度为 n，headA不相交的部分为 x，headB不相交的部位为 y，相交的部分为c
     *         1.2 如果 x == y，则 pA 与 pB会同时到达相交点，返回相交点
     *         1.3 如果 x != y, pA会遍历完headA， pB会遍历完headB，pA和 pB不会同时到达队尾，然后将pA指向headB，
     *             pB指向headA,当pA移动了 x+y+c次，pB移动了 x+y+c次 会同时到达相交点，该节点就是两个链表第一次相交的地方
     *      2： 两者不相交
     *         2.1 设headA长度为 m，heaB长度为 n
     *         2.2 如果 m == n 则 pA 和 pB 会同时指向null，此时返回null
     *         2.3 如果 m != n，pA 和 pB 不会同时到达队尾，但是当 pA 遍历了 m+n 次，pB遍历了 m+n 次 会同时指向 null，此时返回null
     *
     * 时间复杂度：最多遍历 m + n次  O(m + n)
     * 空间复杂度：使用了两个变量   O(1)
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }



    public static void main(String[] args) {
        // listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(5);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(6);
        a.next = one;
        b.next = two;
        ListNode three = new ListNode(8);
        one.next = three;
        two.next = three;
        ListNode four = new ListNode(4);
        three.next = four;
        three.next = four;
        ListNode five = new ListNode(5);
        four.next = five;
        four.next = five;
        ListNode six = new ListNode(5);
        five.next = six;
        five.next = six;
        System.out.println(getIntersectionNode(a, b).val);
        System.out.println(getIntersectionNodeV2(a, b).val);

    }
}
