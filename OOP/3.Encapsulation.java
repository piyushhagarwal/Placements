//The primary purpose of encapsulation is to hide the internal details of an object and restrict access to its internal state. Instead, interactions with the object are performed through well-defined interfaces, typically consisting of public methods.

// 1. Access Modifiers:
// - Private: Attributes and methods declared as private are only accessible within the class itself. They are not directly accessible from outside the class. This enforces data hiding and encapsulation.
// - Public: Public attributes and methods are accessible from any part of the program. They define the interface through which external code interacts with the object.

// 2. Data Hiding:
// Encapsulation hides the internal details of an object, such as its data members and implementation methods, from the external world. This helps in preventing direct access to an object's internal state.

// 3. Access through Methods:
// Encapsulation promotes the concept of accessor and mutator methods (also known as getters and setters). These are public methods that allow controlled access to the private attributes of the class. Accessor methods retrieve the values of attributes, while mutator methods modify them.

class BankAccount {
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Public method to get the account number (read-only)
    public String getAccountNumber() {
        return accountNumber;
    }

    // Public method to get the balance (read-only)
    public double getBalance() {
        return balance;
    }

    // Public method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Public method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public static void main(String[] args) {
        // Creating an instance of BankAccount
        BankAccount myAccount = new BankAccount("123456", 1000.0);

        // Accessing account information through public methods
        System.out.println("Account Number: " + myAccount.getAccountNumber());
        System.out.println("Balance: $" + myAccount.getBalance());

        // Performing transactions
        myAccount.deposit(500.0);
        myAccount.withdraw(200.0);
    }
}

// The BankAccount class encapsulates the account details (accountNumber and
// balance) and provides public methods (getAccountNumber, getBalance, deposit,
// withdraw) to interact with the object.

// The internal state of the BankAccount object is private, and access is
// restricted to the public methods, ensuring controlled and secure access to
// the account information.

// Users of the BankAccount class can perform transactions and retrieve account
// information without directly manipulating the internal state of the object.
// This promotes a clean interface and reduces the likelihood of unintended
// errors or misuse.
