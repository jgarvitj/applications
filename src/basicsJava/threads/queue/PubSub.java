package basicsJava.threads.queue;

import java.util.Scanner;

public class PubSub {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread running...");
            wait();
            System.out.println("Resumed");
        }
    }

    public void consume() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Thread. sleep(1000);

        synchronized (this) {
            System.out.println("waiting for return key..");
            sc.nextLine();
            System.out.println("return pressed");
            notify();

        }
    }
}
