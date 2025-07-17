public class Product {
    // Static variable
    private static double discount = 10.0; // Percentage
    private static int totalProducts = 0;

    // Instance variables
    private String productName;
    private double price;
    private int quantity;
    private final String productID;

    // Constructor using this
    public Product(String productName, double price, int quantity, String productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
        totalProducts++;
    }

    // Static method
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Discount updated to: " + discount + "%");
    }

    // Instance method with instanceof check
    public void displayDetails(Object obj) {
        if (obj instanceof Product) {
            Product product = (Product) obj;
            double discountedPrice = product.price * (1 - discount / 100);
            System.out.println("Product Details:");
            System.out.println("Product ID: " + product.productID);
            System.out.println("Name: " + product.productName);
            System.out.println("Price: $" + product.price);
            System.out.println("Quantity: " + product.quantity);
            System.out.println("Discounted Price: $" + discountedPrice);
            System.out.println("Total Cost: $" + (discountedPrice * product.quantity));
        } else {
            System.out.println("Invalid object: Not a Product instance");
        }
    }

    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 1000.0, 2, "PID001");
        Product p2 = new Product("Phone", 500.0, 1, "PID002");
        p1.displayDetails(p1);
        Product.updateDiscount(15.0);
        p2.displayDetails(p2);
        p1.displayDetails(new String("Invalid"));
    }
}