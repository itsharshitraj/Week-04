package reflection.basiclevel;

import java.lang.reflect.Field;

class Person {
    private int age;

    // Constructor
    public Person(int age) {
        this.age = age;
    }

    // Method to display age (for verification)
    public void displayAge() {
        System.out.println("Age: " + age);
    }
}

public class ReflectionPrivateField {
    public static void main(String[] args) {
        try {
            // Step 1: Create an instance of Person
            Person person = new Person(25);
            person.displayAge(); // Output: Age: 25

            // Step 2: Get the private field "age" using Reflection
            Field ageField = Person.class.getDeclaredField("age");

            // Step 3: Make the private field accessible
            ageField.setAccessible(true);

            // Step 4: Modify the private field value
            ageField.set(person, 30);

            // Step 5: Retrieve the updated value
            int newAge = (int) ageField.get(person);

            // Step 6: Display the updated age
            System.out.println("Modified Age: " + newAge);
            person.displayAge(); // Output: Age: 30

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
