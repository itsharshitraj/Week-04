package annotations.exercise;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define a custom annotation @TaskInfo
@Retention(RetentionPolicy.RUNTIME) // Annotation is available at runtime
@Target(ElementType.METHOD) // Can only be applied to methods
 @interface TaskInfo{
    String priority();
    String assignedTo();
}
class TaskManager{
    @TaskInfo(priority = "High", assignedTo = "Harshit")
    public void completeReport(){
        System.out.println("Completing the report.....");
    }
    @TaskInfo(priority = "Medium", assignedTo = "Raj")
    public void scheduleMeeting(){
        System.out.println("Scheduling a meeting...");

    }}

public class Exercise4 {
    public static void main(String[] args) {
        Class<TaskManager> obj = TaskManager.class;

     // Loop through each method in TaskManager
        for (Method method : obj.getDeclaredMethods()) {
            // Check if @TaskInfo is present
            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo task = method.getAnnotation(TaskInfo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Priority: " + task.priority());
                System.out.println("Assigned To: " + task.assignedTo());
                System.out.println("----------------------");
            }
        }

    }

}
