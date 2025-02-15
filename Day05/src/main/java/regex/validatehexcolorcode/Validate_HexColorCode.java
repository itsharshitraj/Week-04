package regex.validatehexcolorcode;
import java.util.regex.*;
import java.util.*;
public class Validate_HexColorCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Validate hex color code: ");
        String color[] = new String[] {sc.next()};

        for(String hexColor : color) {
            System.out.println("HexColor : " + hexColor + " : " + (isValid(hexColor) ? "valid" : "Invalid"));
        }

    }
    public static boolean isValid(String color){
        String regex = "^[#][0-9,A-F,a-f]{6}$";
        return color.matches(regex);
    }
}
