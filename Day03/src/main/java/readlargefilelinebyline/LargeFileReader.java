package readlargefilelinebyline;

import java.io.*;

public class LargeFileReader {
    private static final String FILE_PATH = "src/main/java/readlargefilelinebyline/large_log.txt";

    public static void main(String[] args) {
        readLargeFile(FILE_PATH);
    }

    public static void readLargeFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (line.toLowerCase().contains("error")) { // Case-insensitive check
                    System.out.println("Line " + lineNumber + ": " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
