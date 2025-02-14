package exceptionhandling.nestedtrycatch;

import java.util.*;

public class NestedTryCatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {12, 22, 34, 80, 74, 100};

        System.out.println("Enter Index: ");
        int index = sc.nextInt();

        System.out.println("Enter divisor: ");
        int divisor = sc.nextInt();

        try {
            try {
                int value = arr[index];
                int result = value / divisor;
                System.out.println("Result: " + result);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        } finally {
            System.out.println("Operation Completed");
        }
        sc.close();
    }
}
