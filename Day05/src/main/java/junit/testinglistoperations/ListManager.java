package junit.testinglistoperations;

import java.util.List;

public class ListManager {

    // Add an element to the list
    public static void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    // Remove an element from the list (if it exists)
    public static boolean removeElement(List<Integer> list, int element) {
        return list.remove(Integer.valueOf(element));
    }

    // Get the size of the list
    public static int getSize(List<Integer> list) {
        return list.size();
    }
}
