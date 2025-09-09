import java.util.*;
import java.util.stream.Collectors;

// Product class representing an e-commerce product
class Product {
    private String name;
    private double price;
    private double rating;
    private double discountPercentage;
    private int salesCount;
    
    public Product(String name, double price, double rating, double discountPercentage, int salesCount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discountPercentage = discountPercentage;
        this.salesCount = salesCount;
    }
    
    // Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public double getRating() { return rating; }
    public double getDiscountPercentage() { return discountPercentage; }
    public int getSalesCount() { return salesCount; }
    
    public double getDiscountedPrice() {
        return price * (1 - discountPercentage / 100);
    }
    
    @Override
    public String toString() {
        return String.format("%-15s | Price: $%-6.2f | Rating: %.1f⭐ | Discount: %4.1f%% | Sales: %d",
                name, price, rating, discountPercentage, salesCount);
    }
}

// E-commerce store class
class EcommerceStore {
    private List<Product> products;
    
    public EcommerceStore() {
        products = new ArrayList<>();
        initializeProducts();
    }
    
    private void initializeProducts() {
        products.add(new Product("Laptop", 999.99, 4.5, 15.0, 120));
        products.add(new Product("Smartphone", 699.99, 4.8, 20.0, 350));
        products.add(new Product("Headphones", 149.99, 4.2, 10.0, 200));
        products.add(new Product("Tablet", 399.99, 4.3, 25.0, 80));
        products.add(new Product("Smartwatch", 249.99, 4.6, 30.0, 150));
        products.add(new Product("Camera", 799.99, 4.7, 5.0, 45));
        products.add(new Product("Speaker", 89.99, 4.1, 15.0, 180));
        products.add(new Product("Monitor", 299.99, 4.4, 20.0, 95));
    }
    
    public void displayProducts(String sortType) {
        System.out.println("\n=== Products sorted by: " + sortType + " ===");
        System.out.println("-".repeat(70));
        products.forEach(System.out::println);
    }
    
    // Method to sort products using lambda expressions
    public void sortProducts(String criteria) {
        switch (criteria.toLowerCase()) {
            case "price":
                products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
                displayProducts("Price (Low to High)");
                break;
                
            case "price_desc":
                products.sort((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));
                displayProducts("Price (High to Low)");
                break;
                
            case "rating":
                products.sort((p1, p2) -> Double.compare(p2.getRating(), p1.getRating()));
                displayProducts("Rating (High to Low)");
                break;
                
            case "discount":
                products.sort((p1, p2) -> Double.compare(p2.getDiscountPercentage(), p1.getDiscountPercentage()));
                displayProducts("Discount (High to Low)");
                break;
                
            case "sales":
                products.sort((p1, p2) -> Integer.compare(p2.getSalesCount(), p1.getSalesCount()));
                displayProducts("Sales (High to Low)");
                break;
                
            case "value":
                products.sort((p1, p2) -> Double.compare(p2.getDiscountedPrice(), p1.getDiscountedPrice()));
                displayProducts("Discounted Price (High to Low)");
                break;
                
            default:
                System.out.println("Unknown sorting criteria: " + criteria);
        }
    }
    
    // Advanced filtering and sorting with lambdas
    public void filterAndSort(String filterType, String sortCriteria) {
        List<Product> filteredProducts = new ArrayList<>(products);
        
        // Apply filters
        switch (filterType.toLowerCase()) {
            case "high_rated":
                filteredProducts = products.stream()
                    .filter(p -> p.getRating() >= 4.5)
                    .collect(Collectors.toList());
                break;
                
            case "on_sale":
                filteredProducts = products.stream()
                    .filter(p -> p.getDiscountPercentage() > 0)
                    .collect(Collectors.toList());
                break;
                
            case "budget":
                filteredProducts = products.stream()
                    .filter(p -> p.getPrice() <= 300)
                    .collect(Collectors.toList());
                break;
        }
        
        // Apply sorting
        switch (sortCriteria.toLowerCase()) {
            case "price":
                filteredProducts.sort(Comparator.comparingDouble(Product::getPrice));
                break;
            case "rating":
                filteredProducts.sort(Comparator.comparingDouble(Product::getRating).reversed());
                break;
            case "discount":
                filteredProducts.sort(Comparator.comparingDouble(Product::getDiscountPercentage).reversed());
                break;
        }
        
        System.out.println("\n=== Filtered by: " + filterType + " | Sorted by: " + sortCriteria + " ===");
        System.out.println("-".repeat(70));
        filteredProducts.forEach(System.out::println);
    }
    
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
}

public class CustomSortingEcommerce {
    public static void main(String[] args) {
        EcommerceStore store = new EcommerceStore();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== E-commerce Custom Sorting System ===\n");
        
        // Demonstrate different sorting options
        System.out.println("--- Basic Sorting Examples ---");
        store.sortProducts("price");
        store.sortProducts("rating");
        store.sortProducts("discount");
        
        System.out.println("\n--- Advanced Filtering and Sorting ---");
        store.filterAndSort("high_rated", "price");
        store.filterAndSort("on_sale", "discount");
        
        // Interactive mode
        System.out.println("\n--- Interactive Mode ---");
        System.out.println("Available sorting: price, price_desc, rating, discount, sales, value");
        System.out.println("Available filters: high_rated, on_sale, budget");
        
        while (true) {
            System.out.print("\nEnter sort type (or 'quit' to exit): ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("quit")) break;
            
            if (input.contains(" ")) {
                String[] parts = input.split(" ");
                if (parts.length == 2) {
                    store.filterAndSort(parts[0], parts[1]);
                }
            } else {
                store.sortProducts(input);
            }
        }
        
        scanner.close();
        System.out.println("Thank you for using our e-commerce sorter!");
    }
}