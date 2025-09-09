public class FibonacciComparison {

    // Recursive Fibonacci - Exponential Time O(2^n)
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci - Linear Time O(n)
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] testCases = {10, 30, 50};

        for (int n : testCases) {
            System.out.println("Fibonacci(" + n + ")");

            // Iterative
            long startIter = System.nanoTime();
            int fibIter = fibonacciIterative(n);
            long endIter = System.nanoTime();
            System.out.println("Iterative Result: " + fibIter);
            System.out.println("Iterative Time: " + (endIter - startIter) / 1_000_000.0 + " ms");

            // Recursive (only attempt for n <= 30)
            if (n <= 30) {
                long startRec = System.nanoTime();
                int fibRec = fibonacciRecursive(n);
                long endRec = System.nanoTime();
                System.out.println("Recursive Result: " + fibRec);
                System.out.println("Recursive Time: " + (endRec - startRec) / 1_000_000.0 + " ms");
            } else {
                System.out.println("Recursive Result: Skipped (Too Slow)");
            }

            System.out.println("-----------");
        }
    }
}