package Recursion.Basic;

class Fibonacci {

    // Normal method
    public int fib1(int n) {
        int f0 = 0;
        int f1 = 1;
        int f2 = 1;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        for (int i = 2; i <= n; i++) {
            f2 = f1 + f0;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }

    // Recursive method
    public int fib2(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fib2(n - 1) + fib2(n - 2);
    }

}
