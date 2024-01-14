// You are given ‘n’ items with certain ‘profit’ and ‘weight’ and a knapsack with weight capacity ‘w’.

// You need to fill the knapsack with the items in such a way that you get the maximum profit. You are allowed to take one item multiple times.

// Example:
// Input: 
// 'n' = 3, 'w' = 10, 
// 'profit' = [5, 11, 13]
// 'weight' = [2, 4, 6]

// Output: 27

// Explanation:
// We can fill the knapsack as:

// 1 item of weight 6 and 1 item of weight 4.
// 1 item of weight 6 and 2 items of weight 2.
// 2 items of weight 4 and 1 item of weight 2.
// 5 items of weight 2.

// The maximum profit will be from case 3 = 11 + 11 + 5 = 27. Therefore maximum profit = 27.

// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 3 15
// 7 2 4
// 5 10 20

// Expected Answer:
// 21

// Output on console:
// 21

// Explanation of Sample Input 1
// The given knapsack capacity is 15. We can fill the knapsack as [1, 1, 1] giving us profit 21 and as [1,2] giving us profit 9. Thus maximum profit will be 21.

// Sample Input 2
// 2 3
// 6 12
// 4 17

// Expected Answer:
// 0

// Output on console:
// 0

// Explanation of Sample Input 2:
// We can clearly see that no item has weight less than knapsack capacity. Therefore we can not fill knapsack with any item.

// Link : https://www.codingninjas.com/studio/problems/unbounded-knapsack_1215029
// Solution : https://www.youtube.com/watch?v=OgvOZ6OrJoY

package DynamicProgramming.SubSequence;

import java.util.Arrays;

// By using recursion
class Solution {
    // Recursive function to solve the unbounded knapsack problem
    public static int solve(int index, int n, int w, int[] profit, int[] weight) {
        // Base case: If we have reached the last item
        if (index == n - 1) {
            // Check if the last item can be included in the remaining capacity
            if (weight[index] <= w) {
                // Return the maximum profit by repeating the last item
                return (w / weight[index]) * profit[index];
            } else {
                return 0; // Last item cannot be included, so profit is 0
            }
        }

        // Option 1: Include the current item in the knapsack
        int include = Integer.MIN_VALUE;
        if (w - weight[index] >= 0) {
            // Recursive call to include the current item
            include = profit[index] + solve(index, n, w - weight[index], profit, weight);
        }

        // Option 2: Exclude the current item and move to the next item
        int exclude = solve(index + 1, n, w, profit, weight);

        // Return the maximum profit between including and excluding the current item
        return Math.max(include, exclude);
    }

    // Main function to solve the unbounded knapsack problem
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int index = 0;
        // Call the recursive function to find the maximum profit
        return solve(index, n, w, profit, weight);
    }
}

// By using memoization
class Solution2 {
    // Recursive function to solve the unbounded knapsack problem
    public static int solve(int index, int n, int w, int[] profit, int[] weight, int[][] dp) {
        // Base case: If we have reached the last item
        if (index == n - 1) {
            // Check if the last item can be included in the remaining capacity
            if (weight[index] <= w) {
                // Return the maximum profit by repeating the last item
                return (w / weight[index]) * profit[index];
            } else {
                return 0; // Last item cannot be included, so profit is 0
            }
        }

        // If the subproblem is already solved, return the solution
        if (dp[index][w] != -1) {
            return dp[index][w];
        }

        // Option 1: Include the current item in the knapsack
        int include = Integer.MIN_VALUE;
        if (w - weight[index] >= 0) {
            // Recursive call to include the current item
            include = profit[index] + solve(index, n, w - weight[index], profit, weight, dp);
        }

        // Option 2: Exclude the current item and move to the next item
        int exclude = solve(index + 1, n, w, profit, weight, dp);

        // Return the maximum profit between including and excluding the current item
        return dp[index][w] = Math.max(include, exclude);
    }

    // Main function to solve the unbounded knapsack problem
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int index = 0;
        int[][] dp = new int[n][w + 1];

        // Initialize all values in the dp array with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Call the recursive function to find the maximum profit
        return solve(index, n, w, profit, weight, dp);
    }
}