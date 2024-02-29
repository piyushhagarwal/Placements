// Interface is abstract class with only abstract methods. It is declared using
// the interface keyword.

// Interface defining the contract for shapes
interface Shape {
    // Abstract method to calculate the area
    double calculateArea();
}

// Class representing a Circle that implements the Shape interface
class Circle implements Shape {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Implementation of the calculateArea method for Circle
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Class representing a Rectangle that implements the Shape interface
class Rectangle implements Shape {
    private double length;
    private double width;

    // Constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Implementation of the calculateArea method for Rectangle
    @Override
    public double calculateArea() {
        return length * width;

    }

    // Main class to demonstrate the use of the Shape interface
    class InterfaceExample {
        public static void main(String[] args) {
            // Creating instances of Circle and Rectangle
            Shape circle = new Circle(5.0);
            Shape rectangle = new Rectangle(4.0, 6.0);

            // Calculating and displaying the areas
            System.out.println("Area of Circle: " + circle.calculateArea());
            System.out.println("Area of Rectangle: " + rectangle.calculateArea());
        }
    }
}
