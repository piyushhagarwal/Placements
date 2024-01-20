// Given an integer array nums, return the length of the longest strictly increasing 
// subsequence

// Example 1:

// Input: nums = [10,9,2,5,3,7,101,18]
// Output: 4

// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
// Example 2:

// Input: nums = [0,1,0,3,2,3]
// Output: 4

// Example 3:

// Input: nums = [7,7,7,7,7,7,7]
// Output: 1

// Link : https://leetcode.com/problems/longest-increasing-subsequence/
// Solution : https://www.youtube.com/watch?v=ekcwMsSIzVc

package DynamicProgramming.LIS;

// By recursion
class Solution {
    public int solve(int currIndex, int prevIndex, int[] nums) {
        if (currIndex >= nums.length) {
            return 0;
        }

        int include = Integer.MIN_VALUE;
        // If the last element we included is less than the current element then only
        // include current element
        if (prevIndex == -1 || nums[prevIndex] < nums[currIndex]) {
            include = 1 + solve(currIndex + 1, currIndex, nums); // prevIndex will be currIndex now
        }

        int exclude = solve(currIndex + 1, prevIndex, nums);

        return Math.max(include, exclude);
    }

    public int lengthOfLIS(int[] nums) {
        int currIndex = 0;
        int prevIndex = -1; // To keep track of the last element we included
        return solve(currIndex, prevIndex, nums);
    }
}
// Time Complexity : O(2^n)
// Space Complexity : O(n)

// By memoization
class Solution2 {
    public int solve(int currIndex, int prevIndex, int[] nums, int[][] dp) {
        if (currIndex >= nums.length) {
            return 0;
        }

        if (dp[currIndex][prevIndex + 1] != Integer.MIN_VALUE) { // Here we are using prevIndex + 1 because prevIndex
                                                                 // can be -1 so we are increasing the scale by 1
            return dp[currIndex][prevIndex + 1];
        }

        int include = Integer.MIN_VALUE;
        // If the last element we included is less than the current element then only
        // include current element
        if (prevIndex == -1 || nums[prevIndex] < nums[currIndex]) {
            include = 1 + solve(currIndex + 1, currIndex, nums, dp);
        }

        int exclude = solve(currIndex + 1, prevIndex, nums, dp);

        dp[currIndex][prevIndex + 1] = Math.max(include, exclude);
        return dp[currIndex][prevIndex + 1];
    }

    public int lengthOfLIS(int[] nums) {
        int currIndex = 0;
        int prevIndex = -1;
        int dp[][] = new int[nums.length][nums.length + 1]; // Here we are using nums.length + 1 because prevIndex can
                                                            // be -1 so we are increasing the scale by 1
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length + 1; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        return solve(currIndex, prevIndex, nums, dp);
    }
}
// Time Complexity : O(n * n)
// Space Complexity : O(n * n)

// By algorithm
class Solution3 {
    public int lengthOfLIS(int[] nums) {
        // Initializing an array to store the length of LIS ending at each index
        int[] lisLength = new int[nums.length];

        // Initializing each element in the lisLength array to 1
        for (int i = 0; i < lisLength.length; i++) {
            lisLength[i] = 1;
        }

        // Variable to store the final result, initially set to 1
        int result = 1;

        // Iterating through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Iterating from the beginning up to the current index
            for (int j = 0; j < i; j++) {
                // Checking if the current element is greater than the element at the j-th index
                if (nums[i] > nums[j]) {
                    // Updating the LIS length at the current index
                    lisLength[i] = Math.max(lisLength[i], lisLength[j] + 1);
                }
            }

            // Updating the final result based on the current LIS length
            result = Math.max(result, lisLength[i]);
        }

        // The 'result' variable now contains the length of the longest increasing
        // subsequence
        return result;
    }
}
