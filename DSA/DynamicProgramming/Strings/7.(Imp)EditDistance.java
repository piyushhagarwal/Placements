// Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

// You have the following three operations permitted on a word:

// Insert a character
// Delete a character
// Replace a character

// Example 1:

// Input: word1 = "horse", word2 = "ros"
// Output: 3
// Explanation: 
// horse -> rorse (replace 'h' with 'r')
// rorse -> rose (remove 'r')
// rose -> ros (remove 'e')
// Example 2:

// Input: word1 = "intention", word2 = "execution"
// Output: 5
// Explanation: 
// intention -> inention (remove 't')
// inention -> enention (replace 'i' with 'e')
// enention -> exention (replace 'n' with 'x')
// exention -> exection (replace 'n' with 'c')
// exection -> execution (insert 'u')

// Link : https://leetcode.com/problems/edit-distance/
// Solution : https://www.youtube.com/watch?v=8HEjwf28LyE

package DynamicProgramming.Strings;

class Solution {
    // Recursive function to calculate the minimum distance between two words
    public int solve(int index1, String word1, int index2, String word2) {
        // If we have reached the end of word1, remaining characters in word2 need to be
        // inserted
        if (index1 == word1.length()) {
            return word2.length() - index2;
        }

        // If we have reached the end of word2, remaining characters in word1 need to be
        // deleted
        if (index2 == word2.length()) {
            return word1.length() - index1;
        }

        // If the current characters in both words are equal, move to the next
        // characters
        if (word1.charAt(index1) == word2.charAt(index2)) {
            return solve(index1 + 1, word1, index2 + 1, word2);
        } else {
            // If the characters are not equal, we have three options: insert, delete, or
            // replace
            // Calculate the minimum distance among these options recursively
            int insert = 1 + solve(index1, word1, index2 + 1, word2);
            int delete = 1 + solve(index1 + 1, word1, index2, word2);
            int replace = 1 + solve(index1 + 1, word1, index2 + 1, word2);

            // Return the minimum distance among insert, delete, and replace options
            return Math.min(insert, Math.min(delete, replace));
        }
    }

    // Entry point for the minimum distance calculation
    public int minDistance(String word1, String word2) {
        int index1 = 0;
        int index2 = 0;

        // Start the recursive calculation from the beginning of both words
        return solve(index1, word1, index2, word2);
    }
}
// Time Complexity : O(3^(m + n))
// Space Complexity : O(m + n)

// By Memoization
class Solution2 {
    public int solve(int index1, String word1, int index2, String word2, int[][] dp) {
        if (index1 == word1.length()) {
            return word2.length() - index2;
        }

        if (index2 == word2.length()) {
            return word1.length() - index1;
        }

        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        if (word1.charAt(index1) == word2.charAt(index2)) {
            dp[index1][index2] = solve(index1 + 1, word1, index2 + 1, word2, dp);
            return dp[index1][index2];
        } else {
            int insert = 1 + solve(index1, word1, index2 + 1, word2, dp);
            int delete = 1 + solve(index1 + 1, word1, index2, word2, dp);
            int replace = 1 + solve(index1 + 1, word1, index2 + 1, word2, dp);
            dp[index1][index2] = Math.min(insert, Math.min(delete, replace));
            return dp[index1][index2];
        }
    }

    public int minDistance(String word1, String word2) {
        int index1 = 0;
        int index2 = 0;
        int[][] dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return solve(index1, word1, index2, word2, dp);
    }
}