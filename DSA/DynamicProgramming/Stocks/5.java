// You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.

// Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

// Note:

// You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
// The transaction fee is only charged once for each stock purchase and sale.

// Example 1:

// Input: prices = [1,3,2,8,4,9], fee = 2
// Output: 8
// Explanation: The maximum profit can be achieved by:
// - Buying at prices[0] = 1
// - Selling at prices[3] = 8
// - Buying at prices[4] = 4
// - Selling at prices[5] = 9
// The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
// Example 2:

// Input: prices = [1,3,7,5,10,3], fee = 3
// Output: 6

// Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

package DynamicProgramming.Stocks;

// By Recursion
class Solution {
    // Recursive function to find the maximum profit
    public int solve(int index, int canBuy, int[] prices, int fee) {
        // Base case: If the index exceeds the array length, return 0
        if (index >= prices.length) {
            return 0;
        }

        // If currently allowed to buy stocks
        if (canBuy == 1) {
            // Calculate profit including and excluding the current stock
            int include = solve(index + 1, 0, prices, fee) - prices[index];
            int exclude = solve(index + 1, 1, prices, fee) - 0;

            // Return the maximum profit
            return Math.max(include, exclude);
        } else { // If not allowed to buy stocks
            // Calculate profit including and excluding the current stock
            int include = prices[index] + solve(index + 1, 1, prices, fee) - fee;
            int exclude = 0 + solve(index + 1, 0, prices, fee);

            // Return the maximum profit
            return Math.max(include, exclude);
        }
    }

    public int maxProfit(int[] prices, int fee) {
        // Initial state: Allowed to buy stocks, starting index is 0
        int canBuy = 1;
        int index = 0;

        // Call the recursive function and return the result
        return solve(index, canBuy, prices, fee);
    }
}

// Memoization
class Solution2 {
    public int solve(int index, int canBuy, int[] prices, int[][] dp, int fee) {
        if (index >= prices.length) {
            return 0;
        }

        if (dp[index][canBuy] != -1) {
            return dp[index][canBuy];
        }

        if (canBuy == 1) {
            int include = solve(index + 1, 0, prices, dp, fee) - prices[index];
            int exclude = solve(index + 1, 1, prices, dp, fee) - 0;
            dp[index][canBuy] = Math.max(include, exclude);
            return dp[index][canBuy];
        }

        else {
            int include = prices[index] + solve(index + 1, 1, prices, dp, fee) - fee;
            int exclude = 0 + solve(index + 1, 0, prices, dp, fee);
            dp[index][canBuy] = Math.max(include, exclude);
            return dp[index][canBuy];
        }
    }

    public int maxProfit(int[] prices, int fee) {
        int canBuy = 1;
        int index = 0;

        int dp[][] = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(index, canBuy, prices, dp, fee);
    }
}
