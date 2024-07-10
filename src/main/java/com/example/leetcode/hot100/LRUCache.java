package com.example.leetcode.hot100;



import java.util.HashMap;
import java.util.Map;

/**
 * @author: kai·yang
 * @Date: 2024/7/10 11:36
 * @Description:
 *
 *
 * LeetCode: 【146】 LRU Cache
 * Difficulty；medium
 * <link> https://leetcode.cn/problems/lru-cache/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class LRUCache {


    /**
     *请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
     * 实现 LRUCache 类：
     * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
     * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
     * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
     *
     * 示例：
     *
     * 输入
     * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
     * 输出
     * [null, null, null, 1, null, -1, null, -1, 3, 4]
     *
     * 解释
     * LRUCache lRUCache = new LRUCache(2);
     * lRUCache.put(1, 1); // 缓存是 {1=1}
     * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
     * lRUCache.get(1);    // 返回 1
     * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
     * lRUCache.get(2);    // 返回 -1 (未找到)
     * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
     * lRUCache.get(1);    // 返回 -1 (未找到)
     * lRUCache.get(3);    // 返回 3
     * lRUCache.get(4);    // 返回 4
     *
     *
     * 提示：
     *
     * 1 <= capacity <= 3000
     * 0 <= key <= 10000
     * 0 <= value <= 105
     * 最多调用 2 * 105 次 get 和 put
     */



    Map<Integer, DoubleListNode> cache = new HashMap<>();


    /**
     * 头节点
     */
    DoubleListNode head;

    /**
     * 尾节点
     */
    DoubleListNode tail;

    /**
     * 容量
     */
    int capacity;

    /**
     * 现在缓存大小
     */
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DoubleListNode();
        tail = new DoubleListNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DoubleListNode node = cache.get(key);
        if (node == null){
            return -1;
        }
        moveNodeToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DoubleListNode node = cache.get(key);
        if (node != null){
            node.val = value;
            moveNodeToHead(node);
            return;
        }
        //如果key不存在就新建一个节点
        node = new DoubleListNode(key, value);
        //添加进哈希表
        cache.put(key, node);
        //添加节点到双向链表的头部
        addNode(node);
        ++size;
        if (size > capacity){
            //如果链表大小超过容量，删除尾节点
            DoubleListNode deleteNode = tail.pre;
            removeNode(deleteNode);
            //删除哈希表中对应的数据
            cache.remove(deleteNode.key);
            --size;
        }

    }

    public void removeNode(DoubleListNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        //便于GC
        node.pre = null;
        node.next = null;
    }

    public void addNode(DoubleListNode node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }


    public void moveNodeToHead(DoubleListNode node){
        removeNode(node);
        addNode(node);
    }


    class DoubleListNode{

        int key;
        int val;
        public DoubleListNode pre;

        public DoubleListNode next;


        public DoubleListNode(){

        }

        public DoubleListNode(int key, int val){
            this.key = key;
            this.val = val;
        }


    }


    public static void main(String[] args) {
        LRUCache c = new LRUCache(1);
        c.put(2,1);
        System.out.println(c.get(2));
    }


}
