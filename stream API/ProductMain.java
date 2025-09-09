package stream API;

public import java.util.*;
import java.util.stream.*;

class Product {
    int id, price;
    String name, category;

    Product(int id, String name, String category, int price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }
}

public class ProductMain {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1, "Laptop", "Electronics", 800),
                new Product(2, "Phone", "Electronics", 600),
                new Product(3, "Shirt", "Clothing", 40),
                new Product(4, "Jeans", "Clothing", 50));

        Map<String, Double> avgPrice = products.stream()
                .collect(Collectors.groupingBy(p -> p.category,
                        Collectors.averagingInt(p -> p.price)));

        System.out.println(avgPrice);
    }
} {
    
}
