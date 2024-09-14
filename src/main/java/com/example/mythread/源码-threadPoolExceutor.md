# ThreadPoolExecutor

## 核心属性
```java
    
    //线程池状态（高三位表示线程池状态） 和 当前线程池线程数量（低29位代表线程池线程数量）
    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    //线程池线程数量上线，ctl低29位 
    private static final int COUNT_BITS = Integer.SIZE - 3;
    //当前线程池最大线程数量 00001111 11111111 11111111 11111111
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;
    
    //线程池状态,ctl的高三位表示线程池状态
    // runState is stored in the high-order bits
    //高三位 111 表示running
    private static final int RUNNING    = -1 << COUNT_BITS;
    //高三位 000 表示shutdown
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    //高三位 001 表示stop
    private static final int STOP       =  1 << COUNT_BITS;
    //高三位 010 表示tidy
    private static final int TIDYING    =  2 << COUNT_BITS;
    //高三位 011 表示terminated
    private static final int TERMINATED =  3 << COUNT_BITS;


    //线程池任务队列
    private final BlockingQueue<Runnable> workQueue;
    
    
    
```


