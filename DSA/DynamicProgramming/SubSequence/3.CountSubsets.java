package DynamicProgramming.SubSequence;

// Recursion
class Solution {
    public static int solve(int index, int num[], int target) {
        if (target == 0) {
            return 1;
        }
        if (index >= num.length || target < 0) {
            return 0;
        }

        int include = solve(index + 1, num, target - num[index]);
        int exclude = solve(index + 1, num, target);

        return include + exclude;
    }

    public static int findWays(int num[], int tar) {
        // Write your code here.
        int index = 0;
        return solve(index, num, tar);
    }
}

// Memoization
class Solution2 {
    private static final int MOD = 1000000007;

    // Helper method to recursively count the number of ways to achieve the target
    // sum
    public static int solve(int index, int[] num, int target, int[][] dp) {
        // Base cases:

        // If the target sum is reached, return 1 (a way is found)
        if (target == 0) {
            return 1;
        }

        // If the end of the array is reached or the target sum becomes negative, return
        // 0
        if (index >= num.length || target < 0) {
            return 0;
        }

        // If the result for the current index and target sum is already calculated,
        // return it
        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        // Recursive cases:

        // Include the current element in the sum
        int include = solve(index + 1, num, target - num[index], dp) % MOD;

        // Exclude the current element from the sum
        int exclude = solve(index + 1, num, target, dp) % MOD;

        // Count the total number of ways and take modulo to avoid overflow
        dp[index][target] = (include + exclude) % MOD;

        // Return the calculated result for the current index and target sum
        return dp[index][target];
    }

    // Main method to find the number of ways to achieve the target sum
    public static int findWays(int[] num, int tar) {
        // Initialize the starting index
        int index = 0;

        // Initialize a 2D array for dynamic programming memoization
        int[][] dp = new int[num.length][tar + 1];

        // Initialize the array with -1 to indicate that the result is not yet
        // calculated
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < tar + 1; j++) {
                dp[i][j] = -1;
            }
        }

        // Call the recursive solve method to find the number of ways
        return solve(index, num, tar, dp);
    }

    public static void main(String[] args) {
        // Example usage
        int[] arr = { 1, 2, 3, 4 };
        int k = 5;

        int result = findWays(arr, k);
        System.out.println(result);
    }
}
