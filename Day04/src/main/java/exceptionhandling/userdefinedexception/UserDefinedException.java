package exceptionhandling.userdefinedexception;

import java.util.*;

class InavlidAgeException extends Exception {
    public InavlidAgeException(String message) {
        super(message);
    }
}

public class UserDefinedException {
    // method to validate age
    public void validateAge(int age) throws InavlidAgeException {
        if (age < 18) {
            throw new InavlidAgeException("Age must be 18 or above");
        } else {
            System.out.println("Access Granted : Valid Age");
        }
    }

    public static void main(String[] args) {
        UserDefinedException validator = new UserDefinedException();
        System.out.println("-----Age Validator----- ");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your age : ");
        int age = scanner.nextInt();

        try {
            validator.validateAge(age);
        } catch (InavlidAgeException e) {
            System.out.println(e.getMessage());
            ;
        }
    }
}
