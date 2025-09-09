import java.util.Arrays;
import java.util.Random;

public class SearchComparison {

    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // Binary Search (requires sorted array)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Generate random array of size n
    public static int[] generateArray(int n, int bound) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = rand.nextInt(bound);
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};

        for (int size : sizes) {
            int[] data = generateArray(size, size * 2);
            int target = data[size / 2]; // Pick a middle element as target

            // Linear Search
            long startLinear = System.nanoTime();
            linearSearch(data, target);
            long endLinear = System.nanoTime();

            // Binary Search
            Arrays.sort(data); // Must sort before binary search
            long startBinary = System.nanoTime();
            binarySearch(data, target);
            long endBinary = System.nanoTime();

            System.out.println("Dataset size: " + size);
            System.out.println("Linear Search Time: " + (endLinear - startLinear) / 1_000_000.0 + " ms");
            System.out.println("Binary Search Time: " + (endBinary - startBinary) / 1_000_000.0 + " ms");
            System.out.println("-----------");
        }
    }
}