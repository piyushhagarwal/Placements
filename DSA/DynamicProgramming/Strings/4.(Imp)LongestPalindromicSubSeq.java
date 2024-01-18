// Given a string s, find the longest palindromic subsequence's length in s.

// A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

// Example 1:

// Input: s = "bbbab"
// Output: 4
// Explanation: One possible longest palindromic subsequence is "bbbb".
// Example 2:

// Input: s = "cbbd"
// Output: 2
// Explanation: One possible longest palindromic subsequence is "bb".

// Link: https://leetcode.com/problems/longest-palindromic-subsequence/
// Solution : https://www.youtube.com/watch?v=6i_T5kkfv4A

package DynamicProgramming.Strings;

// By Recursion
class Solution {
    public int solve(int i, int j, StringBuffer str1, StringBuffer str2) {
        if (i == str1.length() || j == str2.length()) {
            return 0;
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            return 1 + solve(i + 1, j + 1, str1, str2);
        } else {
            return Math.max(solve(i + 1, j, str1, str2), solve(i, j + 1, str1, str2));
        }
    }

    public int longestPalindromeSubseq(String s) {
        StringBuffer str1 = new StringBuffer(s);
        StringBuffer str2 = (new StringBuffer(s)).reverse();

        int i = 0;
        int j = 0;

        return solve(i, j, str1, str2);
    }
}

// By Memoization
class Solution2 {
    public int solve(int i, int j, StringBuffer str1, StringBuffer str2, int[][] dp) {
        if (i == str1.length() || j == str2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            dp[i][j] = 1 + solve(i + 1, j + 1, str1, str2, dp);
            return dp[i][j];
        } else {
            dp[i][j] = Math.max(solve(i + 1, j, str1, str2, dp), solve(i, j + 1, str1, str2, dp));
            return dp[i][j];
        }
    }

    public int longestPalindromeSubseq(String s) {
        StringBuffer str1 = new StringBuffer(s);
        StringBuffer str2 = (new StringBuffer(s)).reverse();

        int i = 0;
        int j = 0;

        int[][] dp = new int[str1.length()][str2.length()];

        for (int ii = 0; ii < str1.length(); ii++) {
            for (int jj = 0; jj < str2.length(); jj++) {
                dp[ii][jj] = -1;
            }
        }

        return solve(i, j, str1, str2, dp);
    }
}
