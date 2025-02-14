package setinterface.checktwosets;

import java.util.*;

public class CompareSets {
    public static boolean areSetsEqual(Set<Integer> sets1, Set<Integer> sets2) {
        return sets1.containsAll(sets2);
    }

    public static void main(String[] args) {
        Set<Integer> sets1 = new HashSet<>();
        Set<Integer> sets2 = new HashSet<>();

        sets1.add(1);
        sets1.add(2);
        sets1.add(3);
        //  System.out.println(sets1);

        sets2.add(3);
        sets2.add(2);
        sets2.add(1);
        //System.out.println(sets2);

        //  boolean result = sets1.containsAll(sets2);
        System.out.println(areSetsEqual(sets1, sets2));

    }
}