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

    public int rob(int[] nums) {
        int nums1[] = new int[nums.length - 1]; // Excluding the first house
        int nums2[] = new int[nums.length - 1]; // Excluding the last house
        // Copying the array
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                // Copying the array except the first element
                nums1[i - 1] = nums[i];
            }

            if (i != nums.length - 1) {
                // Copying the array except the last element
                nums2[i] = nums[i];
            }
        }
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            return Math.max(solve3(nums1), solve3(nums2)); // Returning the maximum of the two
        }
    }
}
