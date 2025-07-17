public class Product {
    // Instance variables
    private String productName;
    private double price;
    // Class variable
    private static int totalProducts = 0;

    public Productsting productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    // Instance method
    public void displayProductDetails() {
        System.out.println("Product Details:");
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
    }

    // Class method
    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }

    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 999.99);
        Product p2 = new Product("Phone", 599.99);
        p1.displayProductDetails();
        p2.displayProductDetails();
        Product.displayTotalProducts();
    }
}