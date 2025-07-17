import java.util.Scanner;
import java.time.LocalDate;

/**
 * Demonstrates aggregation (Order-Product) and association (Customer-Order).
 * Integrates cab service-like billing with invoice generation.
 */
public class ECommercePlatform {
    static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        public String getDetails() {
            return "Product: " + name + ", Price: $" + price;
        }
    }

    static class Customer {
        private String customerId;
        private Order[] orders;
        private int orderCount;
        private static final int MAX_ORDERS = 50;

        public Customer(String customerId) {
            this.customerId = customerId;
            this.orders = new Order[MAX_ORDERS];
            this.orderCount = 0;
        }

        public void placeOrder(Order order) {
            if (orderCount >= MAX_ORDERS) {
                throw new IllegalStateException("Cannot place more orders");
            }
            orders[orderCount++] = order;
        }

        public String viewOrders() {
            StringBuilder sb = new StringBuilder("Customer ID: " + customerId + "\nOrders:\n");
            for (int i = 0; i < orderCount; i++) {
                sb.append(orders[i].enhanceInvoice()).append("\n");
            }
            return sb.toString();
        }
    }

    static class Order {
        private static final double BONUS_THRESHOLD = 5;
        private static final double BONUS_DISCOUNT = 0.1;
        private Product[] products;
        private int productCount;
        private LocalDate date;
        private static final int MAX_PRODUCTS = 20;

        public Order(LocalDate date) {
            this.date = date;
            this.products = new Product[MAX_PRODUCTS];
            this.productCount = 0;
        }

        public void addProduct(Product product) {
            if (productCount >= MAX_PRODUCTS) {
                throw new IllegalStateException("Order is full");
            }
            products[productCount++] = product;
        }

        public String enhanceInvoice() {
            StringBuilder sb = new StringBuilder("Order Date: " + date + "\n");
            double total = 0.0;
            for (int i = 0; i < productCount; i++) {
                sb.append(products[i].getDetails()).append("\n");
                total += products[i].getPrice();
            }
            sb.append("Subtotal: $").append(String.format("%.2f", total)).append("\n");
            double finalTotal = productCount >= BONUS_THRESHOLD ? total * (1 - BONUS_DISCOUNT) : total;
            sb.append("After Bonus: $").append(String.format("%.2f", finalTotal));
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();
        Customer customer = new Customer(customerId);

        System.out.print("Enter number of orders: ");
        int numOrders = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numOrders; i++) {
            System.out.print("Enter order date (YYYY-MM-DD): ");
            LocalDate date = LocalDate.parse(scanner.nextLine());
            Order order = new Order(date);

            System.out.print("Enter number of products: ");
            int numProducts = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < numProducts; j++) {
                System.out.print("Enter product name: ");
                String name = scanner.nextLine();
                System.out.print("Enter product price: ");
                double price = scanner.nextDouble();
                scanner.nextLine();
                order.addProduct(new Product(name, price));
            }
            customer.placeOrder(order);
        }

        System.out.println(customer.viewOrders());
        scanner.close();
    }
}