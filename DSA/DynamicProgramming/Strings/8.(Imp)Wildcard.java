// Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).
// The matching should cover the entire input string (not partial).

// Example 1:

// Input: s = "aa", p = "a"
// Output: false
// Explanation: "a" does not match the entire string "aa".
// Example 2:

// Input: s = "aa", p = "*"
// Output: true
// Explanation: '*' matches any sequence.
// Example 3:

// Input: s = "cb", p = "?a"
// Output: false
// Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

// Link : https://leetcode.com/problems/wildcard-matching/
// Solution : https://www.youtube.com/watch?v=OgovJ9CB0hI

package DynamicProgramming.Strings;

// By Recursion
class Solution {
    // Recursive function to check if the given substrings match the pattern
    public boolean solve(int index1, String s, int index2, String p) {
        // Base Case: If both strings are exhausted, they match
        if (index1 == s.length() && index2 == p.length()) {
            return true;
        }

        // If pattern is exhausted but string is not, they don't match
        if (index1 < s.length() && index2 == p.length()) {
            return false;
        }

        // If string is exhausted but pattern is not, check if remaining pattern
        // consists only of '*'
        if (index1 == s.length() && index2 < p.length()) {
            for (int k = index2; k < p.length(); k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }

        // Match: Either characters match or pattern has '?'
        if ((s.charAt(index1) == p.charAt(index2)) || p.charAt(index2) == '?') {
            return solve(index1 + 1, s, index2 + 1, p);
        } else if (p.charAt(index2) == '*') {
            // If pattern has '*', it can match either one character in s or be empty
            return solve(index1 + 1, s, index2, p) || solve(index1, s, index2 + 1, p);
        }

        // Doesn't match
        return false;
    }

    // Entry point for checking if the given string matches the pattern
    public boolean isMatch(String s, String p) {
        int index1 = 0;
        int index2 = 0;

        // Start the recursive matching process
        return solve(index1, s, index2, p);
    }
}
// Time Complexity : O(2^(m + n))

// By Memoization
class Solution2 {
    public boolean solve(int index1, String s, int index2, String p, int[][] dp) {
        // Base Case
        if (index1 == s.length() && index2 == p.length()) {
            return true;
        }

        if (index1 < s.length() && index2 == p.length()) {
            return false;
        }

        if (index1 == s.length() && index2 < p.length()) {
            for (int k = index2; k < p.length(); k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (dp[index1][index2] != -1) {
            if (dp[index1][index2] == 1) {
                return true;
            }
            return false;
        }

        // Match
        if ((s.charAt(index1) == p.charAt(index2)) || p.charAt(index2) == '?') {
            boolean condition = solve(index1 + 1, s, index2 + 1, p, dp);
            if (condition) {
                dp[index1][index2] = 1;
            } else {
                dp[index1][index2] = 0;
            }
            return condition;
        } else if (p.charAt(index2) == '*') {
            boolean condition = solve(index1 + 1, s, index2, p, dp) || solve(index1, s, index2 + 1, p, dp);
            if (condition) {
                dp[index1][index2] = 1;
            } else {
                dp[index1][index2] = 0;
            }
            return condition;
        }

        // Doesn't match
        dp[index1][index2] = 0;
        return false;
    }

    public boolean isMatch(String s, String p) {
        int index1 = 0;
        int index2 = 0;
        int[][] dp = new int[s.length()][p.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return solve(index1, s, index2, p, dp);
    }
}