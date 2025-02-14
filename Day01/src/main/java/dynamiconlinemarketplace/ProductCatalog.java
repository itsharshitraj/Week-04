package dynamiconlinemarketplace;

import java.util.ArrayList;
import java.util.List;

class ProductCatalog<T extends Product> {
    private List<T> products = new ArrayList<>();

    public void addProduct(T product) {
        products.add(product);
    }

    public void displayProducts() {
        for (T product : products) {
            System.out.println(product);
        }
    }

    // Discount methods
    public static <T extends Product> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
        System.out.println("Discount: " + product.getName() + " updated price : $ " + product.getPrice());
    }
}
