package smartwarehousemanagementsystem;

import java.util.ArrayList;
import java.util.List;

// Generic class
public class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    // wildcard method to display all items in storage
    public static void displayItems(List<? extends WarehouseItem> items) {
        System.out.println("Warehouse Items:");
        for (WarehouseItem item : items) {
            System.out.println(item.getName());
            System.out.println(item.getPrice());
        }
    }

    public void displayItems() {
        displayItems(items);
    }
}
