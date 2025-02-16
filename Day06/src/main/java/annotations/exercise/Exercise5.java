package annotations.exercise;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define a container annotation to hold multiple @BugReport annotations
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

@interface BugReports {
    BugReport[] value();
}

// Step 2: Define the @BugReport annotation and make it repeatable
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class) // Allows multiple annotations on the same method
@interface BugReport {
    String description();
    String reportedBy();
}

// Step 3: Apply multiple @BugReport annotations to a method
class SoftwareModule {

    @BugReport(description = "NullPointerException occurs on empty input", reportedBy = "Alice")
    @BugReport(description = "IndexOutOfBoundsException on large data", reportedBy = "Bob")
    public void processData() {
        System.out.println("Processing data...");
    }
}


public class Exercise5 {
    public static void main(String[] args) {
        Class<SoftwareModule> obj = SoftwareModule.class;

        for (Method method : obj.getDeclaredMethods()) {
            // Check if the method has the @BugReport annotation
            if (method.isAnnotationPresent(BugReports.class)) {
                BugReports bugReports = method.getAnnotation(BugReports.class);

                System.out.println("Method: " + method.getName());
                for (BugReport bug : bugReports.value()) {
                    System.out.println("Bug Description: " + bug.description());
                    System.out.println("Reported By: " + bug.reportedBy());
                    System.out.println("----------------------");
                }
            }
        }
    }
}

