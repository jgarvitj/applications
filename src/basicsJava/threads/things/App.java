package basicsJava.threads.things;

import java.util.Random;

public class App {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting..");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();

                for(int i = 0; i < 1E8; i ++) {
                    if(Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted");
                        break;
                    }
                }
            }
        });
        thread.start();
        thread.interrupt();
        thread.join();

        System.out.println("Ending...");
    }
}
