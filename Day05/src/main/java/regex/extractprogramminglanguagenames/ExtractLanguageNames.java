package regex.extractprogramminglanguagenames;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.*;
public class ExtractLanguageNames {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        String[] languages = {"Java", "Python", "JavaScript", "Go", "C", "C++", "C#", "Ruby", "Swift", "Kotlin", "PHP"};
        
        String regex = "\\b(" + String.join("|", languages) + ")\\b";


        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> foundLanguages = new ArrayList<>();

        while (matcher.find()) {
            foundLanguages.add(matcher.group());
        }

        System.out.println(String.join(", ", foundLanguages));
    }
}
