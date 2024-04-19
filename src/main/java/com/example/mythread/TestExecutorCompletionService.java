package com.example.mythread;

import java.util.concurrent.*;

/**
 * @author: kai·yang
 * @Date: 2024/4/15 17:34
 * @Description:
 */
public class TestExecutorCompletionService {


    private static final ExecutorService pool = Executors.newFixedThreadPool(10);
    private static final ExecutorCompletionService executorCompletionService = new ExecutorCompletionService<>(pool);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        executorCompletionService.submit( ()->{
            System.out.println("任务 1 开始运行");
            Thread.sleep(5000);
            System.out.println("任务 1 运行结束");
            return "任务 1 返回";
        });
        executorCompletionService.submit( ()->{
            System.out.println("任务 2 开始运行");
            Thread.sleep(5000);
            System.out.println("任务 2 运行结束");
            return "任务 2 返回";
        });
        executorCompletionService.submit( ()->{
            System.out.println("任务 3 开始运行");
            Thread.sleep(5000);
            System.out.println("任务 3 运行结束");
            return "任务 3 返回";
        });
        executorCompletionService.submit( ()->{
            System.out.println("任务 4 开始运行");
            Thread.sleep(5000);
            System.out.println("任务 4 运行结束");
            return "任务 4 返回";
        });

        for (int i = 0; i < 4; i++) {
            Future take = executorCompletionService.take();
            String r = take.get().toString();
            System.out.println(r);
        }

    }


}
