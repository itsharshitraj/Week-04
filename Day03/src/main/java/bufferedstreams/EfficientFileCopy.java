package bufferedstreams;

import java.io.*;

public class EfficientFileCopy {
    private static final int BUFFER_SIZE = 4096; // 4 KB

    public static void main(String[] args) {
        String sourceFile = "src/main/java/bufferedstreams/largefile.txt";
        String destinationBuffered = "copy_buffered.txt";
        String destinationUnbuffered = "copy_unbuffered.txt";

        System.out.println("Copying file using unbuffered streams...");
        long unbufferedTime = copyUsingUnbufferedStream(sourceFile, destinationUnbuffered);
        System.out.println("Unbuffered copy time: " + unbufferedTime + " ns (" + unbufferedTime / 1_000_000 + " ms)\n");

        System.out.println("Copying file using buffered streams...");
        long bufferedTime = copyUsingBufferedStream(sourceFile, destinationBuffered);
        System.out.println("Buffered copy time: " + bufferedTime + " ns (" + bufferedTime / 1_000_000 + " ms)\n");

        System.out.println("Performance improvement: " + (unbufferedTime / (double) bufferedTime) + "x faster with buffering.");
    }

    // Copy file using UNBUFFERED Streams (FileInputStream & FileOutputStream)
    public static long copyUsingUnbufferedStream(String source, String destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }

    // Copy file using BUFFERED Streams (BufferedInputStream & BufferedOutputStream)
    public static long copyUsingBufferedStream(String source, String destination) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }
}


