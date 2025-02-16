package annotations.customannotations.fieldvalidation;
import java.lang.annotation.*;
import java.lang.reflect.Field;

// Step 1: Define the @MaxLength annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.FIELD) // Can be applied to fields
@interface MaxLength {
    int value(); // Maximum allowed length
}

// Step 2: Apply @MaxLength to a field in the User class
class User {
    @MaxLength(10) // Restricts username length to 10 characters
    private String username;

    public User(String username) {
        validateMaxLength(username);
        this.username = username;
    }

    // Step 3: Validate the field length using Reflection
    private void validateMaxLength(String username) {
        try {
            Field field = this.getClass().getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                if (username.length() > maxLength.value()) {
                    throw new IllegalArgumentException("Username exceeds max length of " + maxLength.value() + " characters.");
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

public class FieldLevel {
    public static void main(String[] args) {
        try {
            User user1 = new User("Alice123");
            System.out.println("User created successfully: " + user1);

            User user2 = new User("LongUsername123"); // Invalid username (exceeds 10 characters)
            System.out.println("User created successfully: " + user2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
