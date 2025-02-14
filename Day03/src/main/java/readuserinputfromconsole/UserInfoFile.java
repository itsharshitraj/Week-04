package readuserinputfromconsole;

import java.io.*;

public class UserInfoFile {
    public static void main(String[] args) throws IOException {
        String fileName = "src/main/java/readuserinputfromconsole/userInformation.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(fileName, true)) {

            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String favoriteLanguage = reader.readLine();

            // write to file
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + favoriteLanguage + "\n");
            writer.write("--------------------------------------------------------\n");

            System.out.println("User Information saved successfully in " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while reading input or writing filename");
            e.printStackTrace();
        }


    }
}
