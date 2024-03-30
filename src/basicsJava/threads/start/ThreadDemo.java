package basicsJava.threads.start;

class Runner extends Thread {
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("Helli" + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.start();

        Runner runner1 = new Runner();
        runner1.start();
    }
}
