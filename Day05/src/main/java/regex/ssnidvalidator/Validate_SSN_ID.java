package regex.ssnidvalidator;
import java.util.regex.*;
public class Validate_SSN_ID {
    public static void main(String[] args) {
        String testSSNs = "My SSN is 123-45-6789.";

        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(testSSNs);

        boolean found = false;
        while (matcher.find()) {
            found = true;
            System.out.println(matcher.group() + "\" is valid");
        }

        if (!found) {
            System.out.println("No valid SSN found");
        }

        // Additional check for incorrect SSNs (without dashes)
        Pattern invalidPattern = Pattern.compile("\\b\\d{9}\\b");
        Matcher invalidMatcher = invalidPattern.matcher(testSSNs);
        while (invalidMatcher.find()) {
            System.out.println(invalidMatcher.group() + "\" is invalid");
        }

    }
}
