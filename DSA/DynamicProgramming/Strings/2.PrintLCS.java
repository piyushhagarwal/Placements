// You are given two strings ‘s1’ and ‘s2’.

// Return the longest common subsequence of these strings.

// If there’s no such string, return an empty string. If there are multiple possible answers, return any such string.

// Note:
// Longest common subsequence of string ‘s1’ and ‘s2’ is the longest subsequence of ‘s1’ that is also a subsequence of ‘s2’. A ‘subsequence’ of ‘s1’ is a string that can be formed by deleting one or more (possibly zero) characters from ‘s1’.

// Example:
// Input: ‘s1’  = “abcab”, ‘s2’ = “cbab”

// Output: “bab”

// Explanation:
// “bab” is one valid longest subsequence present in both strings ‘s1’ , ‘s2’.

// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 5 6
// ababa
// cbbcad

// Expected Answer:
// "bba"

// Link : https://www.codingninjas.com/studio/problems/print-longest-common-subsequence_8416383?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

package DynamicProgramming.Strings;

// By Recursion
class Solution {
    public static String solve(int i, int j, String s1, String s2, String ans) {
        if (i >= s1.length() || j >= s2.length()) {
            return "";
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return s1.charAt(i) + solve(i + 1, j + 1, s1, s2, ans);
        } else {
            String sb1 = solve(i + 1, j, s1, s2, ans);
            String sb2 = solve(i, j + 1, s1, s2, ans);
            if (sb1.length() > sb2.length()) {
                return sb1;
            } else {
                return sb2;
            }
        }
    }

    public static String findLCS(int n, int m, String s1, String s2) {
        // Write your code here.
        int i = 0;
        int j = 0;

        String ans = "";
        solve(i, j, s1, s2, ans);
        return ans;
    }
}

// By Memoization
class Solution2 {
    public static String solve(int i, int j, String s1, String s2, String ans, String[][] dp) {
        if (i >= s1.length() || j >= s2.length()) {
            return "";
        }

        if (dp[i][j].equals("-1")) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = s1.charAt(i) + solve(i + 1, j + 1, s1, s2, ans, dp);
            return dp[i][j];
        } else {
            String sb1 = solve(i + 1, j, s1, s2, ans, dp);
            String sb2 = solve(i, j + 1, s1, s2, ans, dp);
            if (sb1.length() > sb2.length()) {
                dp[i][j] = sb1;
                return dp[i][j];
            } else {
                dp[i][j] = sb2;
                return dp[i][j];
            }
        }
    }

    public static String findLCS(int n, int m, String s1, String s2) {
        // Write your code here.
        int i = 0;
        int j = 0;

        String[][] dp = new String[i + 1][j + 1];

        for (int ii = 0; ii <= i; ii++) {
            for (int jj = 0; jj <= j; jj++) {
                dp[ii][jj] = "-1";
            }
        }

        String ans = "";
        solve(i, j, s1, s2, ans, dp);
        return ans;
    }
}
