// Given a fence with n posts and k colors, find out the number of ways of painting the fence so that not more than two consecutive posts have the same colors. Since the answer can be large return it modulo 10^9 + 7.
// Link: https://www.codingninjas.com/studio/problems/ninja-and-the-fence_3210208?leftPanelTabValue=SUBMISSION
// Solution: https://www.youtube.com/watch?v=5eFh5CC-8KY&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=118&t=208s
package DynamicProgramming.OneDimention;

class Solution {

    // Driver function to get the modular addition.
    public static int add(int a, int b) {
        int mod = (int) 1e9 + 7;
        return (int) (((long) (a % mod) + (b % mod)) % mod);
    }

    // Driver function to get the modular multiplication.
    public static int mul(int a, int b) {
        int mod = (int) 1e9 + 7;
        return (int) (((long) (a % mod) * (b % mod)) % mod);
    }

    public static int Recur(int n, int k) {
        // Base Case
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            int same = k;
            int different = mul(k, (k - 1));
            return add(same, different);
        }

        int same = mul(Recur(n - 2, k), (k - 1));
        int different = mul(Recur(n - 1, k), (k - 1));

        int ans = add(same, different);
        return ans;
    }

    public static int RecurMem(int n, int k, int[] dp) {
        // Base Case
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            int same = k;
            int different = mul(k, (k - 1));
            return add(same, different);
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        // Inside the method
        int same = mul(RecurMem(n - 2, k, dp), (k - 1));
        int different = mul(RecurMem(n - 1, k, dp), (k - 1));

        dp[n] = add(same, different);
        return dp[n];

    }

    // Tabulation
    public static int tabulation(int n, int k) {
        int dp[] = new int[n + 1];
        dp[1] = k;
        dp[2] = mul(k, (k - 1));

        for (int i = 3; i <= n; i++) {
            int same = mul(dp[i - 2], (k - 1));
            int different = mul(dp[i - 1], (k - 1));
            dp[i] = add(same, different);
        }

        return dp[n];
    }

    // Tabulation Optimized
    public static int optimized(int n, int k) {
        int a = k;
        int b = mul(k, (k - 1));
        int c = 0;

        for (int i = 3; i <= n; i++) {
            c = add(mul(b, (k - 1)), mul(a, (k - 1)));
            a = b;
            b = c;
        }

        return c;
    }

    public static int numberOfWays(int n, int k) {
        // Write your code here.
        // return Recur(n,k);

        int dp[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        return RecurMem(n, k, dp);
    }
}
