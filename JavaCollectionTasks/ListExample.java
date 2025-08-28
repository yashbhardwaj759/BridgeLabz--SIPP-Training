import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.remove("Banana");
        for (String fruit : list) {
            System.out.println(fruit);
        }
    }
}