// super() and this() are both special keywords in Java used to call constructors.
// They are used within a constructor to invoke the constructor of the superclass (super()) or the constructor of the same class (this()).

// super():
// The super() keyword is used to call the constructor of the immediate parent class (superclass).
// It is typically used when a subclass needs to initialize its inherited members by invoking the constructor of its superclass.
// super() must be the first statement in the constructor body if used.

// this():
// The this() keyword is used to call another constructor within the same class.
// It is commonly used to avoid code duplication when a class has multiple constructors with different parameter lists.
// this() must be the first statement in the constructor body if used.

// Superclass
class Person {
    String name;

    // Default constructor
    public Person() {
        this.name = "Unknown";
        System.out.println("Default constructor of Person is called with name: " + name);
    }

    // Parameterized constructor
    public Person(String name) {
        this.name = name;
        System.out.println("Parameterized constructor of Person is called with name: " + name);
    }
}

// Subclass
class Employee extends Person {
    int employeeId;

    // Default constructor, no explicit super() used
    public Employee() {
        // If no explicit super() is used, Java inserts super() here by
        // default.
        // It would implicitly call the no-argument constructor of the superclass
        // (Person).
        // In this case, it will call the default constructor of Person.

        this("Bhupendra", 100); // Call the parameterized constructor of the same class (Employee)
        System.out.println("Default constructor of Employee is called with default employeeId");
    }

    // Parameterized constructor, invoking superclass constructor using super()
    public Employee(String name, int employeeId) {
        super(name); // Call the parameterized constructor of the superclass (Person)
        this.employeeId = employeeId;
        System.out.println("Parameterized constructor of Employee is called with employeeId: " + employeeId);
    }

}

class ConstructorExample {
    public static void main(String[] args) {
        // Create an instance of the Employee class using the default constructor
        Employee defaultEmployee = new Employee();

        // Output:
        // Parameterized constructor of Person is called with name: Default Employee
        // Parameterized constructor of Employee is called with employeeId: 0
        // Default constructor of Employee is called with default employeeId

        System.out.println(); // Add a newline for clarity

        // Create an instance of the Employee class using the parameterized constructor
        Employee employeeWithDetails = new Employee("John Doe", 123);

        // Output:
        // Parameterized constructor of Person is called with name: John Doe
        // Parameterized constructor of Employee is called with employeeId: 123
    }
}
