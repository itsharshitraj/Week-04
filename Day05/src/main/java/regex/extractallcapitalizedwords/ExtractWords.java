package regex.extractallcapitalizedwords;
import java.util.regex.*;
public class ExtractWords {
    public static void main(String[] args) {
        String sentence = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
       String regex= "\\b[A-Z][a-zA-Z]*\\b";

       Pattern pattern = Pattern.compile(regex);
       Matcher matcher = pattern.matcher(sentence);

       while(matcher.find()) {
           System.out.println("Output : " + matcher.group());
       }
    }
}
