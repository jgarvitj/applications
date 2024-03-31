package basicsJava.threads.reEntrantLocks;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

    public int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() {
        for(int i  =0; i < 10000; i++) {
            count++;
        }
    }

    public void firstThread() throws InterruptedException {
        lock.lock();
        System.out.println("Waiting...");
        condition.await();
        System.out.println("Up...");
        try {
            increment();
        } finally {
            lock.unlock();
        }
        //if increment fails then lock is never unlocked, so added finally

    }
    public void secondThread() throws InterruptedException {
        lock.lock();
        Thread.sleep(2000);
        System.out.println("Press return");
        new Scanner(System.in).nextLine();
        System.out.println("Return pressed");

        condition.signal();
        try {
            increment();
        } finally {
            lock.unlock();
        }
    }
    public void finsihed() {
        System.out.println("Final count: " + count);
    }
}
