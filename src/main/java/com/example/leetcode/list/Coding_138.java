package com.example.leetcode.list;

import com.example.leetcode.list.source.RandomNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kai·yang
 * @Date 2023/7/4 16:51
 *
 * leetcode: 【138】符值带随机指针的链表
 * level：medium
 * <link>https://leetcode.cn/problems/copy-list-with-random-pointer/
 * company: 字节
 */
public class Coding_138 {

    /**
     * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，
     *  构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新
     * 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的
     *  例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y
     * --> y 。
     *  返回复制链表的头节点。
     *  用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [va
     *
     *  val：一个表示 Node.val 的整数。
     *  random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如
     *
     *  你的代码 只 接受原链表的头节点 head 作为传入参数。
     *
     *  示例 1：
     *
     *
     * 输入：head = [[7,null],[13,0],[11,4],[10,2]
     * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
     *
     *  示例 2：
     *
     *
     * 输入：head = [[1,1],[2,1]]
     * 输出：[[1,1],[2,1]]
     *
     *  示例 3：
     *
     *
     * 输入：head = [[3,null],[3,0],[3,null]]
     * 输出：[[3,null],[3,0],[3,null]]
     *
     *
     *  提示：
     *
     *  0 <= n <= 1000
     *  -104 <= Node.val <= 104
     *  Node.random 为 null 或指向链表中的节点。
     *
     *  Related Topics 哈希表 链表
     */


    public RandomNode copyRandomList(RandomNode head) {
        RandomNode dummy = new RandomNode(-1);
        dummy.next = head;
        Map<Integer, RandomNode> list = new HashMap<>();
        return null;
    }
}
