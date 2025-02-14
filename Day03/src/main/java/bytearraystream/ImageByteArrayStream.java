package bytearraystream;

import java.io.*;

public class ImageByteArrayStream {
    public static void main(String[] args) {
        String inputImagePath = "src/main/java/bytearraystream/input.jpg";
        String outputImagePath = "output.jpg";

        try {
            // Convert image to byte array
            byte[] imageBytes = convertImageToByteArray(inputImagePath);

            // Write the byte array back to a new image file
            writeByteArrayToImage(imageBytes, outputImagePath);

            // Verify if both images are identical
            boolean isIdentical = compareImages(inputImagePath, outputImagePath);
            System.out.println("Images are identical: " + isIdentical);

        } catch (IOException e) {
            System.out.println("Error processing image: " + e.getMessage());
        }
    }

    // Method to convert image to byte array
    private static byte[] convertImageToByteArray(String imagePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];  // Read in 4 KB chunks
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    // Method to write byte array back to an image
    private static void writeByteArrayToImage(byte[] imageBytes, String outputImagePath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputImagePath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
        System.out.println("Image successfully written to: " + outputImagePath);
    }

    // Method to compare two images (byte by byte)
    private static boolean compareImages(String imagePath1, String imagePath2) throws IOException {
        byte[] image1 = convertImageToByteArray(imagePath1);
        byte[] image2 = convertImageToByteArray(imagePath2);

        return java.util.Arrays.equals(image1, image2);
    }
}
