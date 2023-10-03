// Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

// You must not use any built-in exponent function or operator.

// For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

// Example 1:

// Input: x = 4
// Output: 2
// Explanation: The square root of 4 is 2, so we return 2.
// Example 2:

// Input: x = 8
// Output: 2
// Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

package BinarySearch;

class Sqrt {

    static int DirectSqrt(int x) {
        return (int) Math.sqrt(x); // Direct method in java to return sqrt in Java which returns double
    }

    static int linearSearchSqrt(int x) {
        int ans = 0;

        for (int i = 0; i <= x; i++) {
            if ((long) i * i == x) {
                return i;
            } else if ((long) i * i < x) {
                ans = i;
            } else {
                break; // Stop the loop when the square of i exceeds x
            }
        }

        return ans;
    }

    static int binarySearchSqrt(int x) {
        int start = 0;
        int end = x;
        int mid = start + (end - start) / 2;
        int ans = 0;

        while (start <= end) {
            if ((long) mid * mid == x) {
                return mid;
            } else if ((long) mid * mid > x) {
                end = mid - 1;
            } else if ((long) mid * mid < x) {
                ans = mid;
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        return ans;
    }

    // By linear search the complexity comes out to be O(sqrt(n)) which is more than
    // O(log(n))

    public static void main(String args[]) {
        int x = 2147395600;
        System.out.println(binarySearchSqrt(x));

    }
}
