package annotations.customannotations.serializationannotation;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @JsonField annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.FIELD) // Can be applied to fields
@interface JsonField {
    String name(); // Custom key name for JSON serialization
}

// Step 2: Create a User class and apply @JsonField
class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    private String password; // This field is NOT annotated, so it won't be included in JSON

    public User(String username, int age, String password) {
        this.username = username;
        this.age = age;
        this.password = password;
    }
}

// Step 3: Implement JSON Serialization using Reflection
class JsonSerializer {
    public static String toJson(Object obj) {
        try {
            Map<String, String> jsonMap = new HashMap<>();
            Class<?> objClass = obj.getClass();

            for (Field field : objClass.getDeclaredFields()) {
                if (field.isAnnotationPresent(JsonField.class)) {
                    field.setAccessible(true);
                    JsonField jsonField = field.getAnnotation(JsonField.class);
                    jsonMap.put(jsonField.name(), field.get(obj).toString());
                }
            }

            return jsonMap.toString().replace("=", ":"); // Convert map to JSON-like format
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return "{}";
        }
    }
}
public class Serialization {
    public static void main(String[] args) {
            User user = new User("Alice", 25, "secret123");

            String json = JsonSerializer.toJson(user);
            System.out.println(json);
    }
}
