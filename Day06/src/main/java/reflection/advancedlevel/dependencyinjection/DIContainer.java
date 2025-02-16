package reflection.advancedlevel.dependencyinjection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class DIContainer {
    private Map<Class<?>, Object> instances = new HashMap<>();

    // Register a class instance in the container
    public <T> void register(Class<T> clazz) {
        try {
            instances.put(clazz, clazz.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            throw new RuntimeException("Failed to register class: " + clazz.getName(), e);
        }
    }

    // Inject dependencies into a given object
    public void injectDependencies(Object obj) {
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();
                Object dependency = instances.get(fieldType);
                if (dependency != null) {
                    field.setAccessible(true);
                    try {
                        field.set(obj, dependency);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Failed to inject dependency: " + fieldType.getName(), e);
                    }
                } else {
                    throw new RuntimeException("No registered instance found for: " + fieldType.getName());
                }
            }
        }
    }
}

