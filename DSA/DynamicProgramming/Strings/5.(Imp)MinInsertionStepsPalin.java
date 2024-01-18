// Given a string s. In one step you can insert any character at any index of the string.

// Return the minimum number of steps to make s palindrome.

// A Palindrome String is one that reads the same backward as well as forward.

// Example 1:

// Input: s = "zzazz"
// Output: 0
// Explanation: The string "zzazz" is already palindrome we do not need any insertions.
// Example 2:

// Input: s = "mbadm"
// Output: 2
// Explanation: String can be "mbdadbm" or "mdbabdm".
// Example 3:

// Input: s = "leetcode"
// Output: 5
// Explanation: Inserting 5 characters the string becomes "leetcodocteel".

// Link: https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
// Solution : https://www.youtube.com/watch?v=xPBLEj41rFU&t=7s

package DynamicProgramming.Strings;

class Solution {
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

    public int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }
}
