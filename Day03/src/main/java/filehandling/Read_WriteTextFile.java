package filehandling;

import java.io.*;

public class Read_WriteTextFile {
    public static void main(String[] args) {
        // Specify the source and destination files
        String sourceFile = "src/main/java/filehandling/source.txt";
        String destinationFile = "src/main/java/filehandling/destination.txt";

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            // Open the source file
            fileInputStream = new FileInputStream(sourceFile);

            // Create the destination file if it does not exist
            fileOutputStream = new FileOutputStream(destinationFile);

            int byteData;

            // Read the source file and write to the destination file
            while ((byteData = fileInputStream.read()) != -1) {
                fileOutputStream.write(byteData);
            }

            System.out.println("File content copied successfully!");

        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + sourceFile);
        } catch (IOException e) {
            System.out.println("An error occurred during file operations.");
            e.printStackTrace();
        } finally {
            // Close the streams
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing the streams.");
                e.printStackTrace();
            }
        }
    }
}


