// Given an integer n, return the least number of perfect square numbers that sum to n.

// A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

// Example 1:

// Input: n = 12
// Output: 3
// Explanation: 12 = 4 + 4 + 4.
// Example 2:

// Input: n = 13
// Output: 2
// Explanation: 13 = 4 + 9.

// Constraints:

// 1 <= n <= 104

// Link: https://leetcode.com/problems/perfect-squares/
// Solution: https://www.youtube.com/watch?v=aJTCcyPrPOA&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=121

package DynamicProgramming.OneDimention;

class Solution {
    public int Recur(int n) {
        // Base Case
        if (n <= 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; (i * i) <= n; i++) {
            ans = Math.min(ans, Recur(n - (i * i)) + 1);
        }

        return ans;
    }

    public int RecurMem(int n, int[] dp) {
        // Base Case
        if (n <= 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; (i * i) <= n; i++) {
            ans = Math.min(ans, RecurMem(n - (i * i), dp) + 1);
        }

        dp[n] = ans;

        return dp[n];
    }

    public int Tabulation(int n) {
        int dp[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; (j * j) <= i; j++) {
                if ((i - (j * j)) >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
                }
            }
        }

        return dp[n];

    }

    // Space optimization method is not possible

    public int numSquares(int n) {
        // return Recur(n);

        // int dp[] = new int[n + 1];
        // for(int i = 0; i <= n; i++){
        // dp[i] = -1;
        // }
        // return RecurMem(n,dp);

        return Tabulation(n);
    }
}