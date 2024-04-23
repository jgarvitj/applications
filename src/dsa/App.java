package dsa;

public class App {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,2,3,3,39};
        System.out.println(findCount(arr, 2));
    }

    private static int findCount(int[] arr, int x) {
        int count = 0;
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int lowIndex = 0;
        int highIndex = n-1;
        //finding the max index where val < x
        //1,1,1,2,2,3,3,3 | x = 2
        while(low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        lowIndex = low;
        high = n-1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        highIndex = high;
        count  = highIndex - lowIndex + 1;
        return count;
    }
}
