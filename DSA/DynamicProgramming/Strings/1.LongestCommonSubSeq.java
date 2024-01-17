// Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

// A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

// For example, "ace" is a subsequence of "abcde".
// A common subsequence of two strings is a subsequence that is common to both strings.

// Example 1:

// Input: text1 = "abcde", text2 = "ace" 
// Output: 3  
// Explanation: The longest common subsequence is "ace" and its length is 3.

// Example 2:

// Input: text1 = "abc", text2 = "abc"
// Output: 3
// Explanation: The longest common subsequence is "abc" and its length is 3.

// Example 3:

// Input: text1 = "abc", text2 = "def"
// Output: 0
// Explanation: There is no such common subsequence, so the result is 0.

// Link : https://leetcode.com/problems/longest-common-subsequence/
// Solution : https://www.youtube.com/watch?v=NPZn9jBrX8U

package DynamicProgramming.Strings;

// By Recursion
class Solution {

    public int solve(int i, int j, String text1, String text2) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + solve(i - 1, j - 1, text1, text2);
        } else {
            return Math.max(solve(i - 1, j, text1, text2), solve(i, j - 1, text1, text2));
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int i = text1.length() - 1;
        int j = text2.length() - 1;

        return solve(i, j, text1, text2);
    }
}
// Time Complexity : O(2^n * 2^m)
// Space Complexity : O(n + m)

// By Memoization
class Solution2 {

    public int solve(int i, int j, String text1, String text2, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + solve(i - 1, j - 1, text1, text2, dp);
            return dp[i][j];
        } else {
            dp[i][j] = Math.max(solve(i - 1, j, text1, text2, dp), solve(i, j - 1, text1, text2, dp));
            return dp[i][j];
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int i = text1.length() - 1;
        int j = text2.length() - 1;

        int[][] dp = new int[i + 1][j + 1];

        for (int ii = 0; ii <= i; ii++) {
            for (int jj = 0; jj <= j; jj++) {
                dp[ii][jj] = -1;
            }
        }

        return solve(i, j, text1, text2, dp);
    }
}
// Time Complexity : O(n * m)
// Space Complexity : O(n * m)