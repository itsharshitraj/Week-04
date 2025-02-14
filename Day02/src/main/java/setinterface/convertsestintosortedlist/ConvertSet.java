package setinterface.convertsestintosortedlist;

import java.util.*;

public class ConvertSet {
    public static List<Integer> convertSetToSortedList(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        return sortedList;
    }

    public static void main(String[] args) {
        Set<Integer> sets = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        System.out.println("Sorted List : " + convertSetToSortedList(sets));

    }
}
