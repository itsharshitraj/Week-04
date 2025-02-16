package reflection.basiclevel;

import java.lang.reflect.Method;

class Calculator {
    // Private method to multiply two numbers
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class ReflectionPrivateMethod {
    public static void main(String[] args) {
        try {
            // Step 1: Create an instance of Calculator
            Calculator calculator = new Calculator();

            // Step 2: Get the private method "multiply" using Reflection
            Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);

            // Step 3: Make the private method accessible
            multiplyMethod.setAccessible(true);

            // Step 4: Invoke the private method
            int result = (int) multiplyMethod.invoke(calculator, 5, 4);

            // Step 5: Display the result
            System.out.println("Multiplication Result: " + result); // Output: 20

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

