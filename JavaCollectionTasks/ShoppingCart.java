import java.util.*;

class Item {
    String name;
    int price;

    Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        List<Item> cart = new ArrayList<>();
        cart.add(new Item("Book", 500));
        cart.add(new Item("Pen", 20));
        int total = 0;
        for (Item item : cart) {
            total += item.price;
        }
        System.out.println("Total Cart Value: " + total);
    }
}