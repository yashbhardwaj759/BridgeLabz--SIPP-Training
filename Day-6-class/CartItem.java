public class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public void addItem(int qty) {
        if (qty > 0) {
            quantity += qty;
            System.out.println(qty + " " + itemName + "(s) added to cart");
        }
    }

    public void removeItem(int qty) {
        if (qty > 0 && quantity >= qty) {
            quantity -= qty;
            System.out.println(qty + " " + itemName + "(s) removed from cart");
        } else {
            System.out.println("Invalid quantity to remove");
        }
    }

    public double calculateTotalCost() {
        return price * quantity;
    }

    public void displayDetails() {
        System.out.println("Cart Item Details:");
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: $" + calculateTotalCost());
    }

    public static void main(String[] args) {
        CartItem item = new CartItem("Book", 29.99, 1);
        item.addItem(2);
        item.displayDetails();
        item.removeItem(1);
        item.displayDetails();
    }
}