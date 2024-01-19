// You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

// On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

// Find and return the maximum profit you can achieve.

// Example 1:

// Input: prices = [7,1,5,3,6,4]
// Output: 7
// Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
// Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
// Total profit is 4 + 3 = 7.

// Example 2:

// Input: prices = [1,2,3,4,5]
// Output: 4
// Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
// Total profit is 4.

// Example 3:

// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.

// Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
// Solution : https://www.youtube.com/watch?v=nGJmxkUJQGs&t=2s

package DynamicProgramming.Stocks;

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
            int include = prices[index] + solve(index + 1, 1, prices);
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
            int include = prices[index] + solve(index + 1, 1, prices, dp);
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
