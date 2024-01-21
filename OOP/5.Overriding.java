// Method overriding is a concept in object-oriented programming where a subclass provides a specific implementation for a method that is already defined in its superclass.
// When a method in the subclass has the same signature (name, return type, and parameters) as a method in the superclass, it is said to override that method.

// Base class (superclass)
class Animal {
    // Method to make a sound
    public void makeSound() {
        System.out.println("Animal makes a generic sound.");
    }
}

// Derived class (subclass)
class Dog extends Animal {
    // Method overriding: providing a specific implementation for makeSound
    @Override
    public void makeSound() {
        System.out.println("Dog barks: Woof! Woof!");
    }

    // New method specific to Dog class
    public void wagTail() {
        System.out.println("Dog is wagging its tail.");
    }
}

class MethodOverrideExample {
    public static void main(String[] args) {
        // Create an instance of the Dog class
        Dog myDog = new Dog();

        // Call the overridden method from the Dog class
        myDog.makeSound(); // Output: Dog barks: Woof! Woof!

        // Call a method specific to the Dog class
        myDog.wagTail(); // Output: Dog is wagging its tail.

    }
}
