package listinterface.findfrequencyofelements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_Frequency {
    public static Map<String, Integer> countFrequency(List<String> elements) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : elements) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        return frequencyMap;

    }

    public static void main(String[] args) {
        List<String> elements = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> result = countFrequency(elements);

        System.out.println(result);


    }
}

