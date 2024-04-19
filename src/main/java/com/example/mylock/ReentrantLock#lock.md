# ReentrantLock加锁过程




## lock方法
```java
public void lock() {
    sync.lock();
}
```
内部调用的是 `Sync`下的`lock()`方法，`lock()`是个抽象方法，它有两种实现方式 公平(FairSync)和非公平(NonfairSync)

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
    //1. tryAcquire(arg) 再次尝试一次获取锁资源, 抢锁失败：false，成功：true
    //2. addWaiter(Node.EXCLUSIVE)
    if (!tryAcquire(arg) &&
        acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
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
final boolean acquireQueued(final Node node, int arg) {
    boolean failed = true;
    try {
        boolean interrupted = false;
        for (;;) {
            final Node p = node.predecessor();
            if (p == head && tryAcquire(arg)) {
                setHead(node);
                p.next = null; // help GC
                failed = false;
                return interrupted;
            }
            if (shouldParkAfterFailedAcquire(p, node) &&
                parkAndCheckInterrupt())
                interrupted = true;
        }
    } finally {
        if (failed)
            cancelAcquire(node);
    }
}

```