package DynamicProgramming.SubSequence;

// By Recursion
class Solution {
    // Recursive function to solve the knapsack problem
    static int solve(int[] weight, int index, int[] value, int n, int maxWeight) {
        // Base case: If we are at the last item
        if (index == n - 1) {
            // Check if the weight of the last item exceeds the available capacity
            if (maxWeight < weight[n - 1]) {
                // If it exceeds, we cannot include it, so return 0
                return 0;
            } else {
                // Otherwise, include the last item's value
                return value[index];
            }
        }

        // Initialize the maximum value if the current item is included
        int include = 0;

        // Check if the weight of the current item is within the available capacity
        if (maxWeight >= weight[index]) {
            // If yes, calculate the total value by including the current item
            include = value[index] + solve(weight, index + 1, value, n, maxWeight - weight[index]);
        }

        // Calculate the maximum value by excluding the current item
        int exclude = solve(weight, index + 1, value, n, maxWeight);

        // Return the maximum value between including and excluding the current item
        return Math.max(include, exclude);
    }

    // Main function to solve the knapsack problem
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int index = 0;

        // Call the recursive solve function
        return solve(weight, index, value, n, maxWeight);
    }
}
// Time Complexity: O(2^n)
// Space Complexity: O(n)

class Solution2 {
    // Recursive function to solve the knapsack problem with memoization
    static int solve(int[] weight, int index, int[] value, int n, int maxWeight, int[][] dp) {
        // Base case: If we are at the last item
        if (index == n - 1) {
            // Check if the weight of the last item is within the available capacity
            if (maxWeight >= weight[n - 1]) {
                // If yes, include the last item's value
                return value[index];
            } else {
                // If not, exclude the last item
                return 0;
            }
        }

        // Check if the result for the current index and remaining weight is already
        // calculated
        if (dp[index][maxWeight] != -1) {
            return dp[index][maxWeight];
        }

        // Initialize the maximum value if the current item is included
        int include = 0;

        // Check if including the current item is feasible based on remaining weight
        if (maxWeight - weight[index] >= 0) {
            // If yes, calculate the total value by including the current item
            include = value[index] + solve(weight, index + 1, value, n, maxWeight - weight[index], dp);
        }

        // Calculate the maximum value by excluding the current item
        int exclude = solve(weight, index + 1, value, n, maxWeight, dp);

        // Memoize the result for the current index and remaining weight
        dp[index][maxWeight] = Math.max(include, exclude);
        return dp[index][maxWeight];
    }

    // Main function to solve the knapsack problem
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int index = 0;

        // Initialize a 2D array for dynamic programming memoization
        int[][] dp = new int[n][maxWeight + 1];

        // Initialize the array with -1 to indicate that the result is not yet
        // calculated
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                dp[i][j] = -1;
            }
        }

        // Call the recursive solve function with memoization
        return solve(weight, index, value, n, maxWeight, dp);
    }
}
// Time Complexity: O(n * maxWeight)
// Space Complexity: O(n * maxWeight + n)