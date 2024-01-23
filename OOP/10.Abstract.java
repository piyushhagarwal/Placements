// Abstraction is one of the core principles of object-oriented programming
// (OOP) that focuses on simplifying complex systems by modeling classes based
// on real-world entities and their interactions. It involves hiding the complex
// implementation details of an object and exposing only the necessary
// functionalities.

// abstract method only has a method signature and no implementation. It is
// declared using the abstract keyword.

// Abstract class representing a Shape
abstract class Shape {
    // Abstract method to calculate the area (to be implemented by subclasses)
    public abstract double calculateArea();
}

// Concrete class representing a Circle
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Concrete class representing a Rectangle
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class AbstractionExample {
    public static void main(String[] args) {
        // Using abstraction to create instances of different shapes
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);

        // Calculating and displaying the areas without knowing the specific
        // implementation details
        System.out.println("Area of Circle: " + circle.calculateArea());
        System.out.println("Area of Rectangle: " + rectangle.calculateArea());
    }
}

// The abstract class Shape defines an abstract method calculateArea(). It
// doesn't provide an implementation because the calculation of area depends on
// the specific type of shape.

// Concrete classes Circle and Rectangle extend the Shape class and provide
// their own implementations for the calculateArea() method.

// In the main method, instances of Circle and Rectangle are created and used
// without knowing the specific details of how their areas are calculated. This
// demonstrates abstraction by hiding the implementation details behind a common
// interface (Shape).