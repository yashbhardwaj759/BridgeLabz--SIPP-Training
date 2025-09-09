
public class StringConcatPerformance {

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};

        for (int n : sizes) {
            System.out.println("Concatenation Count: " + n);

            // String (Immutable)
            long startString = System.nanoTime();
            String s = "";
            for (int i = 0; i < n; i++) {
                s += "a";
            }
            long endString = System.nanoTime();
            System.out.println("String Time: " + (endString - startString) / 1_000_000.0 + " ms");

            // StringBuilder (Mutable, Fast)
            long startBuilder = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
            long endBuilder = System.nanoTime();
            System.out.println("StringBuilder Time: " + (endBuilder - startBuilder) / 1_000_000.0 + " ms");

            // StringBuffer (Thread-safe)
            long startBuffer = System.nanoTime();
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < n; i++) {
                sbf.append("a");
            }
            long endBuffer = System.nanoTime();
            System.out.println("StringBuffer Time: " + (endBuffer - startBuffer) / 1_000_000.0 + " ms");

            System.out.println("-----------");
        }
    }
}
