// Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

// In one step, you can delete exactly one character in either string.

// Example 1:

// Input: word1 = "sea", word2 = "eat"
// Output: 2
// Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
// Example 2:

// Input: word1 = "leetcode", word2 = "etco"
// Output: 4

// Link : https://leetcode.com/problems/delete-operation-for-two-strings/

package DynamicProgramming.Strings;

class Solution {
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

    public int minDistance(String word1, String word2) {
        int lcs = longestCommonSubsequence(word1, word2);
        int word1Operations = word1.length() - lcs;
        int word2Operations = word2.length() - lcs;

        return word1Operations + word2Operations;
    }
}
