package basicsJava.threads.synchroning;

public class AppSynchronized {

    //make count as AtomicInteger
    //update count in a synchronized method
    private int count = 0;

    public synchronized void incrementCount() {
        count++;
    }

    public static void main(String[] args) {
        AppSynchronized app = new AppSynchronized();
        app.doWork();
    }

    private void doWork() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000; i++) {
                    incrementCount();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000; i++) {
                    incrementCount();
                }
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(count);

    }
}
