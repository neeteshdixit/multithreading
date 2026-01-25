package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Reentrentlock {
    private final Lock lock = new ReentrantLock();

    public void outerMethod(){
        lock.lock();
        try {
            System.out.println("In outer method");
            innerMethod();
        } finally {
            lock.unlock();
        }
    }
    public void innerMethod(){
        lock.lock();
        try {
            System.out.println("In inner method");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Reentrentlock reentrantLockExample = new Reentrentlock();
        reentrantLockExample.outerMethod();
    }
}
