package basicsJava.threads.synchroning;

import java.util.Scanner;

class Processor extends Thread {

    private volatile boolean running = true;
    public void run() {
        while (running) {
            System.out.println("hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void shutdown() {
        this.running = false;
    }
}
public class App {
    public static void main(String[] args) {
        Processor pr1 = new Processor();
        pr1.start();

        System.out.println("print enter to shut down...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        pr1.shutdown();
    }

}
