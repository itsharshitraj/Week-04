package shoppingcartsystem;

import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private Map<String, Double> cart = new LinkedHashMap<>();

    // Add product to cart
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        cart.put(product, price);
    }

    // Display cart in order of addition
    public void displayCartInOrder() {
        System.out.println("\nShopping Cart (Order of Addition):");
        for (var entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " - $" + entry.getValue());
        }
    }

    // Display items sorted by price
    public void displayCartSortedByPrice() {
        TreeMap<Double, List<String>> sortedCart = new TreeMap<>();

        for (var entry : cart.entrySet()) {
            sortedCart.putIfAbsent(entry.getValue(), new ArrayList<>());
            sortedCart.get(entry.getValue()).add(entry.getKey());
        }

        System.out.println("\nShopping Cart (Sorted by Price):");
        for (var entry : sortedCart.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + " - $" + entry.getKey());
            }
        }
    }

    // Calculate total cost
    public void displayTotalCost() {
        double total = cart.values().stream().mapToDouble(Double::doubleValue).sum();
        System.out.println("\nTotal Cost: $" + total);
    }
}

