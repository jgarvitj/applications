package project;

import java.util.List;

public  class SlowAPI {
    /**
     * Don't change this method.
     */
    public static int getSum(List<Integer> value) {
        int sum=0;
        for(int i: value){
            sum+=i;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return sum;
    }
}