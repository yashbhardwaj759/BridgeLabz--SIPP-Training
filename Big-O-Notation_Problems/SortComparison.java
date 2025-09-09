import java.util.Arrays;
import java.util.Random;

public class SortComparison {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap pivot
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Generate random array
    public static int[] generateArray(int n, int bound) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = rand.nextInt(bound);
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};

        for (int size : sizes) {
            System.out.println("Dataset size: " + size);

            int[] original = generateArray(size, size * 2);

            // Bubble Sort (only for small datasets)
            if (size <= 10000) {
                int[] bubbleData = Arrays.copyOf(original, original.length);
                long startBubble = System.nanoTime();
                bubbleSort(bubbleData);
                long endBubble = System.nanoTime();
                System.out.println("Bubble Sort Time: " + (endBubble - startBubble) / 1_000_000.0 + " ms");
            } else {
                System.out.println("Bubble Sort Time: Unfeasible");
            }

            // Merge Sort
            int[] mergeData = Arrays.copyOf(original, original.length);
            long startMerge = System.nanoTime();
            mergeSort(mergeData);
            long endMerge = System.nanoTime();
            System.out.println("Merge Sort Time: " + (endMerge - startMerge) / 1_000_000.0 + " ms");

            // Quick Sort
            int[] quickData = Arrays.copyOf(original, original.length);
            long startQuick = System.nanoTime();
            quickSort(quickData, 0, quickData.length - 1);
            long endQuick = System.nanoTime();
            System.out.println("Quick Sort Time: " + (endQuick - startQuick) / 1_000_000.0 + " ms");

            System.out.println("-----------");
        }
    }
}