package annotations.exercise;

class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}
public class Exercise1 {
        public static void main(String[] args) {
            Animal myDog = new Dog(); // Polymorphism
            myDog.makeSound(); // Calls the overridden method in Dog
        }
    }


