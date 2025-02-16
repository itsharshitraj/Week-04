package annotations.customannotations.cachingsystem;
import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @CacheResult annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.METHOD) // Can be applied to methods
@interface CacheResult {}

// Step 2: Create a Cache Manager to Store Results
class CacheManager {
    private static final Map<String, Object> cache = new HashMap<>();

    public static boolean containsKey(String key) {
        return cache.containsKey(key);
    }

    public static Object get(String key) {
        return cache.get(key);
    }

    public static void put(String key, Object value) {
        cache.put(key, value);
    }
}

// Step 3: Apply @CacheResult to a Computationally Expensive Method
class ExpensiveService {

    @CacheResult
    public int computeSquare(int number) {
        try {
            Thread.sleep(2000); // Simulate a slow computation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number * number;
    }
}

public class CachingSystem {
    public static void main(String[] args) {
        ExpensiveService service = new ExpensiveService();

        // Compute with caching
        System.out.println("First call (slow): " + invokeWithCache(service, "computeSquare", 5));
        System.out.println("Second call (fast, from cache): " + invokeWithCache(service, "computeSquare", 5));

        // Different input (new computation)
        System.out.println("New input (slow again): " + invokeWithCache(service, "computeSquare", 10));
    }

    private static Object invokeWithCache(Object obj, String methodName, Object... args) {
        try {
            Method method = obj.getClass().getDeclaredMethod(methodName, int.class);

            if (method.isAnnotationPresent(CacheResult.class)) {
                String cacheKey = methodName + "_" + args[0]; // Create a unique key

                if (CacheManager.containsKey(cacheKey)) {
                    return CacheManager.get(cacheKey); // Return cached result
                }

                Object result = method.invoke(obj, args);
                CacheManager.put(cacheKey, result); // Store result in cache
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
