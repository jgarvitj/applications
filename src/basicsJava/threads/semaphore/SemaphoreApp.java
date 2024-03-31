package basicsJava.threads.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreApp {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        semaphore.acquire();
        semaphore.release();
        System.out.println("Available permits " + semaphore.availablePermits());

    }
}
