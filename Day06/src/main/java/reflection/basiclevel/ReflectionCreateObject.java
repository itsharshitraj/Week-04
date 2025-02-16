package reflection.basiclevel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class Student {
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display student details
    public void display() {
        System.out.println("Student Name: " + name + ", Age: " + age);
    }
}

public class ReflectionCreateObject {
    public static void main(String[] args) {
        try {
            // Fix: Use Student.class instead of Class.forName()
            Class<?> studentClass = Student.class;

            // Get the constructor with parameters
            Constructor<?> constructor = studentClass.getDeclaredConstructor(String.class, int.class);

            // Create an instance dynamically using Reflection
            Object studentObject = constructor.newInstance("Harshit", 22);

            // Invoke the display() method
            Method displayMethod = studentClass.getDeclaredMethod("display");
            displayMethod.invoke(studentObject);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
