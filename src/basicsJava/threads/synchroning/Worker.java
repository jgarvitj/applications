package basicsJava.threads.synchroning;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {

    private Random random = new Random();
    private List<Integer> l1 = new ArrayList<>();
    private List<Integer> l2 = new ArrayList<>();

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void stageOne() {

        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            l1.add(random.nextInt(100));
        }
    }

    public void stageTwo() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            l2.add(random.nextInt(100));
        }
    }

    public void process() {
        for(int i =0 ; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("start" + start);
        Worker worker = new Worker();
//        worker.process();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                worker.process();
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                worker.process();
            }
        });
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("end" + end + "time taken: " + (end - start));
        System.out.println("list1" + worker.l1.size() + "list2" + worker.l2.size());
    }
}
