//Best time to buy and sell stock

// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

// Example 1:

// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
// Example 2:

// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transactions are done and the max profit = 0.

// Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

package Arrays;

class BestTImeStock {
    public int maxProfit(int[] prices) {

        int lowestBuyingPrice = Integer.MAX_VALUE; // lsf renamed to lowestBuyingPrice
        int overallProfit = 0; // op renamed to overallProfit
        int currentProfit = 0; // pist renamed to currentProfit

        for (int i = 0; i < prices.length; i++) {
            // Check if the current price is lower than the lowest buying price
            if (prices[i] < lowestBuyingPrice) {
                lowestBuyingPrice = prices[i]; // Update the lowest buying price
            }

            // Calculate the current profit by subtracting the lowest buying price
            currentProfit = prices[i] - lowestBuyingPrice;

            // Check if the current profit is greater than the overall profit
            if (currentProfit > overallProfit) {
                overallProfit = currentProfit; // Update the overall profit
            }
        }

        return overallProfit;
    }
}
