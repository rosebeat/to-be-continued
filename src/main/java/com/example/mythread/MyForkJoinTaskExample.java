package com.example.mythread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author kai·yang
 * @Date 2021/11/5 17:26
 */
@Slf4j
public class MyForkJoinTaskExample extends RecursiveTask<Integer> {



    public static final int threshold = 2;

    private int start;
    private int end;

    public MyForkJoinTaskExample(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        log.info("这是子任务：{}", "***  ***");
        int sum = 0;
        //如果任务足够小就计算任务
        boolean canCompute = (end - start) <= threshold;
        if (canCompute){
            for (int i = start; i <= end; i++){
                sum += i;
            }
        }else {
            // 如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end) / 2;
            MyForkJoinTaskExample leftTask = new MyForkJoinTaskExample(start, middle);
            MyForkJoinTaskExample rightTask = new MyForkJoinTaskExample(middle + 1, end);
            // 执行子任务
            leftTask.fork();
            rightTask.fork();
            // 等待任务执行结束合并其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            // 合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }


    public static void main(String[] args) {
        ForkJoinPool forkjoinPool = new ForkJoinPool();
        //生成一个计算任务，计算1+2+3+4
        MyForkJoinTaskExample task = new MyForkJoinTaskExample(1, 100);
        //执行一个任务
        Future<Integer> result = forkjoinPool.submit(task);
        try {
            log.info("result:{}", result.get());
        } catch (Exception e) {
            log.error("exception", e);
        }
    }
}
