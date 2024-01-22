// Polymorphism is one of the four fundamental principles of Object-Oriented Programming (OOP), along with encapsulation, inheritance, and abstraction.
// It allows objects of different types to be treated as objects of a common type.

// Types of Polymorphism

// Compile-time polymorphism (static binding): 
// Occurs at compile time.
// Involves methods with the same name in the same class or different classes within the same inheritance hierarchy.
// Decided at compile time based on the number, type, and order of parameters.

class Calculator {
    // Method Overloading
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public String add(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Compile-time polymorphism (method overloading)
        System.out.println(calculator.add(5, 3)); // Output: 8
        System.out.println(calculator.add(2.5, 3.5)); // Output: 6.0
        System.out.println(calculator.add("Hello", " World")); // Output: Hello World
    }
}

// Run-time Polymorphism (Dynamic Binding or Method Overriding):
// Occurs at runtime.
// Involves methods with the same signature (name, return type, and parameters)
// in a superclass and its subclass.
// Decided at runtime based on the actual type of the object.

// Superclass
class Animal {
    public void makeSound() {
        System.out.println("Some generic sound");
    }
}

// Subclass
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark! Bark!");
    }
}

class PolymorphismExample {
    public static void main(String[] args) {
        // Run-time polymorphism (method overriding)
        Animal myAnimal = new Dog(); // Reference of Animal type, object of Dog type
        myAnimal.makeSound(); // Output: Bark! Bark!
    }
}
