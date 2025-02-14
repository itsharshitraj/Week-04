package shoppingcartsystem;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding products
        cart.addProduct("Laptop", 1200.00);
        cart.addProduct("Mouse", 25.50);
        cart.addProduct("Keyboard", 45.00);
        cart.addProduct("Monitor", 300.00);

        // Display cart in order of addition
        cart.displayCartInOrder();

        // Display cart sorted by price
        cart.displayCartSortedByPrice();

        // Display total cost
        cart.displayTotalCost();
    }
}


