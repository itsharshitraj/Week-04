package listinterface.rotatelistelements;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RotateElement {
    public static void rotateList(List<Integer> list, int positions) {
        int size = list.size();
        positions = positions % size; // Handle cases where positions > size

        Collections.rotate(list, -positions); // Rotates left by `positions`
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2;

        System.out.println("Original List: " + list);
        rotateList(list, rotateBy);
        System.out.println("Rotated List: " + list);
    }
}


