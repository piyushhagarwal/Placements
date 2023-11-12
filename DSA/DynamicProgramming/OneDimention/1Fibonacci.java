package DynamicProgramming.OneDimention;

class Fibonacci {

    // Solve by normal recursion
    public static int fibonacciRecursion(int n) {
        // Base case
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int ans = fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);

        return ans;
    }
    // Time complexity: O(2^n)
    // Space complexity: O(n)

    // Solve by memoization
    public static int fibonacciMemoization(int[] dp, int n) {
        // Base case
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        // Check if already calculated
        if (dp[n] != -1) {
            return dp[n];
        }

        // Calculate and store
        dp[n] = fibonacciMemoization(dp, n - 1) + fibonacciMemoization(dp, n - 2);

        return dp[n];
    }
    // Time complexity: O(n)
    // Space complexity: O(n)

    // Solve by tabulation
    public static int fibonacciTabulation(int[] dp, int n) {

        dp[0] = 0;

        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
    // Time complexity: O(n)
    // Space complexity: O(n)

    // Solve by tabulation (space optimized)
    public static int fibonacciOptimized(int n) {
        int f0 = 0;
        int f1 = 1;
        int f2 = 0;

        for (int i = 2; i < n + 1; i++) {
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }
    // Time complexity: O(n)
    // Space complexity: O(1)

    public static void main(String args[]) {
        int n = 5;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = -1;
        }
        System.out.println(fibonacciRecursion(n));
        // System.out.println(fibonacciMemoization(dp, n));
        System.out.println(fibonacciTabulation(dp, n));
        System.out.println(fibonacciOptimized(n));

    }

}
