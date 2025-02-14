package mapinterface.findhighestvaluekey;

import java.util.Map;
import java.util.HashMap;

public class FindKey {
    public static String findMaxKey(Map<String, Integer> map) {
        if (map.isEmpty())
            return null; // Handle empty map case

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        // traverse the map by entrySet
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        Map<String, Integer> data = new HashMap<>();
        data.put("A", 10);
        data.put("B", 20);
        data.put("C", 15);

        System.out.println("Key with max value: " + findMaxKey(data)); // Output: B
    }
}
