package filterstreams;

import java.io.*;

public class UpperToLowerCaseConverter {
    public static void main(String[] args) {
        String inputFile = "src/main/java/filterstreams/input.txt";
        String outputFile = "src/main/java/filterstreams/output.txt";

        convertUppercaseToLowercase(inputFile, outputFile);
    }

    public static void convertUppercaseToLowercase(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());  // Convert to lowercase
                writer.newLine(); // Preserve line breaks
            }

            System.out.println("Conversion completed. Check " + outputFile);
        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}
