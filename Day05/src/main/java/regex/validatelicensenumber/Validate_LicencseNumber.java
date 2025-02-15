package regex.validatelicensenumber;
import java.util.regex.*;
import java.util.Scanner;
public class Validate_LicencseNumber {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter License Plate Number: ");
     String[] number = new String []{sc.next()};

     for (String numbers : number){
         System.out.println(numbers + " =" + ((isValid(numbers)) ? "valid" : " Invalid"));
     }
    }
    public static boolean isValid(String number){
        String regex= "^[A-Z]{2}[0-9]{4}$";
        return (number.matches(regex));
    }
}
