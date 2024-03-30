package basicsJava.threads.threadpools;

import javafx.scene.SubScene;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {
    private Integer id;
    @Override
    public void run() {
        System.out.println("Starting id:"  + id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ending id:" + id);
    }

    Processor(int i) {
        this.id = i;
    }
}

public class App {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(int i = 0; i < 5; i++) {
            executorService.submit(new Processor(i));
        }
        System.out.println("All tasks submitted");
        try {
            executorService.awaitTermination(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All tasks complete");
    }
}
