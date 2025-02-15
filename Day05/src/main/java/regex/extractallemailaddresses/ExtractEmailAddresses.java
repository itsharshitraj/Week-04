package regex.extractallemailaddresses;
import java.util.regex.*;
import java.util.*;
public class ExtractEmailAddresses {
    public static void main(String[] args) {
      String text ="Contact us at support@example.com and info@company.org";

      String regex = "[\\w.-]+@[\\w.-]+\\.[a-z]{2,}";

      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(text);

      while (matcher.find()) {
          System.out.println("" + matcher.group());
      }
    }
}
