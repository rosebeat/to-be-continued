package com.example.leetcode.hot100;

import com.example.util.RandomNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author: kai·yang
 * @Date: 2024/7/11 9:41
 * @Description:
 *
 *
 * LeetCode: 【138】随机链表的复制
 * Difficulty：medium
 * <link> https://leetcode.cn/problems/copy-list-with-random-pointer/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Hot_xxx_138 {


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




    /**
     * 在同一个链表上拷贝然后在拆分
     *
     * 思路：
     *      1、在原链表的基础上为每个node增加一个拷贝节点 node`，原node的next指向拷贝node`, 拷贝node`next指向 原node的next
     *      2、即 A -> B -> C, 增加拷贝节点后： A -> A` -> B -> B` -> C -> C`
     *      3、方便给拷贝节点的random指针符值，random指向原node节点random指针的next节点
     *      4、拷贝完成后，即可对A -> A` -> B -> B` -> C -> C`进行才分
     *
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param node
     * @return
     */
    public static RandomNode copyRandomList(RandomNode node){
        RandomNode pre = node;
        //1、拷贝next节点
        while(pre != null){
            RandomNode next = pre.next;
            //新建一个节点
            RandomNode item = new RandomNode(pre.val);
            pre.next = item;
            item.next = next;
            pre = next;
        }

        //2、random符值
        RandomNode nodeRandom = node;
        while(nodeRandom != null){
            //原节点的random指针
            RandomNode random = nodeRandom.random;
            //拷贝节点
            RandomNode copy = nodeRandom.next;
            //拷贝节点random符值，判空
            copy.random = random == null ? null : random.next;
            nodeRandom = nodeRandom.next.next;
        }
        //3、拆分链表
        RandomNode dummy = new RandomNode(-1);
        RandomNode finish = dummy;
        while(node != null){
            //拷贝节点数据
            RandomNode copy = node.next;
            //原链表的下一个节点
            RandomNode next = node.next.next;
            finish.next = copy;
            finish = copy;
            node.next = next;
            node = next;
        }
        return dummy.next;
    }


    /**
     *
     * 回溯 + 哈希表
     *
     *
     * @param head
     * @return
     */

    Map<RandomNode, RandomNode> cache = new HashMap<>();

    public RandomNode copyRandomListV2(RandomNode head){
        if (head == null){
            return null;
        }
        if (cache.get(head) == null){
            RandomNode copy = new RandomNode(head.val);
            //对next 指针进行递归创建
            copy.next = copyRandomListV2(head.next);
            //对random指针进行递归符值
            copy.random = copyRandomListV2(head.random);
        }
        return cache.get(head);
    }







    public static void main(String[] args) {
        RandomNode one = new RandomNode(1);
        RandomNode two = new RandomNode(2);
        one.next = two;
        one.random = two;
        two.random = one;
        RandomNode newHead = copyRandomList(one);

    }

}
