package reflection.intermediatelevel;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Define the @Author annotation
@Retention(RetentionPolicy.RUNTIME) // Ensure annotation is available at runtime
@interface Author {
    String name();
}


@Author(name = "Harshit Raj")
class MyClass {
    public void display() {
        System.out.println("Inside MyClass");
    }
}
public class AnnotationRetriever {
    public static void main(String[] args) {
        // Step 1: Get the Class object for MyClass
        Class<?> clazz = MyClass.class;

        // Step 2: Check if @Author annotation is present
        if (clazz.isAnnotationPresent(Author.class)) {
            // Step 3: Retrieve the annotation
            Author authorAnnotation = clazz.getAnnotation(Author.class);

            // Step 4: Display the annotation value
            System.out.println("Author: " + authorAnnotation.name());
        } else {
            System.out.println("No @Author annotation found.");
        }
    }
}
