package com.example.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * QPS 计算器
 *
 * @author: kai·yang
 * @Date: 2024/5/29 11:02
 * @Description:
 */
public class QpsCalculator {

    class Node{

        /**
         * 时间戳
         */
        volatile long millis;

        /**
         * 前节点
         */
        Node prev;

        /**
         * 后节点
         */
        Node next;

    }

    /**
     * 循环链表的最大长度
     */
    private final int loopLength;


    /**
     * 当前节点
     */
    private Node current;



    public QpsCalculator(){
        this(1000);
    }

    public QpsCalculator(int loopLength){
        this.loopLength = loopLength;
        init();
    }


    /**
     * 初始化环形链表
     */
    public void init(){
        long start = System.currentTimeMillis();
        Node first = new Node();
        Node prev = first;
        for (int i = 1; i < loopLength; i++){
            current = new Node();
            current.prev = prev;
            prev.next = current;
            prev = current;
        }
        first.prev = current;
        current.next = first;
        System.out.println(" 初始换花费时间： " + (System.currentTimeMillis() - start));
    }


    /**
     * 添加节点
     * 在初始化完成的 链表换中更新数据
     */
    public synchronized void add(){
        current = current.next;
        current.millis = System.currentTimeMillis();
    }


    public long qpc( int statsCycleMillis ){
        //向前回溯的节点个数
        long sum = 0;
        Node last = new Node();
        last.millis = System.currentTimeMillis();
        last.prev = current;
        Node first = last;
        //向前回溯节点花费的时间
        long diff = 0;
        //向前回溯指定时间 statsCycleMillis 内最早的节点
        for(int i = 0; i < loopLength; i++ ){
            //时间差
            long tdiff = last.millis - first.prev.millis;
            if (tdiff > statsCycleMillis){
                //未走完链表环，统计时间记为： statsCycleMillis
                diff = statsCycleMillis;
                break;
            }

            if (tdiff < diff){
                break;
            }

            diff = tdiff;
            first = first.prev;
            sum++;
        }
        if (diff <=0 ){
            diff = 1;
        }
        return sum * statsCycleMillis / diff;
    }


    /**
     * 计算 qps
     * @return
     */
    public long qps(){
        return qpc(1000);
    }


    public static void main(String[] args) {
        QpsCalculator qps = new QpsCalculator();
        ExecutorService executorService = Executors.newFixedThreadPool(25);
        long start = System.currentTimeMillis();
        for (int i = 0 ; i < 1000; i++){
            executorService.execute( () -> {
                qps.add();
            });

        }
        System.out.println(" 并发请求耗时： " + ( System.currentTimeMillis() - start));
    }

}
