package listinterface.removeduplicates;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DuplicateRemoval {
    public static Set<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> duplicates = new LinkedHashSet<>();
        for (Integer number : list) {
            duplicates.add(number);
        }
        return duplicates;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1, 2, 2, 3, 4);
        Set<Integer> results = removeDuplicates(list);
        System.out.println("After Removal:" + results);
    }
}


