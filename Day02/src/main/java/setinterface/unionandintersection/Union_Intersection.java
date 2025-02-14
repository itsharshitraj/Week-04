package setinterface.unionandintersection;

import java.util.*;

public class Union_Intersection {
    public static Set<Integer> Union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    public static Set<Integer> Intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3,4,5));


        System.out.println("Union : " + Union(set1, set2));
        System.out.println("Intersection : " + Intersection(set1, set2));
    }
}
