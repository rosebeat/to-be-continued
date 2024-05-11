package com.example.mylock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: kai·yang
 * @Date: 2024/4/18 9:48
 * @Description:
 */
public class MyReentrantLockTest {

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();

        lock.unlock();

    }


}
