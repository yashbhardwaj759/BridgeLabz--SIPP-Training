import java.util.Scanner;

/**
 * Implements the Grocery Store Bill Generation Application with composition between Customer and Product.
 * Demonstrates Class Diagram (structure), Object Diagram (snapshot), and Sequence Diagram (interaction).
 * Integrates cab service methods: calculateFare (calculateBill), enhanceInvoice, invoiceService, multipleRides (addProducts), bonus.
 * Adheres to UML best practices: clear naming, focused classes, proper relationships.
 * Guideline #1: Uses composition instead of inheritance.
 * Guideline #7: Private fields with getters.
 */
public class GroceryStoreBillApplication {
    /**
     * Represents a product, analogous to a ride in the cab service.
     */
    static class Product {
        private String name;
        private double pricePerUnit;
        private double quantity;

        public Product(String name, double pricePerUnit, double quantity) {
            this.name = name;
            this.pricePerUnit = pricePerUnit;
            this.quantity = quantity;
        }

        public double calculateCost() {
            return pricePerUnit * quantity;
        }

        public String getDetails() {
            return "Product: " + name + ", Quantity: " + quantity + ", Price: $" + pricePerUnit;
        }

        public double getPricePerUnit() {
            return pricePerUnit;
        }

        public double getQuantity() {
            return quantity;
        }
    }

    /**
     * Customer owns Product objects (composition relationship).
     * Methods like addProducts are analogous to multipleRides.
     */
    static class Customer {
        private String name;
        private Product[] products;
        private int productCount;
        private static final int MAX_PRODUCTS = 20;

        public Customer(String name) {
            this.name = name;
            this.products = new Product[MAX_PRODUCTS];
            this.productCount = 0;
        }

        public void addProducts(Scanner scanner) {
            System.out.print("Enter number of products for " + name + ": ");
            int numProducts = scanner.nextInt();
            scanner.nextLine();
            if (productCount + numProducts > MAX_PRODUCTS) {
                throw new IllegalStateException("Cannot add more products");
            }

            for (int i = 0; i < numProducts; i++) {
                System.out.print("Enter product name: ");
                String name = scanner.nextLine();
                System.out.print("Enter price per unit: ");
                double price = scanner.nextDouble();
                System.out.print("Enter quantity: ");
                double quantity = scanner.nextDouble();
                scanner.nextLine();
                products[productCount++] = new Product(name, price, quantity);
            }
        }

        public String getDetails() {
            StringBuilder sb = new StringBuilder("Customer: " + name + "\nProducts:\n");
            for (int i = 0; i < productCount; i++) {
                sb.append(products[i].getDetails()).append("\n");
            }
            return sb.toString();
        }

        public Product[] getProducts() {
            return products;
        }

        public int getProductCount() {
            return productCount;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * Generates bills, analogous to invoiceService in cab service.
     * Includes bonus logic (10% discount for 3+ products).
     */
    static class BillGenerator {
        private static final double BONUS_THRESHOLD = 3;
        private static final double BONUS_DISCOUNT = 0.1;

        public String calculateBill(Customer customer) {
            double total = 0.0;
            Product[] products = customer.getProducts();
            int productCount = customer.getProductCount();

            // Sequence: Iterate through products to calculate total
            for (int i = 0; i < productCount; i++) {
                total += products[i].calculateCost();
            }

            // Apply bonus, analogous to cab service bonus
            double finalTotal = productCount >= BONUS_THRESHOLD ? total * (1 - BONUS_DISCOUNT) : total;

            // Enhanced invoice, analogous to enhanceInvoice
            StringBuilder invoice = new StringBuilder("Bill for " + customer.getName() + "\n");
            invoice.append("----------------------------------------\n");
            invoice.append(String.format("%-15s %-10s %-10s %-12s\n", 
                "Product", "Price/Unit", "Quantity", "Total"));
            invoice.append("----------------------------------------\n");
            for (int i = 0; i < productCount; i++) {
                Product p = products[i];
                invoice.append(String.format("%-15s $%-9.2f %-10.2f $%-11.2f\n",
                    p.getName(), p.getPricePerUnit(), p.getQuantity(), p.calculateCost()));
            }
            invoice.append("----------------------------------------\n");
            invoice.append(String.format("Subtotal: $%.2f\n", total));
            invoice.append(String.format("After Bonus: $%.2f\n", finalTotal));
            return invoice.toString();
        }

        public String invoiceService(Customer customer) {
            double total = 0.0;
            Product[] products = customer.getProducts();
            int productCount = customer.getProductCount();

            for (int i = 0; i < productCount; i++) {
                total += products[i].calculateCost();
            }

            double finalTotal = productCount >= BONUS_THRESHOLD ? total * (1 - BONUS_DISCOUNT) : total;

            StringBuilder invoice = new StringBuilder("Final Bill for " + customer.getName() + "\n");
            invoice.append("Total Items: ").append(productCount).append("\n");
            invoice.append("Total: $").append(String.format("%.2f", total)).append("\n");
            invoice.append("Final Amount Due: $").append(String.format("%.2f", finalTotal)).append("\n");
            return invoice.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Object Diagram Snapshot: Alice with Apples and Milk
        Customer alice = new Customer("Alice");
        alice.addProducts(scanner); // User inputs products (e.g., Apples: $3/kg, 2kg; Milk: $2/liter, 1 liter)

        // Sequence Diagram: Generate bill
        BillGenerator billGenerator = new BillGenerator();
        System.out.println(alice.getDetails()); // Snapshot of objects
        System.out.println(billGenerator.calculateBill(alice)); // Enhanced invoice
        System.out.println(billGenerator.invoiceService(alice)); // Final invoice

        scanner.close();
    }
}