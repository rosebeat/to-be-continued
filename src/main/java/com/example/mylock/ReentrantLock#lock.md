# ReentrantLock加锁过程

```text
ReentrantLock 是基于 AQS实现的， AQS内部使用一个 volatile 修饰的 state 来维护锁的状态， 使用一个双向队列来维护等待获取锁而被阻塞的线程
```


## lock方法
```java
public void lock() {
    sync.lock();
}
```
内部调用的是 `Sync`下的`lock()`方法，`lock()`是个抽象方法，它有两种实现方式 公平(FairSync)和非公平(NonfairSync)

公平锁和非公平锁的区别
- 非公平锁在上来直接竞争锁资源，竞争失败走acquire方法，排队等待
- 公平锁直接走acquire方法，判断锁资源是否为空，当前线程是否在AQS队列中第一位，是则竞争锁资源，不是排队等待
### 1. 非公平实现方式
#### 1.1 lock()方法
```java
final void lock() {
    //compareAndSetState(0, 1),通过CAS的方式尝试获取一次锁
    if (compareAndSetState(0, 1))
        //获取锁成功，设置 exclusiveOwnerThread 属性 为当前线程
        //exclusiveOwnerThread 是抽象类 AbstractOwnableSynchronizer里的属性
        //AbstractQueueSynchronizer 继承了 AbstractOwnableSynchronizer
        setExclusiveOwnerThread(Thread.currentThread());
    else
        acquire(1);
}
```
#### 1.2 acquire()方法
```java
public final void acquire(int arg) {
    //1. tryAcquire 再次尝试一次获取锁资源, 抢锁失败：false，成功：true
    //2. addWaiter 将当前线程构造成一个Node，并将当前节点设置为尾节
    //3. acquireQueued 判断当前节点是否是头节点，如果是则 CAS获取锁资源，如果不是则将当前线程挂起，并返回当前线程是否被中断
    if (!tryAcquire(arg) &&
        acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
        //安全中断线程
        selfInterrupt();
}

```

#### 1.3 tryAcquire()

```java

protected final boolean tryAcquire(int acquires) {
    return nonfairTryAcquire(acquires);
}

/**
 * Performs non-fair tryLock.  tryAcquire is implemented in
 * subclasses, but both need nonfair try for trylock method.
 */
final boolean nonfairTryAcquire(int acquires) {
    //获取当前线程
    final Thread current = Thread.currentThread();
    //获取当前 state 
    int c = getState();
    // state 等于 0 可以竞争锁资源
    if (c == 0) {
        //CAS 设置 state 为 1， 成功：true ，失败：false
        if (compareAndSetState(0, acquires)) {
            //抢锁成功
            //设置 exclusiveOwnerThread 属性 为当前线程
            setExclusiveOwnerThread(current);
            return true;
        }
    }
    // state 不等于0， 锁资源还没释放
    //判断当前持有锁的线程是否是当前线程
    else if (current == getExclusiveOwnerThread()) {
        //是当前线程，锁重入，state + 1
        int nextc = c + acquires;
        //这里出现负数，怕 int 溢出，int的最大值 + 1为int 最小值 
        if (nextc < 0) // overflow
            throw new Error("Maximum lock count exceeded");
        //设置 state
        setState(nextc);
        return true;
    }
    return false;
}

```

#### 1.4 addWaiter

```java

/**
 * Creates and enqueues node for current thread and given mode.
 *
 * @param mode Node.EXCLUSIVE for exclusive, Node.SHARED for shared
 * @return the new node
 */
private Node addWaiter(Node mode) {
    //根据当前线程创建一个 node 节点
    Node node = new Node(Thread.currentThread(), mode);
    // Try the fast path of enq; backup to full enq on failure
    //获取当前双向队列的 尾节点
    Node pred = tail;
    if (pred != null) {
        //尾节点不为空，将当前节点的 prev 指针指向 尾节点
        node.prev = pred;
        // CAS 方式 将当前节点设置为尾节点，成功：true，失败：false
        if (compareAndSetTail(pred, node)) {
            //将尾节点next指针指向当前节点
            pred.next = node;
            return node;
        }
    }
    //尾节点为null，或者上面CAS设置尾节点失败
    enq(node);
    return node;
}


/**
 * Inserts node into queue, initializing if necessary. See picture above.
 * @param node the node to insert
 * @return node's predecessor
 */
private Node enq(final Node node) {
    // 采用死循环，直到将当前节点设置为尾节点
    for (;;) {
        //当前双向链表的尾节点
        Node t = tail;
        //尾节点为null，当前双向链表也为空
        //第一次向双向链表添加节点
        if (t == null) { // Must initialize
            //创建一个虚拟节点(哨兵节点)，作为头节点
            //创建一个虚拟节点是为方便操作
            if (compareAndSetHead(new Node()))
                //头节点和尾节点都指向该虚拟节点
                tail = head;
        } else {
            //当前节点prev指针指向 尾节点
            node.prev = t;
            //CAS 设置当前节点为尾节点，成功：true，失败：false
            if (compareAndSetTail(t, node)) {
                //尾节点next指向 当前节点
                t.next = node;
                return t;
            }
        }
    }
}

```

#### 1.5 acquireQueued()方法

```java

/**
 * Acquires in exclusive uninterruptible mode for thread already in
 * queue. Used by condition wait methods as well as acquire.
 *
 * @param node the node
 * @param arg the acquire argument
 * @return {@code true} if interrupted while waiting
 */
/**
 * 
 * 1、如果当前节点的前继节点为头节点（head）, 则当前节点再竞争一次锁资源，如果成功的话，将当前节点设置为头节点
 * 2. 如果当前节点不是头节点
 *    2.1：当前节点的前继节点状态为 0（节点刚被创建的时候） 时， 将当前节点的 prev 指针指向前继节点，前继节点的next指针指向当前节点
 *    2.2：当前节点的前继节点状态为 1 （CANCELLED 节点已经被取消）时，说明前继节点任务已经被取消，需要往前找，找到一个节点状态 <= 0 的节点为止
 *         将当前节点的 prev 指针指向前继节点，前继节点的next指针指向当前节点
 *    2.3：将前继节点状态改为 -1（SIGNAL 后面有节点，任务结束时要将后继节点唤醒）)
 *    2.4：将当前线程挂起，并检查当前线程时候被中断（中断标记为是否为 true）
 * 
 * 
 */
final boolean acquireQueued(final Node node, int arg) {
    boolean failed = true;
    try {
        boolean interrupted = false;
        for (;;) {
            //获取当前节点的前继节点
            final Node p = node.predecessor();
            //如果前继节点是头节点，那么就通过tryAcquire获取一次锁
            if (p == head && tryAcquire(arg)) {
                //获取锁成功
                //设置头节点
                setHead(node);
                //将当前的头节点的next指向null，从双向链表中断开
                p.next = null; // help GC
                //设置失败标记为false
                failed = false;
                return interrupted;
            }
            //没有获得锁资源
            //shouldParkAfterFailedAcquire 将当前节点的prev指针指向尾节点，如果当前尾节点已经被取消，从后往前找，
                // 直到找到节点状态 <= 0 的前继节点，将当前节点的prev直接指向这个前继节点，前继节点的next指针指向当前节点
                // CAS 将这个前继节点的状态改为 -1
            // parkAndCheckInterrupt 将当前线程挂起，并设置中断标记位为 true
            if (shouldParkAfterFailedAcquire(p, node) &&
                parkAndCheckInterrupt())
                // 
                interrupted = true;
        }
    } finally {
        if (failed)
            cancelAcquire(node);
    }
}



/**
 * Checks and updates status for a node that failed to acquire.
 * Returns true if thread should block. This is the main signal
 * control in all acquire loops.  Requires that pred == node.prev.
 *
 * @param pred node's predecessor holding status
 * @param node the node
 * @return {@code true} if thread should block
 */
//将当前节点挂起，挂起时要判断前继节点的状态
 //1. 前继节点状态为 -1 时，说明当前节点已经被挂起
 //2. 前继节点状态为 1 时，说明前继节点已经被取消，要一直往前找，直到前继节点状态不为 1 的 
 //3. 前继节点状态不为 1 时，当前节点可以把这个节点当作前继节点，通过CAS的方式将前继节点状态改为 -1
//将前继节点改为 -1 是为了告诉前继节点，后面还有等待的节点，当前继节点执行完任务之后，要主动唤醒后继节点
private static boolean shouldParkAfterFailedAcquire(Node pred, Node node) {
    //前继节点的状态
    int ws = pred.waitStatus;
    //前继节点状态为 -1 时，说明当前节点已经被挂起，直接返回true
    if (ws == Node.SIGNAL)
        /*
         * This node has already set status asking a release
         * to signal it, so it can safely park.
         */
        return true;
    //前继节点状态为 1 时
    if (ws > 0) {
        /*
         * Predecessor was cancelled. Skip over predecessors and
         * indicate retry.
         */
        //向前找，直到找到节点状态不等于 1 的节点
        //将当前节点的 prev 指向该节点
        //找到的前继节点的 next 指向当前节点
        do {
        node.prev = pred = pred.prev;
        } while (pred.waitStatus > 0);
        pred.next = node;
    } else {
        /*
         * waitStatus must be 0 or PROPAGATE.  Indicate that we
         * need a signal, but don't park yet.  Caller will need to
         * retry to make sure it cannot acquire before parking.
         */
        //通过CAS的方式将当前线程挂起
        //也就是把前继节点的状态改为 -1
        compareAndSetWaitStatus(pred, ws, Node.SIGNAL);
    }
    return false;
}

```


### 2. 公平锁实现

#### 2.1 lock方法
和非公平实现一样，调用AQS下的 acquire()方法，只是在acquire方法里，tryAcquire()方法分为了公平和非公平,直接看 tryAcquire()方法

```java

final void lock() {
    acquire(1);
}

public final void acquire(int arg) {
    if (!tryAcquire(arg) && acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
        selfInterrupt();
    }

```

#### 2.2 tryAcquire

```java

/**
 * Fair version of tryAcquire.  Don't grant access unless
 * recursive call or no waiters or is first.
 */
protected final boolean tryAcquire(int acquires) {
    //获取当前线程
    final Thread current = Thread.currentThread();
    // 当前state值
    int c = getState();
    //如果 state 等于 0， 说明没有线程持有锁资源
    if (c == 0) {
        
        //hasQueuedPredecessors() 判断AQS队列是否为空或者当前线程是否是排在第一个，如果是返回false
        //如果AQS队列为空或者当前线程AQS队列中第一位，则通过CAS获取资源
        if (!hasQueuedPredecessors() &&
            compareAndSetState(0, acquires)) {
            //获取所资源成功，设置exclusiveOwnerThread 属性为当前线程
            setExclusiveOwnerThread(current);
            return true;
        }
    }
    // state 不等 0，说明有线程持有锁，判断持有锁的线程是否是当前线程
    else if (current == getExclusiveOwnerThread()) {
        //是当前线程，锁重入，state + 1
        int nextc = c + acquires;
        // + 1 之后state 小于0，说明重入次数已经超过 int 的最大值范围，抛出异常
        if (nextc < 0)
            throw new Error("Maximum lock count exceeded");
        // 设置 state
        setState(nextc);
        // 获得锁成功，返回true
        return true;
    }
    return false;
}

```

## unlock方法

释放锁不区分非公平和公平，都是同一套逻辑

```java

/**
 * Attempts to release this lock.
 *
 * <p>If the current thread is the holder of this lock then the hold
 * count is decremented.  If the hold count is now zero then the lock
 * is released.  If the current thread is not the holder of this
 * lock then {@link IllegalMonitorStateException} is thrown.
 *
 * @throws IllegalMonitorStateException if the current thread does not
 *         hold this lock
 */
public void unlock() {
    sync.release(1);
}

```

### 1. release方法

```java

/**
 * Releases in exclusive mode.  Implemented by unblocking one or
 * more threads if {@link #tryRelease} returns true.
 * This method can be used to implement method {@link Lock#unlock}.
 *
 * @param arg the release argument.  This value is conveyed to
 *        {@link #tryRelease} but is otherwise uninterpreted and
 *        can represent anything you like.
 * @return the value returned from {@link #tryRelease}
 */
public final boolean release(int arg) {
    if (tryRelease(arg)) {
        Node h = head;
        if (h != null && h.waitStatus != 0)
            unparkSuccessor(h);
        return true;
    }
    return false;
}

```