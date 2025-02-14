package exceptionhandling.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFirstLine {
    public static void main(String[] args) {
        String fileName = "src/main/java/exceptionhandling/trywithresources/info.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String firstLine = br.readLine();
            System.out.println("First line of the file: " + firstLine);
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
