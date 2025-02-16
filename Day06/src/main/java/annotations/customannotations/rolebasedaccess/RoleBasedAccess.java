package annotations.customannotations.rolebasedaccess;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the @RoleAllowed annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.METHOD) // Can be applied to methods
@interface RoleAllowed {
    String value(); // Role required to execute the method
}

// Step 2: Simulate a User with Roles
class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

// Step 3: Apply @RoleAllowed to methods in the SecureService class
class SecureService {

    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed successfully!");
    }

    @RoleAllowed("USER")
    public void userTask() {
        System.out.println("User task executed successfully!");
    }
}
public class RoleBasedAccess {
    public static void main(String[] args) {
        User adminUser = new User("ADMIN");
        User normalUser = new User("USER");

        SecureService service = new SecureService();

        invokeMethodIfAuthorized(service, "adminTask", adminUser); // Should execute
        invokeMethodIfAuthorized(service, "adminTask", normalUser); // Should print "Access Denied!"
        invokeMethodIfAuthorized(service, "userTask", normalUser); // Should execute
    }

    private static void invokeMethodIfAuthorized(Object obj, String methodName, User user) {
        try {
            Method method = obj.getClass().getDeclaredMethod(methodName);

            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);

                if (roleAllowed.value().equals(user.getRole())) {
                    method.invoke(obj);
                } else {
                    System.out.println("Access Denied! User role '" + user.getRole() + "' is not authorized to execute " + methodName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
