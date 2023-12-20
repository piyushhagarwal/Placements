// The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

// By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.

// Example 1:

// Input: n = 3, k = 3
// Output: "213"
// Example 2:

// Input: n = 4, k = 9
// Output: "2314"
// Example 3:

// Input: n = 3, k = 1
// Output: "123"

// Link: https://leetcode.com/problems/permutation-sequence/
// Solution Link: https://www.youtube.com/watch?v=wT7gcXLYoao

package Recursion.BackTracking.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    // Brute force method

    // Method to get the kth permutation of numbers from 1 to n
    public String getPermutation(int n, int k) {
        // Calculate factorial of (n-1) and initialize a list with numbers from 1 to n
        int factorial = 1;

        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            factorial = factorial * i;
            arr.add(i);
        }

        arr.add(n); // Add the last number to the list

        StringBuffer ans = new StringBuffer(); // To store the result
        k = k - 1; // Adjust k to work with zero-based indexing

        // Construct the permutation
        while (true) {
            ans = ans.append(arr.get(k / factorial)); // Append the selected number to the result
            arr.remove(k / factorial); // Remove the selected number from the list

            // Check if all numbers have been used
            if (arr.size() == 0) {
                break;
            }

            k = k % factorial; // Update k for the next iteration
            factorial = factorial / arr.size(); // Update the factorial for the next iteration
        }

        return ans.toString(); // Convert the result to a string and return
    }

    // Bruteforce approach

    // Helper method to generate all permutations of a string
    public void helper(StringBuffer str, int index, List<String> result) {
        // Base case: If index is beyond the length of the string, add the permutation
        // to the result
        if (index >= str.length()) {
            result.add((new StringBuffer(str)).toString());
            return;
        }

        // Iterate over the remaining characters in the string
        for (int i = index; i < str.length(); i++) {
            // Swap the characters at indices i and index
            swap(i, index, str);

            // Recursively generate permutations for the remaining characters
            helper(str, index + 1, result);

            // Undo the swap to backtrack and explore other possibilities
            swap(i, index, str);
        }
    }

    // Method to swap characters at indices i and j in a string
    public void swap(int i, int j, StringBuffer str) {
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);
    }

    // Main method to get the k-th permutation of numbers from 1 to n
    public String getPermutation1(int n, int k) {
        // Create a string with numbers from 1 to n
        StringBuffer str = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            str.append(i);
        }

        // List to store all permutations
        List<String> result = new ArrayList<>();

        // Start generating permutations from index 0
        int index = 0;
        helper(str, index, result);

        // Sort the permutations
        Collections.sort(result);

        // Return the k-th permutation (1-indexed)
        return result.get(k - 1);
    }
}
