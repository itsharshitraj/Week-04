package annotations.exercise;
import java.util.ArrayList;
public class Exercise3 {
    @SuppressWarnings("unchecked") // Suppresses unchecked warnings
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        // Adding elements of different types
        list.add("Hello");
        list.add(123);
        list.add(45.6);

        System.out.println("List elements: " + list);
    }
}
