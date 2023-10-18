// Given a string s, partition s such that every 
// substring
//  of the partition is a 
// palindrome
// . Return all possible palindrome partitioning of s.

// Example 1:

// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]
// Example 2:

// Input: s = "a"
// Output: [["a"]]

// Link: https://leetcode.com/problems/palindrome-partitioning/description/
// Solution Link: https://www.youtube.com/watch?v=WBgsABoClE0

package Recursion.BackTracking.Medium;

import java.util.ArrayList;
import java.util.List;

class Solution {

    // Main recursive function to find all palindrome partitions
    public static void solve(String s, int index, List<String> subStr, List<List<String>> result) {
        // Base case: if we have reached the end of the string
        if (index >= s.length()) {
            // Add the current partition to the result
            result.add(new ArrayList<>(subStr));
            return;
        }

        // Explore all possible partitions starting from the current index
        for (int i = index; i < s.length(); i++) {
            // Check if the current substring is a palindrome
            if (checkPalindrome(s, index, i)) {
                // Include the current palindrome substring in the partition
                subStr.add(s.substring(index, i + 1));

                // Recursively explore partitions starting from the next index
                solve(s, i + 1, subStr, result);

                // Backtrack: remove the last added substring to explore other possibilities
                subStr.remove(subStr.size() - 1);
            }
        }
    }

    // Helper function to check if a substring is a palindrome
    public static boolean checkPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                // If characters don't match, the substring is not a palindrome
                return false;
            }
        }
        // If the loop completes, the substring is a palindrome
        return true;
    }

    // Main function to find all palindrome partitions of a string
    public List<List<String>> partition(String s) {
        // Initialize the result list to store all partitions
        List<List<String>> result = new ArrayList<>();

        // Initialize a list to store the current partition
        List<String> subStr = new ArrayList<>();

        // Start the recursive process from the beginning of the string
        int index = 0;
        solve(s, index, subStr, result);

        // Return the final list of partitions
        return result;
    }
}
