// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

// Example 1:

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.
// Example 2:

// Input: nums = [0,1,1]
// Output: []
// Explanation: The only possible triplet does not sum up to 0.
// Example 3:

// Input: nums = [0,0,0]
// Output: [[0,0,0]]
// Explanation: The only possible triplet sums up to 0.

// Link: https://leetcode.com/problems/3sum/
// For reference see sorting solution of 2 sum problem https://www.youtube.com/watch?v=7jDS9KQEDbI

package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    // Approach 1: Brute Force
    // Time Complexity: O(n^3)
    // Space Complexity: O(1)
    public List<List<Integer>> threeSum1(int[] nums) {
        // Create a list to store the triplets
        List<List<Integer>> ans = new ArrayList<>();

        // Iterate through the array, considering each element as a potential target
        for (int i = 0; i <= nums.length - 3; i++) {
            // Iterate through the array, considering each element as a potential second
            // element
            for (int j = i + 1; j <= nums.length - 2; j++) {
                // Iterate through the array, considering each element as a potential third
                // element
                for (int k = j + 1; k <= nums.length - 1; k++) {
                    // Check if the current triplet sums up to 0
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        // Create a list to store the triplet
                        List<Integer> subAns = new ArrayList<>();
                        subAns.add(nums[i]);
                        subAns.add(nums[j]);
                        subAns.add(nums[k]);

                        // Add the triplet to the list
                        ans.add(subAns);
                    }
                }
            }
        }

        return ans;
    }

    // Approach 2: Using Pointers and sorting
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public List<List<Integer>> threeSum(int[] nums) {
        // Create a set to store unique triplets
        Set<List<Integer>> set = new HashSet<>();

        // Sort the input array in ascending order
        Arrays.sort(nums);

        // Iterate through the array, considering each element as a potential target
        for (int i = 0; i <= nums.length - 3; i++) {
            // Calculate the target value for the current element
            int target = nums[i] * -1;

            // Set pointers for the start and end of the array
            int start = i + 1;
            int end = nums.length - 1;

            // Explore pairs that sum up to the target value
            while (start < end) {
                // Check if the current pair sums up to the target
                if (nums[start] + nums[end] == target) {
                    // Create a list to store the triplet
                    List<Integer> subAns = new ArrayList<>();
                    subAns.add(nums[i]);
                    subAns.add(nums[start]);
                    subAns.add(nums[end]);

                    // Add the triplet to the set to ensure uniqueness
                    set.add(subAns);

                    // Move the pointers to explore other pairs
                    start++;
                    end--;
                } else if (nums[start] + nums[end] < target) {
                    // If the sum is less than the target, move the start pointer to the right
                    start++;
                } else {
                    // If the sum is greater than the target, move the end pointer to the left
                    end--;
                }
            }
        }

        // Convert the set of unique triplets to a list
        List<List<Integer>> result = new ArrayList<>(set);
        return result;
    }
}
