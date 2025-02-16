package annotations.customannotations.pendingtasks;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the @Todo annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.METHOD) // Can be applied to methods
@interface Todo {
    String task(); // Description of the task
    String assignedTo(); // Developer responsible
    String priority() default "MEDIUM"; // Default priority
}

// Step 2: Apply @Todo annotation to methods
class ProjectTasks {

    @Todo(task = "Implement login feature", assignedTo = "Alice", priority = "HIGH")
    public void login() {
        System.out.println("Login functionality in progress...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDatabase() {
        System.out.println("Optimizing database...");
    }

    @Todo(task = "Add unit tests for user service", assignedTo = "Charlie", priority = "LOW")
    public void addUnitTests() {
        System.out.println("Writing unit tests...");
    }
}
public class Todo_Annotations {
    public static void main(String[] args) {
        Class<ProjectTasks> obj = ProjectTasks.class;

        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("----------------------");
            }
        }
    }
}
