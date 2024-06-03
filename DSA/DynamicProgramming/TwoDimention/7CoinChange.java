// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

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

// Link : https://leetcode.com/problems/coin-change/

package DynamicProgramming.TwoDimention;

class Solution {
    public int solve(int index, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (index >= coins.length) {
            return 1000000009;
        }

        int include = 1000000009;
        if (amount - coins[index] >= 0) {
            include = solve(index, coins, amount - coins[index]) + 1;
        }

        int exclude = solve(index + 1, coins, amount);

        return Math.min(include, exclude);
    }

    public int coinChange(int[] coins, int amount) {
        int index = 0;
        int ans = solve(index, coins, amount);
        if (ans == 1000000009) {
            return -1;
        } else {
            return ans;
        }
    }
}