package basicsJava.threads.callableAndFuture;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

/*
Callable is of type Runnable -> can return a Future
Future can be used to interupt a thread => use Void with Callable and ? Future
 */
public class App {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                System.out.println("Starting...");
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Ending...");
            }
        });
        executorService.shutdown();

        ExecutorService executorService1 = Executors.newCachedThreadPool();
        Future<Integer> val = executorService1.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                System.out.println("Starting for future executor...");
                int time = random.nextInt(1000);
                if(time > 500) {
                    throw new IOException("Taking 2 long");
                }
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Ending...");
                return time;
            }
        });
        executorService1.shutdown();

        try {
            System.out.println("Result is: " + val.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
