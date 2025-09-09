package JavaCollectors;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderRevenueSummary {

    static class Order {
        String customerId;
        double totalAmount;

        public Order(String customerId, double totalAmount) {
            this.customerId = customerId;
            this.totalAmount = totalAmount;
        }

        public String getCustomerId() {
            return customerId;
        }

        public double getTotalAmount() {
            return totalAmount;
        }

        @Override
        public String toString() {
            return "Order{customerId='" + customerId + "', totalAmount=" + totalAmount + "}";
        }
    }

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("CUST001", 150.75),
                new Order("CUST002", 200.00),
                new Order("CUST001", 50.25),
                new Order("CUST003", 300.50),
                new Order("CUST002", 75.00)
        );

        // Sum order totals per customer using Collectors.groupingBy and Collectors.summingDouble
        Map<String, Double> revenueByCustomer = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomerId,
                        Collectors.summingDouble(Order::getTotalAmount)
                ));

        System.out.println("Total revenue per customer:");
        revenueByCustomer.forEach((customerId, totalRevenue) ->
                System.out.println(customerId + ": " + String.format("%.2f", totalRevenue))
        );
    }
}