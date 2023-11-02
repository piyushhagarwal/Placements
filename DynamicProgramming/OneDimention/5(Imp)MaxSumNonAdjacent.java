// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

// Example 1:

// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.
// Example 2:

// Input: nums = [2,7,9,3,1]
// Output: 12
// Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
// Total amount you can rob = 2 + 9 + 1 = 12.

// Link: https://leetcode.com/problems/house-robber/
// Solution: https://www.youtube.com/watch?v=m9-H6AUBLgY&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=4&t=582s

package DynamicProgramming.OneDimention;

class Solution {

    // Recursive solution without memoization
    public int solve(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (index == (nums.length - 1)) {
            return nums[nums.length - 1];
        }

        // Includex
        int include = solve(nums, index + 2) + nums[index];

        // Exclude
        int exclude = solve(nums, index + 1);

        return Math.max(include, exclude);
    }

    // Recursive solution with memoization
    public int solve1(int[] nums, int index, int[] dp) {
        if (index >= nums.length) {
            return 0;
        }
        if (index == (nums.length - 1)) {
            return nums[nums.length - 1];
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        // Include
        int include = solve(nums, index + 2) + nums[index];

        // Exclude
        int exclude = solve(nums, index + 1);

        dp[index] = Math.max(include, exclude);
        return dp[index];
    }

    // Dynamic Programming solution with memoization
    public int solve2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }

        dp[n - 1] = nums[n - 1];
        dp[n - 2] = Math.max(nums[n - 1], nums[n - 2]);
        for (int i = n - 3; i >= 0; i--) {
            int include = dp[i + 2] + nums[i];
            int exclude = dp[i + 1];
            dp[i] = Math.max(include, exclude);
        }

        return dp[0];
    }

    // Optimized Dynamic Programming solution with constant space
    public int solve3(int[] nums) {
        int n = nums.length;
        int last = nums[n - 1];
        int secondLast = Math.max(nums[n - 1], nums[n - 2]);
        int current = 0;
        for (int i = n - 3; i >= 0; i--) {
            int include = last + nums[i];
            int exclude = secondLast;
            current = Math.max(include, exclude);
            last = secondLast;
            secondLast = current;
        }

        return secondLast;
    }

    // Main function to calculate maximum amount that can be robbed
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            return solve3(nums);
        }
    }
}
