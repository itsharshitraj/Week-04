package annotations.customannotations.loggingmethod;
import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Step 1: Define the @LogExecutionTime annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.METHOD) // Can be applied to methods
@interface LogExecutionTime {}

// Step 2: Create a class with methods annotated with @LogExecutionTime
class PerformanceTester {

    @LogExecutionTime
    public void fastMethod() {
        System.out.println("Executing fastMethod...");
    }

    @LogExecutionTime
    public void slowMethod() {
        System.out.println("Executing slowMethod...");
        try {
            Thread.sleep(1000); // Simulating slow execution
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class LoginExecutionTime {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        PerformanceTester tester = new PerformanceTester();
        Class<PerformanceTester> obj = PerformanceTester.class;

        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(tester); // Invoke the method
                long endTime = System.nanoTime();

                long executionTime = (endTime - startTime) / 1_000_000; // Convert to milliseconds
                System.out.println("Execution time of " + method.getName() + ": " + executionTime + " ms");
                System.out.println("----------------------");
            }
        }
    }
}
