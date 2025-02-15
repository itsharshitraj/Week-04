package regex.validateusername;
import java.util.Scanner;
public class UserName_Validation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String[] username = new String[]{sc.next()};

        for(String userName : username){
            System.out.println(userName + " - " + ((isValidUsername(userName)) ? "Valid" : "Invalid"));
        }
    }
    public static boolean isValidUsername(String username) {
        String regex="^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        return username.matches(regex);
    }
}
