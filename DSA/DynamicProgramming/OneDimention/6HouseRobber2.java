// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

// Example 1:

// Input: nums = [2,3,2]
// Output: 3
// Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
// Example 2:

// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.
// Example 3:

// Input: nums = [1,2,3]
// Output: 3

//Link: https://leetcode.com/problems/house-robber-ii/
//Solution: https://www.youtube.com/watch?v=Fe2GeXEzWM0&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=5

//It is similar to the last problem but with a twist that the first and last house are adjacent. So we can either include the first house or the last house. So we will run the same code twice, once by excluding the first house and once by excluding the last house. And then we will return the maximum of the two.
package DynamicProgramming.OneDimention;

class Solution {
    public int solve(int[] nums, int index, int[] dp) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        // Include
        int include = solve(nums, index + 2, dp) + nums[index];

        // Exclude
        int exclude = solve(nums, index + 1, dp);

        dp[index] = Math.max(include, exclude);
        return dp[index];
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] nums1 = new int[nums.length - 1]; // Exclude the last house
        int[] nums2 = new int[nums.length - 1]; // Exclude the first house

        for (int i = 0; i < nums.length - 1; i++) {
            nums1[i] = nums[i];
            nums2[i] = nums[i + 1];
        }

        int[] dp1 = new int[nums1.length];
        int[] dp2 = new int[nums2.length];

        for (int i = 0; i < dp1.length; i++) {
            dp1[i] = -1;
            dp2[i] = -1;
        }

        int nums1Ans = solve(nums1, 0, dp1);
        int nums2Ans = solve(nums2, 0, dp2);

        return Math.max(nums1Ans, nums2Ans);
    }
}