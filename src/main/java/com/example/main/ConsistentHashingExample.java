package com.example.main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author: kai·yang
 * @Date: 2024/8/1 14:49
 * @Description:
 *
 *
 * 简单版 哈希环(一致性哈希)，
 *  一致性哈希是一种算法，哈希环是它的具体实现
 *
 *  在哈希环的基础上还有 虚拟哈希环
 *
 */
public class ConsistentHashingExample {

    private static final int VIRTUAL_NODES_PER_NODE = 100; // 每个物理节点对应的虚拟节点数量
    private static final int NODE_COUNT = 3; // 物理节点的数量
    private static final TreeMap<Integer, String> virtualNodes = new TreeMap<>(); // 保存虚拟节点的位置和对应的物理节点名称
    private static final Set<String> nodes = new HashSet<>(); // 物理节点集合

    public static void main(String[] args) {
        initializeNodes();
        addData("key1", "value1");
        addData("key2", "value2");
        addData("key3", "value3");
        addData("key4", "value4");
    }

    private static void initializeNodes() {
        for (int i = 0; i < NODE_COUNT; i++) {
            String nodeName = "node" + i;
            nodes.add(nodeName);
            for (int j = 0; j < VIRTUAL_NODES_PER_NODE; j++) {
                int hash = hash(nodeName + ":" + j);
                virtualNodes.put(hash, nodeName);
            }
        }
    }

    private static void addData(String key, String value) {
        int hash = hash(key);
        // TreeMap.ceilingEntry() 方法用于返回与大于或等于给定键的最小键关联的键值映射，如果没有这样的键，则返回 null。
        Map.Entry<Integer, String> entry = virtualNodes.ceilingEntry(hash);
        if (entry == null) {
            entry = virtualNodes.firstEntry();
        }
        String node = entry.getValue();
        System.out.println("Key: " + key + " is stored on Node: " + node + " with Value: " + value);
    }

    private static int hash(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(key.getBytes());
            return Math.abs(digest[0] << 24 | digest[1] << 16 | digest[2] << 8 | digest[3]);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
