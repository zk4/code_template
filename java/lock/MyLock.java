package com.zk;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自己实现锁
 */
public class MyLock implements Lock {
    Helper helper = new Helper();

    private class Helper extends AbstractQueuedSynchronizer {
        /**
         * 独占锁的实现，共享锁使用 tryAcquireShared
         *
         * @param arg
         * @return
         */
        @Override
        protected boolean tryAcquire(int arg) {

            int state = getState();
            if (state == 0) {
                if (compareAndSetState(0, arg)) {
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            }

            return false;
        }

        /**
         * 独占锁的实现 共享锁使用 tryReleaseShared
       *
         * @param arg
         * @return
         */
        @Override
        protected boolean tryRelease(int arg) {
            if (Thread.currentThread() != getExclusiveOwnerThread())
                throw new RuntimeException();
            int state = getState() - arg;
            boolean flag = false;
            if (getState() == 0) {
                setExclusiveOwnerThread(null);
                flag = true;
            }
            setState(state);
            return flag;
        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        helper.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        helper.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return helper.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return helper.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        helper.release(1);
    }

    @Override
    public Condition newCondition() {
        return helper.newCondition();
    }

    public static void main(String[] args) {
        AtomicInteger value = new AtomicInteger(1000);
        MyLock myLock = new MyLock();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    myLock.lock();
                    value.getAndDecrement();

                    System.out.println(value.get());
                    myLock.unlock();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
