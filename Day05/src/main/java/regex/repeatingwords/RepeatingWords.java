package regex.repeatingwords;
import java.util.regex.*;
public class RepeatingWords {
    public static void main(String[] args) {
         String text = "This is is a repeated repeated word test.";
        String regex = "\\b(\\w+)\\b\\s+\\b\\1\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Output : " + matcher.group());
        }
    }
}
