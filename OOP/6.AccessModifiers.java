// Access modifiers in Java are keywords that define the visibility and accessibility of classes, methods, and other members within a program. There are four main access modifiers in Java:

// 1) Public (public):
// Members marked as public are accessible from any other class.
// There is no restriction on accessing public members.

// 2) Private (private):
// Members marked as private are only accessible within the same class.
// They are not visible or accessible from outside the class.

// 3) Protected (protected):
// Members marked as protected are accessible within the same class, package, and by subclasses.
// Inheritance is a key factor in understanding the use of protected members.

// 4) Default (Package-Private):
// When no access modifier is specified (i.e., no public, private, or protected), the default access level is package-private.
// Members with package-private access are accessible within the same package.
// Now, let's illustrate the use of these access modifiers with an example:

// A class representing a Car
class Car {
    // Public member
    public String make;

    // Package-private (default) member
    String model;

    // Private member
    private int year;

    // Protected member
    protected double price;

    // Constructor
    public Car(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    // Public method
    public void displayCarInfo() {
        System.out.println("Car Information:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: $" + price);
    }
}
// The make member is marked as public, so it can be accessed from any other
// class.
// The model member has default (package-private) access, making it accessible
// within the same package (no access modifier specified).
// The year member is marked as private, so it is only accessible within the Car
// class.
// The price member is marked as protected, making it accessible within the same
// class, package, and by subclasses.