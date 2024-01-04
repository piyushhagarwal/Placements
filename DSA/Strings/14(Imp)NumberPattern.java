// You are given a 0-indexed string pattern of length n consisting of the
// characters 'I' meaning increasing and 'D' meaning decreasing.

// A 0-indexed string num of length n + 1 is created using the following
// conditions:

// num consists of the digits '1' to '9', where each digit is used at most once.
// If pattern[i] == 'I', then num[i] < num[i + 1].
// If pattern[i] == 'D', then num[i] > num[i + 1].
// Return the lexicographically smallest possible string num that meets the
// conditions.

// Example 1:

// Input: pattern = "IIIDIDDD"
// Output: "123549876"
// Explanation:
// At indices 0, 1, 2, and 4 we must have that num[i] < num[i+1].
// At indices 3, 5, 6, and 7 we must have that num[i] > num[i+1].
// Some possible values of num are "245639871", "135749862", and "123849765".
// It can be proven that "123549876" is the smallest possible num that meets the
// conditions.
// Note that "123414321" is not possible because the digit '1' is used more than
// once.
// Example 2:

// Input: pattern = "DDD"
// Output: "4321"
// Explanation:
// Some possible values of num are "9876", "7321", and "8742".
// It can be proven that "4321" is the smallest possible num that meets the
// conditions.

// Constraints:

// 1 <= pattern.length <= 8
// pattern consists of only the letters 'I' and 'D'.

// Link : https://leetcode.com/problems/construct-smallest-number-from-di-string/
// Solution : https://www.youtube.com/watch?v=GEqSg0Otq4Y

package Strings;

class Solution {
    // Helper method to reverse a portion of the digitsString
    public void reverse(StringBuffer digitsString, int start, int end) {
        while (start < end) {
            char temp = digitsString.charAt(start);
            digitsString.setCharAt(start, digitsString.charAt(end));
            digitsString.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    // Main method to find the smallest number based on the given pattern
    public String smallestNumber(String pattern) {
        // Calculate the size of the digitsString
        int size = pattern.length() + 1;

        // Initialize digitsString with consecutive numbers from 1 to size
        StringBuffer digitsString = new StringBuffer();
        for (int i = 1; i <= size; i++) {
            digitsString.append(i);
        }

        // Iterate through the pattern to create the smallest number
        int i = 0;
        while (i < size - 1) {
            if (pattern.charAt(i) == 'I') {
                // If 'I' is encountered, move to the next character in pattern
                i++;
            } else {
                // If 'D' is encountered, find the sequence of 'D' and reverse that portion
                int startIndex = i;
                while (i < pattern.length() && pattern.charAt(i) != 'I') {
                    i++;
                }
                // Reverse the portion of digitsString from startIndex to i
                reverse(digitsString, startIndex, i);
            }
        }

        // Convert digitsString to a string and return the result
        return digitsString.toString();
    }

    // Brute force is find all permutations and then check if the permutation
    // satisfies the pattern
}
