
public class Q4_MultipleCatchDemo {
    public static void main(String[] args) {
        int[] arr = null;
        try {
            arr = new int[]{10, 20, 30};
            int index = 5;
            System.out.println("Value at index " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}
