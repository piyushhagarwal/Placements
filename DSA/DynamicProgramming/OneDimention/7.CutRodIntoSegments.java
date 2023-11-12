// Link: https://www.codingninjas.com/studio/problems/cut-into-segments_1214651?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
// Solution: https://www.youtube.com/watch?v=MFAAZW2znv8&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=116&t=365s

package DynamicProgramming.OneDimention;

class Solution {
    public static int solve(int n, int x, int y, int z) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return Integer.MIN_VALUE;
        }

        int a = solve(n - x, x, y, z) + 1;
        int b = solve(n - y, x, y, z) + 1;
        int c = solve(n - z, x, y, z) + 1;

        int ans = Math.max(a, Math.max(b, c));
        return ans;
    }

    public static int solveMem(int n, int x, int y, int z, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return Integer.MIN_VALUE;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int a = solveMem(n - x, x, y, z, dp) + 1;
        int b = solveMem(n - y, x, y, z, dp) + 1;
        int c = solveMem(n - z, x, y, z, dp) + 1;

        dp[n] = Math.max(a, Math.max(b, c));
        return dp[n];
    }

    // Tabulation
    public static int solveTab(int n, int x, int y, int z) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            int a = Integer.MIN_VALUE;
            int b = Integer.MIN_VALUE;
            int c = Integer.MIN_VALUE;
            if (i - x >= 0) {
                a = dp[i - x];
            }
            if (i - y >= 0) {
                b = dp[i - y];
            }
            if (i - z >= 0) {
                c = dp[i - z];
            }
            dp[i] = Math.max(a, Math.max(b, c)) + 1;
        }
        return dp[n];
    }

    // It cant be solved using space optimisation as we need to store the values of
    // the previous subproblems

    public static int cutSegments(int n, int x, int y, int z) {
        // int ans = solve(n, x, y, z);
        // if(ans < 0){
        // return 0;
        // }
        // return ans;

        int dp[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        if (solveMem(n, x, y, z, dp) < 0) {
            return 0;
        }
        return solveMem(n, x, y, z, dp);

    }
}