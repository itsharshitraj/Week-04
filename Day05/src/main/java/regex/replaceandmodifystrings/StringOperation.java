package regex.replaceandmodifystrings;
import java.util.*;
public class StringOperation {
    public static void main(String[] args) {
        String text = "This is an   example with   multiple spaces.";

        String replacedText = text.replaceAll("\\s+", " ");

        System.out.println("Original text: " + text);
        System.out.println("Replaced text: " + replacedText);
    }
}
