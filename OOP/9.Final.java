// The final keyword in Java is used to indicate that a variable, method, or
// class is constant and cannot be changed, overridden, or extended,
// respectively.

// 1. Final Variable:
// When a variable is declared as final, its value cannot be changed once it's
// assigned. It becomes a constant.

class FinalVariableExample {
    public static void main(String[] args) {
        final int x = 10;
        // Attempting to reassign a value to x will result in a compilation error
        // x = 20; // Error: cannot assign a value to final variable x
        System.out.println("Value of x: " + x);
    }
}

// 2. Final Method:
// When a method is declared as final in a class, it means that the method
// cannot be overridden by any subclass.

// Superclass with a final method
class BaseClass {
    public final void display() {
        System.out.println("This is a final method in BaseClass");
    }
}

// Subclass attempting to override the final method
class SubClass extends BaseClass {
    // Uncommenting the following method would result in a compilation error
    // @Override
    // public void display() {
    // System.out.println("Trying to override the final method");
    // }
}

class FinalMethodExample {
    public static void main(String[] args) {
        BaseClass obj = new BaseClass();
        obj.display(); // Output: This is a final method in BaseClass
    }
}

// 3. Final Class:
// When a class is declared as final, it means that the class cannot be extended
// by any other class.

// Final class that cannot be extended
final class FinalClass {
    // Class implementation
}

// Attempting to extend a final class results in a compilation error
// class AnotherClass extends FinalClass {
// // Class implementation
// }

// Using final with variables, methods, or classes is often done to enforce
// immutability, prevent method overriding, or prohibit further extension of a
// class, respectively. It contributes to code safety, maintainability, and
// design integrity.