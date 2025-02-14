package countwordsinafile;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class WordCount {
    private static final String FILE_NAME = "src/main/java/countwordsinafile/input.txt";

    public static void main(String[] args) {
        Map<String, Integer> wordCount = countWordsInFile(FILE_NAME);
        if (!wordCount.isEmpty()) {
            displayTopWords(wordCount, 5);
        }
    }

    public static Map<String, Integer> countWordsInFile(String filePath) {
        Map<String, Integer> wordMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Convert to lowercase and split words using regex
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return wordMap;
    }

    public static void displayTopWords(Map<String, Integer> wordMap, int topN) {
        // Sort words by frequency in descending order
        List<Entry<String, Integer>> sortedWords = new ArrayList<>(wordMap.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Display top N words
        System.out.println("\nTop " + topN + " most frequent words:");
        for (int i = 0; i < Math.min(topN, sortedWords.size()); i++) {
            Entry<String, Integer> entry = sortedWords.get(i);
            System.out.println(entry.getKey() + " - " + entry.getValue() + " times");
        }
    }
}