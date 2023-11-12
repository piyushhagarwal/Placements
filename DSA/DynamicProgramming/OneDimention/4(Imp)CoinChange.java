// ou are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

// Example 1:

// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
// Example 2:

// Input: coins = [2], amount = 3
// Output: -1
// Example 3:

// Input: coins = [1], amount = 0
// Output: 0

//Link: https://leetcode.com/problems/coin-change/
// Solution: https://www.youtube.com/watch?v=A3FHNCAkhxE&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=3

package DynamicProgramming.OneDimention;

class Solution {
    int solveRec(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int ans = solveRec(coins, amount - coins[i]);
            if (ans != Integer.MAX_VALUE) {
                min = Math.min(min, ans + 1);
            }
        }

        return min;

    }

    int solveMemo(int[] coins, int amount, int[] dp) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[amount] != -1) {
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int ans = solveMemo(coins, amount - coins[i], dp);
            if (ans != Integer.MAX_VALUE) {
                min = Math.min(min, ans + 1);
            }
        }

        dp[amount] = min;
        return min;

    }

    public int coinChange(int[] coins, int amount) {
        // int ans = solveRec( coins,amount);
        // if(ans == Integer.MAX_VALUE){
        // return -1;
        // }
        // else{
        // return ans;
        // }

        int dp[] = new int[amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            dp[i] = -1;
        }
        int ans = solveMemo(coins, amount, dp);
        if (ans == Integer.MAX_VALUE) {
            return -1;
        } else {
            return ans;
        }

    }
}