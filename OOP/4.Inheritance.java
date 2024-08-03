// Inheritance is a fundamental concept in object-oriented programming (OOP) that allows a new class (subclass or derived class) to inherit attributes and behaviors from an existing class (superclass or base class).
// The new class can reuse the properties and methods of the existing class and can also extend or override them to provide specific functionality.
// Inheritance promotes code reuse, extensibility, and the creation of a hierarchical relationship between classes.

// We'll use an e-commerce application where we manage different types of products.

// Base class
class Product {
    private String name;
    private double price;
    private String description;

    // Constructor
    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    // Method to display product details
    public void displayProductDetails() {
        System.out.println("Product Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Description: " + description);
    }
}

// Derived class for Electronics products
class Electronics extends Product {
    private int warrantyPeriod; // Warranty period in months
    private String brand;

    // Constructor
    public Electronics(String name, double price, String description, int warrantyPeriod, String brand) {
        super(name, price, description); // Call the constructor of the base class
        this.warrantyPeriod = warrantyPeriod;
        this.brand = brand;
    }

    // Getter methods
    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public String getBrand() {
        return brand;
    }

    // Overridden method to display product details
    @Override
    public void displayProductDetails() {
        super.displayProductDetails(); // Call the base class method
        System.out.println("Warranty Period: " + warrantyPeriod + " months");
        System.out.println("Brand: " + brand);
    }
}

// Derived class for Clothing products
class Clothing extends Product {
    private String size;
    private String material;

    // Constructor
    public Clothing(String name, double price, String description, String size, String material) {
        super(name, price, description); // Call the constructor of the base class
        this.size = size;
        this.material = material;
    }

    // Getter methods
    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    // Overridden method to display product details
    @Override
    public void displayProductDetails() {
        super.displayProductDetails(); // Call the base class method
        System.out.println("Size: " + size);
        System.out.println("Material: " + material);
    }
}

// Main class to demonstrate inheritance
class Main {
    public static void main(String[] args) {
        // Creating an Electronics product
        Electronics laptop = new Electronics("Laptop", 1200.99, "High-performance laptop", 24, "Dell");

        // Creating a Clothing product
        Clothing tshirt = new Clothing("T-Shirt", 19.99, "Comfortable cotton t-shirt", "M", "Cotton");

        // Display product details
        laptop.displayProductDetails();
        System.out.println();
        tshirt.displayProductDetails();
    }
}

// Multiple Inheritance
// Java does not support multiple inheritance of classes.
// Eg. class A extends B, C. If B has a method with the same name as a method in
// C, which method will A inherit?
// To avoid this ambiguity, Java does not support multiple inheritance of
// classes.