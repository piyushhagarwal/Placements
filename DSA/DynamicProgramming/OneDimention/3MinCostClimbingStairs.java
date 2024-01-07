// You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

// You can either start from the step with index 0, or the step with index 1.

// Return the minimum cost to reach the top of the floor.

// Example 1:

// Input: cost = [10,15,20]
// Output: 15
// Explanation: You will start at index 1.
// - Pay 15 and climb two steps to reach the top.
// The total cost is 15.
// Example 2:

// Input: cost = [1,100,1,1,1,100,1,1,100,1]
// Output: 6
// Explanation: You will start at index 0.
// - Pay 1 and climb two steps to reach index 2.
// - Pay 1 and climb two steps to reach index 4.
// - Pay 1 and climb two steps to reach index 6.
// - Pay 1 and climb one step to reach index 7.
// - Pay 1 and climb two steps to reach index 9.
// - Pay 1 and climb one step to reach the top.
// The total cost is 6.

// Link : https://leetcode.com/problems/min-cost-climbing-stairs/
// Solution : https://www.youtube.com/watch?v=S31W3kohFDk

package DynamicProgramming.OneDimention;

class Solution {

    // Solve by normal recursion
    int solve(int[] cost, int n) {
        if (n == 0) {
            return 0; // As it could be the starting point so no cost is required to come to this
                      // point
        }
        if (n == 1) {
            return 0; // As it could be the starting point so no cost is required to come to this
                      // point
        }
        int ans = Math.min(solve(cost, n - 1) + cost[n - 1], solve(cost, n - 2) + cost[n - 2]);
        return ans;
    }

    // Solve by memoization
    int solve2(int[] dp, int[] cost, int n) {
        if (n == 0) {
            dp[0] = 0;
            return dp[0];
        }
        if (n == 1) {
            dp[1] = 0;
            return dp[1];
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = Math.min(solve2(dp, cost, n - 1) + cost[n - 1], solve2(dp, cost, n - 2) + cost[n - 2]);
        return dp[n];

    }

    // Solve by tabulation
    int solve3(int[] cost, int n, int[] dp) {
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return dp[n];

    }

    // Solve by tabulation (space optimized)
    int solve4(int[] cost, int n) {
        int f0 = cost[0];
        int f1 = cost[1];
        int f2 = Math.min(f0, f1);

        for (int i = 2; i < n; i++) {
            f2 = Math.min(f0, f1) + cost[i];
            f0 = f1;
            f1 = f2;
        }

        return Math.min(f1, f0);

    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return Math.min(solve(cost, n - 1), solve(cost, n - 2));
    }
}