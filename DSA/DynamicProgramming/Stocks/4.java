// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

// After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

// Example 1:

// Input: prices = [1,2,3,0,2]
// Output: 3
// Explanation: transactions = [buy, sell, cooldown, buy, sell]
// Example 2:

// Input: prices = [1]
// Output: 0

// Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

package DynamicProgramming.Stocks;

// Similar to 2nd problem, we can solve this problem as well by using the same logic. Only difference is when we sell the stock we move to index + 2 instead of index + 1. 

class Solution {

    // Recursive function to find the maximum profit
    public int solve(int index, int canBuy, int[] prices) {
        // Base case: If the index exceeds the array length, return 0
        if (index >= prices.length) {
            return 0;
        }

        // If currently allowed to buy stocks
        if (canBuy == 1) {
            // Calculate profit including and excluding the current stock
            int include = solve(index + 1, 0, prices) - prices[index];
            int exclude = solve(index + 1, 1, prices) - 0;

            // Return the maximum profit
            return Math.max(include, exclude);
        } else { // If not allowed to buy stocks
            // Calculate profit including and excluding the current stock
            int include = prices[index] + solve(index + 2, 1, prices);
            int exclude = 0 + solve(index + 1, 0, prices);

            // Return the maximum profit
            return Math.max(include, exclude);
        }
    }

    // Function to initiate the recursive process
    public int maxProfit(int[] prices) {
        // Initial state: Allowed to buy stocks, starting index is 0
        int canBuy = 1;
        int index = 0;

        // Call the recursive function and return the result
        return solve(index, canBuy, prices);
    }
}
// Time Complexity: O(2^n)
// Space Complexity: O(n)

// Memoization
class Solution2 {
    public int solve(int index, int canBuy, int[] prices, int[][] dp) {
        if (index >= prices.length) {
            return 0;
        }

        if (dp[index][canBuy] != -1) {
            return dp[index][canBuy];
        }

        if (canBuy == 1) {
            int include = solve(index + 1, 0, prices, dp) - prices[index];
            int exclude = solve(index + 1, 1, prices, dp) - 0;
            dp[index][canBuy] = Math.max(include, exclude);
            return dp[index][canBuy];
        }

        else {
            int include = prices[index] + solve(index + 2, 1, prices, dp);
            int exclude = 0 + solve(index + 1, 0, prices, dp);
            dp[index][canBuy] = Math.max(include, exclude);
            return dp[index][canBuy];
        }
    }

    public int maxProfit(int[] prices) {
        int canBuy = 1;
        int index = 0;

        int dp[][] = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(index, canBuy, prices, dp);
    }
}

// Time Complexity: O(n * 2)
// Space Complexity: O(n * 2)
