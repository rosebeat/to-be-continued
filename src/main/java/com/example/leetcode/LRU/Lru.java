package com.example.leetcode.LRU;

/**
 * @author kai·yang
 * @Date 2021/8/30 15:17
 */

import lombok.Data;

import java.util.HashMap;

/**
 * LRU算法 -> least recently used  最少使用
 */
public class Lru<K, V> {

    @Data
    class Node{
        private Node pre;
        private Node next;
        private Object key;
        private Object value;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = next;
        }
    }

    private HashMap<K, Node> nodeMap;
    private int cacheCapacity = 16;
    private Node head;
    private Node tail;

    public Lru(){
    }

    public Lru(int size){
        this.cacheCapacity = size;
        nodeMap = new HashMap(cacheCapacity);
    }

    public void add(K key, V value){
        Node node = nodeMap.get(key);
        if (node == null){
            newAddHead(key, value);
        }else{
            remove(node);
            newAddHead(key, value);
        }

    }

    public Object get(K key){
        Node node = nodeMap.get(key);
        if (node == null){
            return null;
        }
        remove(node);
        newAddHead(key, (V)node.getValue());
        return node.getValue();
    }

    private void newAddHead(K key, V value){
        int size = nodeMap.size();
        if (size >= cacheCapacity){
            delete();
        }
        Node node = new Node(key, value, head);
        head.pre = node;
        head = node;
        if (tail == null){
            tail = node;
        }
        nodeMap.put(key,node);
    }

    public void remove(Node node){
        if (node == null){
            return;
        }
        if (node.pre != null){
            node.pre.next = node.next;
        }
        if (node.next != null ){
            node.next.pre = node.pre;
        }

        if (node == head){
            head = node.next;
        }
        if (node == tail){
            tail = node.pre;
        }
        Object key = node.getKey();
        nodeMap.remove(key);
    }

    private void delete(){
        Object key = tail.key;
        tail = tail.pre;
        tail.pre.next = null;
        nodeMap.remove(key);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("");
        Node node = head;
        while(node != null){
            result.append(node.getValue());
            node = node.next;
        }
        return result.toString();
    }
}
