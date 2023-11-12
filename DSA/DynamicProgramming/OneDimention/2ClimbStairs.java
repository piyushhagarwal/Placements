// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Example 1:

// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps
// Example 2:

// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step

package DynamicProgramming.OneDimention;

class Solution {

    // Solve by normal recursion
    public static int recursion(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        return recursion(n - 1) + recursion(n - 2);
    }

    // Solve by memoization
    public static int solve(int dp[], int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = solve(dp, n - 1) + solve(dp, n - 2);
        return dp[n];
    }

    // Solve by tabulation
    public static int solve2(int dp[], int n) {
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Solve by tabulation (space optimized)
    public static int solve3(int n) {
        int f0 = 1;
        int f1 = 1;
        int f2 = 1;

        for (int i = 2; i < n + 1; i++) {
            f2 = f1 + f0;
            f0 = f1;
            f1 = f2;
        }

        return f2;
    }

    public static void main(String args[]) {
        int n = 5;
        int dp[] = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = -1;
        }
        System.out.println(recursion(n));
        System.out.println(solve(dp, n));
        System.out.println(solve2(dp, n));
        System.out.println(solve3(n));
    }
}