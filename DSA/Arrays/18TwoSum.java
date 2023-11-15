
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:

// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:

// Input: nums = [3,3], target = 6
// Output: [0,1]

// Constraints:

// 2 <= nums.length <= 104
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.

// Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

// Link : https://leetcode.com/problems/two-sum/

package Arrays;

import java.util.HashMap;

class TwoSum {
    // Approach 1: Brute Force
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public int[] twoSum1(int[] nums, int target) {
        int[] ans = new int[2];
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int first = nums[i];
            for (int j = i + 1; j < n; j++) {
                int second = nums[j];
                if (first + second == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }

    // Approach 2: Using HashMap
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int[] twoSum2(int[] nums, int target) {
        int[] ans = new int[2];
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int first = nums[i];
            int second = target - first;
            if (map.containsKey(second)) {
                ans[0] = map.get(second);
                ans[1] = i;
                return ans;
            }
            map.put(first, i);
        }
        return ans;
    }
}
