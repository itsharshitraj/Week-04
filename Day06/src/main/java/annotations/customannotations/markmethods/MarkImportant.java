package annotations.customannotations.markmethods;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the @ImportantMethod annotation
@Retention(RetentionPolicy.RUNTIME)  // Annotation is available at runtime
@Target(ElementType.METHOD)  // Can only be applied to methods
@interface ImportantMethod {
    String level() default "HIGH";  // Optional parameter with default value
}

// Step 2: Apply the annotation to methods in a class
class MyService {

    @ImportantMethod(level = "CRITICAL")
    public void processPayment() {
        System.out.println("Processing payment...");
    }

    @ImportantMethod  // Uses the default level "HIGH"
    public void generateReport() {
        System.out.println("Generating report...");
    }

    public void helperMethod() {
        System.out.println("This is just a helper method.");
    }
}

// Step 3: Retrieve and print annotated methods using Reflection API
public class MarkImportant {
    public static void main(String[] args) {
        Class<MyService> obj = MyService.class;

        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Important Method: " + method.getName());
                System.out.println("Importance Level: " + annotation.level());
                System.out.println("----------------------");
            }
        }
    }
}


