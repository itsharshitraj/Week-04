package reflection.advancedlevel.customobjectmapper;

import java.util.HashMap;
import java.util.Map;

// Sample User class
class User {
    private String name;
    private int age;

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + "}";
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating a map with sample data
        Map<String, Object> userData = new HashMap<>();
        userData.put("name", "Alice");
        userData.put("age", 25);

        // Convert Map to User object
        User user = ObjectMapper.toObject(User.class, userData);

        // Print the result
        System.out.println(user);
    }
}

