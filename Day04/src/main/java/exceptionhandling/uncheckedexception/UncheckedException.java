package exceptionhandling.uncheckedexception;

import java.io.IOException;
import java.util.*;

public class UncheckedException {
    public static void main(String[] args) {

        try {
            System.out.println("Division operation :");
            Scanner scanner = new Scanner(System.in);


            System.out.print("Numerator : ");
            int numerator = scanner.nextInt();

            System.out.print("Denominator : ");
            int denominator = scanner.nextInt();

            int result = numerator / denominator;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException : please enter a valid denominator");
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException : please enter valid input");
            ;
        }
    }
}
