// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

// Note that the same word in the dictionary may be reused multiple times in the segmentation.

// Example 1:

// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".
// Example 2:

// Input: s = "applepenapple", wordDict = ["apple","pen"]
// Output: true
// Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
// Note that you are allowed to reuse a dictionary word.
// Example 3:

// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
// Output: false

// Link : https://leetcode.com/problems/word-break/

// Similar question : https://leetcode.com/problems/word-break-ii/

package DynamicProgramming.OneDimention;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Recursive solution to the word break problem
class Solution {
    // Function to recursively solve the word break problem
    public boolean solve(int index, String s, Set<String> dictSet) {
        // Base case: if the index reaches the end of the string, return true
        if (index == s.length()) {
            return true;
        }

        // Temporary buffer to build substrings
        StringBuffer temp = new StringBuffer();

        // Loop through the string starting from the current index
        for (int i = index; i < s.length(); i++) {
            // Build the substring by appending characters
            temp.append(s.charAt(i));

            // If the current substring is in the dictionary set
            if (dictSet.contains(temp.toString())) {
                // Recursively check the rest of the string starting from the next index
                if (solve(i + 1, s, dictSet) == true) {
                    // If the rest of the string can be broken into valid words, return true
                    return true;
                }
            }
        }

        // If no valid word break is found, return false
        return false;
    }

    // Main function to check if the input string can be broken into words from the
    // dictionary
    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert wordDict list to a HashSet for faster lookup
        Set<String> dictSet = new HashSet<>(wordDict);

        // Start solving the word break problem from index 0
        int index = 0;

        // Call the recursive function to check if the word break is possible
        return solve(index, s, dictSet);
    }
}

// By using Memoization
class Solution1 {
    public boolean solve(int index, String s, Set<String> dictSet, int[] dp) {
        if (index == s.length()) {
            return true;
        }

        if (dp[index] != -1) {
            return dp[index] == 1 ? true : false;
        }

        StringBuffer temp = new StringBuffer();
        for (int i = index; i < s.length(); i++) {
            temp.append(s.charAt(i));
            if (dictSet.contains(temp.toString())) {
                if (solve(i + 1, s, dictSet, dp) == true) {
                    dp[i] = 1;
                    return true;
                }
            }
        }
        dp[index] = 0;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictSet = new HashSet<>(wordDict);
        int dp[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = -1;
        }
        int index = 0;
        return solve(index, s, dictSet, dp);
    }
}