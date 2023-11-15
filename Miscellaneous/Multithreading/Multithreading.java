package Miscellaneous.Multithreading;

class A extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Class A");
        }
    }
}

class B extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Class B");
        }
    }

}

public class Multithreading {
    public static void main(String args[]) {
        A obj1 = new A();
        B obj2 = new B();

        obj1.start();
        obj2.start();
    }

}

// Points to remember:
// 1) We extends the class we want to make thread for with Thread parent class.
// 2) We override the run() function in the following classes
// 3) We write obj1.start() to run the threads