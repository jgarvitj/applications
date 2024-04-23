package project;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 5000; i++) {
            list.add(i);
        }
        long start1 = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Integer>> partSum = divideAndConquer(list,executor);
        int sum = 0;
        for(Future<Integer> part : partSum) {
            sum += part.get();
        }

//        int sum1 = SlowAPI.getSum(list);
        System.out.println("Executed in : "+(System.currentTimeMillis()-start1) + ", sum is : " + sum);
    }

    /* divideAndC(list)
        if size <= 2000
            new thread find the sum and return
        else
            return dAc(left half of list) + dAc(right half)
      */

    private static List<Future<Integer>> divideAndConquer(List<Integer> intList, ExecutorService executorService) {
        List<Future<Integer>> partSum = new ArrayList<Future<Integer>>();
        if(intList.size() <= 2000) {
            Future<Integer> val = executorService.submit(new Callable<Integer>(){
                @Override
                public Integer call() throws Exception {
                    return SlowAPI.getSum(intList);
                }

            });
            partSum.add(val);
        } else {
            partSum.addAll(divideAndConquer(intList.subList(0, intList.size()/2), executorService));
            partSum.addAll(divideAndConquer(intList.subList(intList.size()/2, intList.size()), executorService));
        }

        return partSum;
    }
}
