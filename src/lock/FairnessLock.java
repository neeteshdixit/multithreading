package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessLock {
    private Lock fairLock = new ReentrantLock(true);

    public void accessResource() {
        fairLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock.");
            // Simulate some work with the resource
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " releasing the lock.");
            fairLock.unlock();
        }
    }
}
