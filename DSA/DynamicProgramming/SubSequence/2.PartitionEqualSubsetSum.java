// Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

// Example 1:

// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].
// Example 2:

// Input: nums = [1,2,3,5]
// Output: false
// Explanation: The array cannot be partitioned into equal sum subsets.

// Link : https://leetcode.com/problems/partition-equal-subset-sum/
// Solution : https://www.youtube.com/watch?v=7win3dcgo3k

package DynamicProgramming.SubSequence;

// By Recursion
class Solution {
    public static boolean solve(int arr[], int index, int n, int k) {
        if (k == 0) {
            return true;
        }
        if (index >= n || k < 0) {
            return false;
        }

        // Include
        boolean include = solve(arr, index + 1, n, k - arr[index]);

        // Exclude
        boolean exclude = solve(arr, index + 1, n, k);

        return include || exclude;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1) {
            return false; // As it cant be divided into 2 subparts
        }

        int target = sum / 2;

        // If we can find one subset of sum target then the nums array can be divided
        // into 2 equal subsets
        return solve(nums, 0, nums.length, target);

    }
}
// Time complexity : O(2^N)
// Space complexity : O(N)

class Solution2 {
    public static boolean solve(int arr[], int index, int n, int k, int[][] dp) {
        if (k == 0) {
            return true;
        }
        if (index >= n || k < 0) {
            return false;
        }

        if (dp[index][k] != -1) {
            if (dp[index][k] == 0) {
                return false;
            } else if (dp[index][k] == 1) {
                return true;
            }
        }

        // Include
        boolean include = solve(arr, index + 1, n, k - arr[index], dp);

        // Exclude
        boolean exclude = solve(arr, index + 1, n, k, dp);

        boolean ans = include || exclude;
        if (ans == true) {
            dp[index][k] = 1;
        } else {
            dp[index][k] = 0;
        }

        return ans;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1) {
            return false; // As it cant be divided into 2 subparts
        }

        int target = sum / 2;

        int dp[][] = new int[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < target + 1; j++) {
                dp[i][j] = -1;
            }
        }

        // If we can find one subset of sum target then the nums array can be divided
        // into 2 equal subsets
        return solve(nums, 0, nums.length, target, dp);

    }
}