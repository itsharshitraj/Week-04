package reflection.intermediatelevel;

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    // Methods with different operations
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Step 1: Get the Class object for MathOperations
            Class<?> mathClass = MathOperations.class;

            // Step 2: Create an instance of MathOperations
            Object mathObject = mathClass.getDeclaredConstructor().newInstance();

            // Step 3: Take user input for method name and parameters
            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();

            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            // Step 4: Get the method dynamically
            Method method = mathClass.getMethod(methodName, int.class, int.class);

            // Step 5: Invoke the method dynamically
            Object result = method.invoke(mathObject, num1, num2);

            // Step 6: Display result
            System.out.println("Result: " + result);

            scanner.close();
        } catch (NoSuchMethodException e) {
            System.out.println("Error: Method not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
