package regex.censorbadwords;
import java.util.regex.*;
public class CensorBadWords {
    public static void main(String[] args) {
                String text = "This is a damn bad example with some stupid words.";

                String[] badWords = {"damn", "stupid"};

                for (String badWord : badWords) {
                    String regex = "\\b" + badWord + "\\b";
                    text = text.replaceAll("(?i)" + regex, "****");
                }

                System.out.println(text);
            }
        }
 
