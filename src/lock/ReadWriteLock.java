package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {

    private int count = 0;

    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    public void increment() {
        writeLock.lock();
        try {
            count++;
            System.out.println(Thread.currentThread().getName() +
                    " incremented count to: " + count);
        } finally {
            writeLock.unlock();
        }
    }

    public int getCount() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() +
                    " read count: " + count);
            return count;
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {

        ReadWriteLock rwLockExample = new ReadWriteLock();

        Runnable reader = () -> {
            for (int i = 0; i < 10; i++) {
                rwLockExample.getCount();
            }
        };

        Runnable writer = () -> {
            for (int i = 0; i < 5; i++) {
                rwLockExample.increment();
            }
        };

        Thread t1 = new Thread(reader, "Reader-1");
        Thread t2 = new Thread(reader, "Reader-2");
        Thread t3 = new Thread(writer, "Writer-1");

        t1.start();
        t2.start();
        t3.start();
    }
}
