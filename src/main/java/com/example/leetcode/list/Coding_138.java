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


    /**
     * 在同一个链表上增加拷贝，然后再拆分
     *
     * 思路：
     *   1、为每一个node 增加一个拷贝node，原node的next指针指向拷贝node，拷贝node的next指针指向原node的next
     *   2、即 A -> B -> C, 添加拷贝node后，A -> A` -> B -> B` -> C ->C`
     *   3、这样就可以方便的为拷贝node的随机指针赋值，随机指针即为原node 随机指针 的 next 节点，需要注意空值判断
     *   4、完成随即指针赋值后， 按照拷贝顺序 A -> A` -> B -> B` -> C ->C`拆分指针，拆分时注意null判断
     *
     * 时间复杂度：遍历了三次链表  O(n)
     * 空间复杂度：使用了几个变量  O(1)
     * @param head
     * @return
     */
    public RandomNode copyRandomList(RandomNode head) {
        if (head == null){
            return head;
        }
        //为每一个node 增加拷贝节点
        //处理next指针
        RandomNode dummy = head;
        while(dummy != null){
            RandomNode newNode = new RandomNode(dummy.val);
            RandomNode next = dummy.next;
            dummy.next = newNode;
            newNode.next = next;
            dummy = dummy.next.next;
        }
        //处理random指针
        RandomNode random = head;
        while (random != null){
            RandomNode item = random.random;
            RandomNode next = random.next;
            next.random = item == null ? null : item.next;
            random = random.next.next;
        }
        //拆分链表
        RandomNode newHead = head.next;
        RandomNode node = head;
        while(node != null){
            RandomNode item = node.next;
            RandomNode next = node.next.next;
            node.next = next;
            item.next = next == null ? null : next.next;
            node = next;
        }
        return newHead;
    }


    /**
     * 哈希表
     *
     * 时间复杂度：两次遍历 O(n)
     * 空间复杂度：使用哈希表映射 拷贝节点， O(n)
     * @return
     */
    public static RandomNode copyRandomListV2(RandomNode head){
        Map<RandomNode, RandomNode> nodeCache = new HashMap<>();
        RandomNode dummy = new RandomNode(-1);
        RandomNode last = dummy;
        //深拷贝节点，next指针赋值
        for (RandomNode node = head; node != null; node = node.next){
            RandomNode newNode = new RandomNode(node.val);
            nodeCache.put(node, newNode);
            last.next = newNode;
            last = newNode;
        }
        //random指针赋值
        for (RandomNode node = head; node != null; node = node.next){
            RandomNode newNode = nodeCache.get(node);
            newNode.random = node.random == null ? null : nodeCache.get(node.random);
        }
       return dummy.next;
    }



    public static Map<RandomNode, RandomNode> nodeCache = new HashMap<>();
    /**
     * 回溯 + 哈希表
     * 本题要求我们对一个特殊的链表进行深拷贝。如果是普通链表，我们可以直接按照遍历的顺序创建链表节点。而本题中因为随机指针的存在，
     * 当我们拷贝节点时，「当前节点的随机指针指向的节点」可能还没创建，因此我们需要变换思路。一个可行方案是，我们利用回溯的方式，
     * 让每个节点的拷贝操作相互独立。对于当前节点，我们首先要进行拷贝，然后我们进行「当前节点的后继节点」和「当前节点的随机指针指向的节点」拷贝，
     * 拷贝完成后将创建的新节点的指针返回，即可完成当前节点的两指针的赋值。
     *
     * 具体地，我们用哈希表记录每一个节点对应新节点的创建情况。遍历该链表的过程中，我们检查「当前节点的后继节点」和「当前节点的随机指针指向的节点」
     * 的创建情况。如果这两个节点中的任何一个节点的新节点没有被创建，我们都立刻递归地进行创建。当我们拷贝完成，回溯到当前层时，
     * 我们即可完成当前节点的指针赋值。注意一个节点可能被多个其他节点指向，因此我们可能递归地多次尝试拷贝某个节点，为了防止重复拷贝，
     * 我们需要首先检查当前节点是否被拷贝过，如果已经拷贝过，我们可以直接从哈希表中取出拷贝后的节点的指针并返回即可。
     *
     *
     * 时间复杂度：O(n)，其中 n 是链表的长度。对于每个节点，我们至多访问其「后继节点」和「随机指针指向的节点」各一次，均摊每个点至多被访问两次。
     *
     * 空间复杂度：O(n)，其中 n 是链表的长度。为哈希表的空间开销。
     * @param head
     * @return
     */
    public static RandomNode copyRandomListV3(RandomNode head){
        if (head == null){
            return null;
        }
        if (nodeCache.get(head) == null){
            RandomNode newNode = new RandomNode(head.val);
            nodeCache.put(head, newNode);
            newNode.next = copyRandomListV3(head.next);
            newNode.random = copyRandomListV3(head.random);
        }
        return nodeCache.get(head);
    }




    public static void main(String[] args) {
        RandomNode one = new RandomNode(1);
        RandomNode two = new RandomNode(2);
        one.next = two;
        one.random = two;
        two.random = one;
        RandomNode newHead = copyRandomListV2(one);

    }
}
