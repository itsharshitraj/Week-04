package dynamiconlinemarketplace;

public class Main {
    public static void main(String[] args) {
        ProductCatalog<Book> bookCatalog = new ProductCatalog<>();
        bookCatalog.addProduct(new Book("Java", 250.31));
        bookCatalog.addProduct(new Book("DSA", 390.10));

        ProductCatalog<Clothing> clothingCatalog = new ProductCatalog<>();
        clothingCatalog.addProduct(new Clothing("T-Shirt", 20.0));
        clothingCatalog.addProduct(new Clothing("Jeans", 35.0));

        ProductCatalog<Gadgets> gadgetCatalog = new ProductCatalog<>();
        gadgetCatalog.addProduct(new Gadgets("Smartphone", 700.0));
        gadgetCatalog.addProduct(new Gadgets("Headphones", 100.0));

        System.out.println("Book Catalog: ");
        bookCatalog.displayProducts();
        System.out.println(" ");

        System.out.println("Clothing Catalog :");
        clothingCatalog.displayProducts();
        System.out.println(" ");

        System.out.println("Gadget Catalog :");
        gadgetCatalog.displayProducts();

        System.out.println(" ");
        // Applying discounts
        ProductCatalog.applyDiscount(new Book("Java Programming", 250.0), 10);
        ProductCatalog.applyDiscount(new Clothing("T-Shirt", 200.0), 5);
        ProductCatalog.applyDiscount(new Gadgets("Smartphone", 7000.0), 15);
    }
}
