package basicsJava.threads.queue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                producer();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                consumer();
            }
        });
        t2.start();
        Thread.sleep(3000);
        t1.start();

        t1.join();
        t2.join();
    }

    public static void producer() {
        Random random = new Random();
        while (true) {
            try {
                queue.put(random.nextInt());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void consumer() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(100);
                if(random.nextInt(2) == 0) {
                    Integer val = queue.take();

                    System.out.println("Taken value: " + val + "Queue remaining size is: " + queue.size());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
