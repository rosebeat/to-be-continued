package com.example.leetcode;

import org.apache.commons.lang3.ThreadUtils;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author: kai·yang
 * @Date: 2024/8/23 15:25
 * @Description:
 */
public class Philosopher {


    /**
     * 5个哲学家吃饭问题，多线程死锁问题以及解决方案
     *
     */


    public static void main(String[] args) throws RuntimeException{
        int pNum = 5;
        //为每只筷子分配一个 数值为1的信号量
        Semaphore[] semaphores = new Semaphore[pNum];
        for (int i = 0; i < pNum; i++){
            semaphores[i] = new Semaphore(1);
        }
        Thread[] philosophers = new Thread[pNum];
        for (int i = 0; i < pNum; i++){
            final int p = i;
            philosophers[i] = new Thread( () -> {
                while(true) {
                    try {
                        //通过每个哲学家编号的奇偶性，来判断先拿左手还是右手边的筷子，打破了循环等待
                        if (p % 2 == 0) {
                            semaphores[p].acquire();
                            semaphores[(p + 1) % pNum].acquire();

                        } else {
                            semaphores[(p + 1) % pNum].acquire();
                            semaphores[p].acquire();
                        }
                        System.out.println("哲学家" + p + "正在吃饭！！！");
                        semaphores[p].release();
                        semaphores[(p + 1) % pNum].release();
                        System.out.println("哲学家" + p + "正在思考！！！");
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });

        }

        for (int i = 0; i < pNum; i++){
            philosophers[i].start();
        }

    }



}
