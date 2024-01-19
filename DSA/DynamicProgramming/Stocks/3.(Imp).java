// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// Find the maximum profit you can achieve. You may complete at most two transactions.

// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

// Example 1:

// Input: prices = [3,3,5,0,0,3,1,4]
// Output: 6
// Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
// Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
// Example 2:

// Input: prices = [1,2,3,4,5]
// Output: 4
// Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
// Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
// Example 3:

// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transaction is done, i.e. max profit = 0.

// Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
// Solution : https://www.youtube.com/watch?v=-uQGzhYj8BQ

// Similar Question : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/ (Imp)

package DynamicProgramming.Stocks;

// By using the same logic as the previous problem, we can solve this problem as well.
// The only difference is that we have to keep track of the number of transactions as well.

// By Recursion
class Solution {
    // Recursive function to find the maximum profit with a maximum capacity
    public int solve(int index, int canBuy, int[] prices, int capacity) {
        // Base case: If the capacity becomes 0 or the index exceeds the array length,
        // return 0
        if (capacity == 0 || index >= prices.length) {
            return 0;
        }

        // If currently allowed to buy stocks
        if (canBuy == 1) {
            // Calculate profit including and excluding the current stock
            int include = solve(index + 1, 0, prices, capacity) - prices[index];
            int exclude = solve(index + 1, 1, prices, capacity) - 0;

            // Return the maximum profit
            return Math.max(include, exclude);
        } else { // If not allowed to buy stocks
            // Calculate profit including and excluding the current stock
            int include = prices[index] + solve(index + 1, 1, prices, capacity - 1); // Transaction is completed
            int exclude = 0 + solve(index + 1, 0, prices, capacity);

            // Return the maximum profit
            return Math.max(include, exclude);
        }
    }

    // Function to initiate the recursive process
    public int maxProfit(int[] prices) {
        // Initial state: Allowed to buy stocks, starting index is 0, maximum capacity
        // is 2
        int canBuy = 1;
        int index = 0;
        int capacity = 2;

        // Call the recursive function and return the result
        return solve(index, canBuy, prices, capacity);
    }
}

// By Memoization
class Solution2 {
    public int solve(int index, int canBuy, int[] prices, int capacity, int[][][] dp) {
        if (capacity == 0) {
            return 0;
        }
        if (index >= prices.length) {
            return 0;
        }

        if (dp[index][canBuy][capacity] != -1) {
            return dp[index][canBuy][capacity];
        }

        if (canBuy == 1) {
            int include = solve(index + 1, 0, prices, capacity, dp) - prices[index];
            int exclude = solve(index + 1, 1, prices, capacity, dp) - 0;
            dp[index][canBuy][capacity] = Math.max(include, exclude);
            return dp[index][canBuy][capacity];
        }

        else {
            int include = prices[index] + solve(index + 1, 1, prices, capacity - 1, dp); // As the transaction is
                                                                                         // completed
            int exclude = 0 + solve(index + 1, 0, prices, capacity, dp);
            dp[index][canBuy][capacity] = Math.max(include, exclude);
            return dp[index][canBuy][capacity];
        }
    }

    public int maxProfit(int[] prices) {
        int canBuy = 1;
        int index = 0;
        int capacity = 2;
        int[][][] dp = new int[prices.length][2][capacity + 1];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k <= capacity; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(index, canBuy, prices, capacity, dp);
    }
}
