package basicsJava.threads.semaphore;

import java.util.concurrent.Semaphore;

public class Connection {
    private static Connection instance = new Connection();
    private int connectionCount = 0;
    private Semaphore semaphore = new Semaphore(10);
    private Connection() {

    }

    public static Connection getInstance() {
        return instance;
    }

    public void connect() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            doConnect();
        } finally {
            semaphore.release();
        }
    }

    public void doConnect() {

        synchronized (this) {
            connectionCount++;
            System.out.println("Current connections:" + connectionCount);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (this) {
            connectionCount--;
            System.out.println("Current connections:" + connectionCount);
        }

    }
}
