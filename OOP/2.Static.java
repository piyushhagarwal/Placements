// In Java, the static keyword is used to declare members (variables and methods) that belong to the class rather than instances of the class. When a member is declared as static, it means there is only one copy of that member that is shared among all instances of the class. Here are the main uses of the static keyword:

// 1. Static Variables (Class Variables): These are variables that belong to the class rather than any specific instance of the class. They are shared among all instances of the class.
// 2. Static Methods: These are methods that belong to the class rather than any specific instance. They can be called using the class name, and they cannot access non-static (instance) members directly.
// 3. Static Blocks: These are blocks of code that are executed only once when the class is loaded into memory. They are often used to initialize static variables.

class StaticExample {
    // Static variable (class variable)
    static int staticVariable = 10;

    // Instance variable
    int instanceVariable;

    // Static block (executed only once when the class is loaded)
    static {
        System.out.println("Static block is executed.");
        // You can perform any static initialization here
    }

    // Static method
    static void staticMethod() {
        System.out.println("This is a static method.");
        // Cannot access instanceVariable directly, as it is not static
        // System.out.println(instanceVariable); // Compilation error
    }

    // Method to access instance variable in a static method
    static void accessInstanceVariable(StaticExample instance) {
        System.out.println("Accessing instance variable in a static method: " + instance.instanceVariable);
    }

    public static void main(String[] args) {
        // Accessing static variable and method using the class name
        System.out.println("Static variable: " + StaticExample.staticVariable);
        StaticExample.staticMethod();

        // Creating instances of the class
        StaticExample instance1 = new StaticExample();
        StaticExample instance2 = new StaticExample();

        // Accessing instance variable
        instance1.instanceVariable = 20;
        instance2.instanceVariable = 30;

        // Each instance has its own copy of instanceVariable
        System.out.println("Instance 1 variable: " + instance1.instanceVariable);
        System.out.println("Instance 2 variable: " + instance2.instanceVariable);

        // Static variable is shared among all instances
        StaticExample.staticVariable = 50;

        // Changing static variable reflects in all instances
        System.out.println("Instance 1 static variable: " + instance1.staticVariable);
        System.out.println("Instance 2 static variable: " + instance2.staticVariable);

        // Accessing instance variable in a static method
        accessInstanceVariable(instance1);
    }
}
