package Maths;

// Link: https://www.geeksforgeeks.org/problems/lcm-and-gcd4516/1
// Solution : https://takeuforward.org/data-structure/find-gcd-of-two-numbers/

// To find LCM of two numbers, we can use the formula:
// LCM(a, b) = (a * b) / GCD(a, b) where GCD is the Greatest Common Divisor of a and b.

// Brute force approach                             
class Main {
    public static int findGcd(int n1, int n2) {
        // Initialize gcd to 1
        int gcd = 1;

        // Iterate from 1 up to
        // the minimum of n1 and n2
        for (int i = 1; i <= Math.min(n1, n2); i++) {
            // Check if i is a common
            // factor of both n1 and n2
            if (n1 % i == 0 && n2 % i == 0) {
                // Update gcd to the
                // current common factor i
                gcd = i;
            }
        }

        // Return the greatest
        // common divisor (gcd)
        return gcd;
    }

    public static void main(String[] args) {
        int n1 = 20, n2 = 15;

        // Find the GCD of n1 and n2
        int gcd = findGcd(n1, n2);

        System.out.println("GCD of " + n1 + " and " + n2 + " is: " + gcd);
    }
}

// Optimized approach

// The Euclidean Algorithm is a method for finding the greatest common divisor
// of two numbers. It operates on the principle that the GCD of two numbers
// remains the same even if the smaller number is subtracted from the larger
// number.

// To find the GCD of n1 and n2 where n1 > n2:

// Repeatedly subtract the smaller number from the larger number until one of
// them becomes 0.
// Once one of them becomes 0, the other number is the GCD of the original
// numbers.
// Eg, n1 = 20, n2 = 15:

// gcd(20, 15) = gcd(20-15, 15) = gcd(5, 15)

// gcd(5, 15) = gcd(15-5, 5) = gcd(10, 5)

// gcd(10, 5) = gcd(10-5, 5) = gcd(5, 5)

// gcd(5, 5) = gcd(5-5, 5) = gcd(0, 5)

// Hence, return 5 as the gcd.

class Main2 {
    // Continue loop as long as both
    // a and b are greater than 0
    public static int findGcd(int a, int b) {
        while (a > 0 && b > 0) {
            // If a is greater than b,
            // subtract b from a and update a
            if (a > b) {
                // Update a to the remainder
                // of a divided by b
                a = a % b;
            }
            // If b is greater than or equal
            // to a, subtract a from b and update b
            else {
                // Update b to the remainder
                // of b divided by a
                b = b % a;
            }
        }
        // Check if a becomes 0,
        // if so, return b as the GCD
        if (a == 0) {
            return b;
        }
        // If a is not 0,
        // return a as the GCD
        return a;
    }

    public static void main(String[] args) {
        int n1 = 20, n2 = 15;

        // Find the GCD of n1 and n2
        int gcd = findGcd(n1, n2);

        System.out.println("GCD of " + n1 + " and " + n2 + " is: " + gcd);
    }
}
