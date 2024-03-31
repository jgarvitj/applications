package basicsJava.threads.deallock;

import java.util.Locale;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

    private Account acc1 = new Account();
    private Account acc2 = new Account();
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    Random random = new Random();

    private void acquireLocks(Lock firstLock, Lock secondLock) throws InterruptedException {
        boolean gotFirstLock = false;
        boolean gotSecondLock = false;
        while (true) {
            try {
                lock2.tryLock();
                lock1.tryLock();
            } finally {
                if(gotFirstLock && gotSecondLock) {
                    return;
                }
                if(gotFirstLock) {
                    firstLock.unlock();
                }
                if(gotSecondLock) {
                    secondLock.unlock();
                }
            }
            Thread.sleep(1000);
        }
    }

    public void firstThread() throws InterruptedException {
        for(int i = 0; i < 10000; i++) {
//            lock1.lock();
//            lock2.lock();
            acquireLocks(lock1, lock2);
            try {
                Account.transfer(acc1, acc2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() throws InterruptedException {
        for(int i = 0; i < 10000; i++) {
//            lock2.lock();
//            lock1.lock();
            acquireLocks(lock1, lock2);
            try {
                Account.transfer(acc2, acc1, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {
        System.out.println("A1 balance " + acc1.getBalance());
        System.out.println("A2 balance " + acc2.getBalance());
        System.out.println("Total balance " + (acc1.getBalance() + acc2.getBalance()));

    }
}
