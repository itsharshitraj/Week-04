package exceptionhandling.checkedexception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class CheckedException {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/exceptionhandling/checkedexception/data.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("File Content : " + line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("IOException : File not found " + e.getMessage());
        }
    }
}
