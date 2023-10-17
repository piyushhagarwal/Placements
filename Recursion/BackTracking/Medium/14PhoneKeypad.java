// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

// Example 1:

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// Example 2:

// Input: digits = ""
// Output: []
// Example 3:

// Input: digits = "2"
// Output: ["a","b","c"]

//Link : https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

package Recursion.BackTracking.Medium;

import java.util.ArrayList;
import java.util.List;

class Solution {

    // Method to solve the phone keypad problem recursively
    public static void solve(String digits, int index, List<String> result, StringBuffer substr, String map[]) {
        // Base case: If we have processed all digits, add the current combination to
        // the result
        if (index >= digits.length()) {
            result.add((new StringBuffer(substr).toString()));
            return;
        }

        // Get the current digit and its corresponding letters on the keypad
        int element = digits.charAt(index) - '0';
        String letters = map[element];

        // Iterate through each letter and explore combinations
        for (int i = 0; i < letters.length(); i++) {
            // Choose the current letter
            substr.append(letters.charAt(i));

            // Recursively call the solve method for the next digit
            solve(digits, index + 1, result, substr, map);

            // Backtrack: Remove the last letter to explore other possibilities
            substr.deleteCharAt(substr.length() - 1);
        }
    }

    // Main method to generate letter combinations for a given set of digits
    public List<String> letterCombinations(String digits) {
        // Define the mapping of digits to corresponding letters on the keypad
        String map[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        // Initialize variables
        int index = 0;
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        StringBuffer substr = new StringBuffer();

        // Call the solve method to generate combinations
        solve(digits, index, result, substr, map);

        // Return the final list of combinations
        return result;
    }
}