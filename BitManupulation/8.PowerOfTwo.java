// Given an integer n, return true if it is a power of two. Otherwise, return false.

// An integer n is a power of two, if there exists an integer x such that n == 2x.

// Example 1:

// Input: n = 1
// Output: true
// Explanation: 20 = 1
// Example 2:

// Input: n = 16
// Output: true
// Explanation: 24 = 16
// Example 3:

// Input: n = 3
// Output: false

//Link: https://leetcode.com/problems/power-of-two/

package BitManupulation;

class Solution {
    // By doing & of n and n - 1 we get zero if n is power of 2
    public boolean isPowerOfTwo(int n) {
        // If the number is negative or zero then it can never be power of 2
        if (n <= 0) {
            return false;
        }
        if ((n & (n - 1)) == 0) {
            return true;
        }
        return false;
    }
    // Time Complexity : O(1)
    // Space Complexity : O(1)

    // Normal method
    public boolean isPowerOfTwo2(int n) {
        int exponentialNumber = 0;
        double ans = 0;

        while (ans <= n) {
            ans = Math.pow(2, exponentialNumber);
            if (ans == (double) n) {
                return true;
            }
            exponentialNumber++;
        }
        return false;
    }
    // Time Complexity : O(logn)
    // Space Complexity : O(1)
}
