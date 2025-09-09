import java.util.*;
import java.util.stream.*;

class Order {
    int id, amount;
    String customer;

    Order(int id, String customer, int amount) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }
}

public class CustomerPurchase {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order(1, "Alice", 250),
                new Order(2, "Bob", 150),
                new Order(3, "Alice", 100),
                new Order(4, "Charlie", 300));

        Map<String, Integer> totalSpent = orders.stream()
                .collect(Collectors.groupingBy(o -> o.customer,
                        Collectors.summingInt(o -> o.amount)));

        System.out.println(totalSpent);
    }
}