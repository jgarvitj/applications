package basicsJava.threads.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Connection.getInstance().connect();
        ExecutorService executorService = Executors.newCachedThreadPool();
        //will immediately acquire 200 connections without semaphore
        for(int i = 0; i< 200; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    Connection.getInstance().connect();
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(50000, TimeUnit.MICROSECONDS);
    }
}
