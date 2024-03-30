package basicsJava.threads.queue;

public class WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        PubSub pubSub = new PubSub();
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
