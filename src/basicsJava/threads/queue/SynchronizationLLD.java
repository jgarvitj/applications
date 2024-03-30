package basicsJava.threads.queue;

public class SynchronizationLLD {
    public static void main(String[] args) throws InterruptedException {
        Producer pubSub = new Producer();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pubSub.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pubSub.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}
