// Inheritance is a fundamental concept in object-oriented programming (OOP) that allows a new class (subclass or derived class) to inherit attributes and behaviors from an existing class (superclass or base class).
// The new class can reuse the properties and methods of the existing class and can also extend or override them to provide specific functionality.
// Inheritance promotes code reuse, extensibility, and the creation of a hierarchical relationship between classes.

// Base class (superclass)
class Calculator {
    // Method to add two numbers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to subtract two numbers
    public int subtract(int a, int b) {
        return a - b;
    }
}

// Derived class (subclass)
class AdvancedCalculator extends Calculator {
    // Method to multiply two numbers
    public int multiply(int a, int b) {
        return a * b;
    }

    // Method to divide two numbers
    public double divide(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Cannot divide by zero.");
            return Double.NaN; // NaN (Not a Number) to represent an undefined result
        }
    }
}

class CalculatorExample {
    public static void main(String[] args) {
        // Create an instance of the AdvancedCalculator class
        AdvancedCalculator myCalculator = new AdvancedCalculator();

        // Use methods from the Calculator class
        int sum = myCalculator.add(5, 3);
        int difference = myCalculator.subtract(8, 4);

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);

        // Use methods from the AdvancedCalculator class
        int product = myCalculator.multiply(4, 3);
        double quotient = myCalculator.divide(10.0, 2.0);

        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
    }
}

// Multilevel Inheritance
class ScientificCalculator extends AdvancedCalculator {
    // Method to find the square root of a number
    public double squareRoot(double a) {
        if (a >= 0) {
            return Math.sqrt(a);
        } else {
            System.out.println("Cannot calculate square root of a negative number.");
            return Double.NaN;
        }
    }

    // Method to raise a number to a power
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}

// ScientificCalculator inherits from AdvancedCalculator, which in turn inherits
// from Calculator.
// This class will have access to all the methods( add, subtract, multiply,
// divide, squareRoot, power) from all the three classes.

// Multiple Inheritance
// Java does not support multiple inheritance of classes.
// Eg. class A extends B, C. If B has a method with the same name as a method in
// C, which method will A inherit?
// To avoid this ambiguity, Java does not support multiple inheritance of
// classes.