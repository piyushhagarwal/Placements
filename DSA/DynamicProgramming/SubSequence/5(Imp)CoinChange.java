// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

// Example 1:

// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
// Example 2:

// Input: coins = [2], amount = 3
// Output: -1
// Example 3:

// Input: coins = [1], amount = 0
// Output: 0

//Link: https://leetcode.com/problems/coin-change/
// Solution: https://www.youtube.com/watch?v=myPeWb3Y68A

package DynamicProgramming.SubSequence;

// By using recursion
class Solution {
    // Recursive function to find the minimum number of coins needed to make the
    // amount
    public int solve(int[] coins, int index, int amount) {
        // Base case: If the amount becomes 0, no more coins are needed
        if (amount == 0) {
            return 0;
        }

        // Base case: If we have checked all available coin denominations
        if (index >= coins.length) {
            // Return a large value to indicate that it's not possible to make the amount
            return Integer.MAX_VALUE - 1;
        }

        // Option 1: Include the current coin in the solution
        int include = Integer.MAX_VALUE - 1;
        if (amount - coins[index] >= 0) {
            // Recursive call to find the solution by including the current coin
            include = 1 + solve(coins, index, amount - coins[index]);
        }

        // Option 2: Exclude the current coin and move to the next coin denomination
        int exclude = solve(coins, index + 1, amount);

        // Return the minimum number of coins needed
        return Math.min(include, exclude);
    }

    // Main function to find the minimum number of coins needed for the amount
    public int coinChange(int[] coins, int amount) {
        int index = 0;
        int ans = solve(coins, index, amount);

        // If the result is the maximum value, it means it's not possible to make the
        // amount
        if (ans == Integer.MAX_VALUE - 1) {
            return -1;
        }

        return ans;
    }
}
// Time Complexity: O(2^n)
// Space COmplexity: O(n)

class Solution2 {
    // Recursive function with memoization to find the minimum number of coins
    // needed
    public int solve(int[] coins, int index, int amount, int[][] dp) {
        // Base case: If the amount becomes 0, no more coins are needed
        if (amount == 0) {
            return 0;
        }

        // Base case: If we have checked all available coin denominations
        if (index >= coins.length) {
            // Return a large value to indicate that it's not possible to make the amount
            return Integer.MAX_VALUE - 1;
        }

        // Check if the result for the current index and amount is already computed
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        // Option 1: Include the current coin in the solution
        int include = Integer.MAX_VALUE - 1;
        if (amount - coins[index] >= 0) {
            // Recursive call to find the solution by including the current coin
            include = 1 + solve(coins, index, amount - coins[index], dp);
        }

        // Option 2: Exclude the current coin and move to the next coin denomination
        int exclude = solve(coins, index + 1, amount, dp);

        // Memoize the result for the current index and amount
        dp[index][amount] = Math.min(include, exclude);
        return dp[index][amount];
    }

    // Main function to find the minimum number of coins needed for the amount
    public int coinChange(int[] coins, int amount) {
        int index = 0;
        int n = coins.length;

        // Initialize a 2D array for dynamic programming memoization
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                // Initialize the array with -1 to indicate that the result is not yet
                // calculated
                dp[i][j] = -1;
            }
        }

        int ans = solve(coins, index, amount, dp);

        // If the result is the maximum value, it means it's not possible to make the
        // amount
        if (ans == Integer.MAX_VALUE - 1) {
            return -1;
        }

        return ans;
    }
}
// Time Complexity: O(n*amount)
// Space Complexity: O(n*amount)