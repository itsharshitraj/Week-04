package reflection.intermediatelevel;
import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "ORIGINAL_KEY";

    public static String getApiKey() {
        return API_KEY;
    }
}

public class ModifyStaticField {
    public static void main(String[] args) {
        try {
            // Step 1: Get the Class object for Configuration
            Class<?> configClass = Configuration.class;

            // Step 2: Get the private static field API_KEY
            Field apiKeyField = configClass.getDeclaredField("API_KEY");

            // Step 3: Make the field accessible
            apiKeyField.setAccessible(true);

            // Step 4: Modify the static field's value
            apiKeyField.set(null, "NEW_SECRET_KEY"); // 'null' for static fields

            // Step 5: Print the modified value
            System.out.println("Updated API_KEY: " + Configuration.getApiKey());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
