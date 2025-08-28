
public class Q9_NestedTryCatchDemo {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        int index = 5;
        int divisor = 0;
        try {
            try {
                int value = arr[index];
                System.out.println("Accessed value: " + value);
                System.out.println("Result: " + (value / divisor));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        }
    }
}
