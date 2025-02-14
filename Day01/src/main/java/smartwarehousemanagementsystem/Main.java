package smartwarehousemanagementsystem;

public class Main {
    public static void main(String[] args) {

        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Smartphone", 75000));
        electronicsStorage.addItem(new Electronics("Laptop", 90000));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Rice", 350));
        groceriesStorage.addItem(new Groceries("Milk", 60));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Table", 1670.5));
        furnitureStorage.addItem(new Furniture("Chair", 250.25));


        System.out.println("Electronics:");
        electronicsStorage.displayItems();

        System.out.println("Groceries:");
        groceriesStorage.displayItems();

        System.out.println("Furniture:");
        furnitureStorage.displayItems();
    }
}
