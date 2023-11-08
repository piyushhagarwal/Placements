// You are given N balls numbered from 1 to N and there are N baskets numbered from 1 to N in front of you, the ith basket is meant for the ith ball. Calculate the number of ways in which no ball goes into its respective basket.

// Link: https://www.codingninjas.com/studio/problems/count-derangements_873861?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
// Solution: https://www.youtube.com/watch?v=NW-BLDQHFXk&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=117&t=3s

package DynamicProgramming;

class Solution {
    static long recurSolution(int N) {
        // Base case
        if (N == 1) {
            return 0; // If there is only one basket then we cant dearrange the balls
        }
        if (N == 2) {
            return 1; // If there is only two basket then we have only one way to dearrange
        }

        long ans = (N - 1) * ((recurSolution(N - 2)) + (recurSolution(N - 1)));
        return ans;
    }

    static long recurWithMem(int N, long dp[]) {
        // Base case
        if (N == 1) {
            return 0; // If there is only one basket then we cant dearrange the balls
        }
        if (N == 2) {
            return 1; // If there is only two basket then we have only one way to dearrange
        }

        if (dp[N] != -1) {
            return dp[N];
        }

        dp[N] = (N - 1) * ((recurWithMem(N - 2, dp)) + (recurWithMem(N - 1, dp)));
        return dp[N];
    }

    static long tabulation(int N) {
        long dp[] = new long[N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = -1;
        }

        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            long first = dp[i - 1] % 1000000007;
            long second = dp[i - 2] % 1000000007;
            dp[i] = (i - 1) * (first + second) % 1000000007;

        }

        return dp[N];
    }

    static long optimized(int N) {
        long a = 0;
        long b = 1;
        long c = 0;
        for (int i = 3; i <= N; i++) {
            c = (i - 1) * (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return c;
    }

    static long disarrange(int N) {

        // return recurSolution(N);

        // long dp[] = new long[N + 1];
        // for (int i = 0; i <= N; i++){
        // dp[i] = -1;
        // }
        // return recurWithMem(N,dp);

        if (N == 1) {
            return 0;
        }
        if (N == 2) {
            return 1;
        }
        return tabulation(N);
    }

    public static void main(String[] args) {
        int N = 100;
        System.out.println(disarrange(N));
    }
}