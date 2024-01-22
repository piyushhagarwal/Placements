// Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

// answer[i] % answer[j] == 0, or
// answer[j] % answer[i] == 0
// If there are multiple solutions, return any of them.

// Example 1:

// Input: nums = [1,2,3]
// Output: [1,2]
// Explanation: [1,3] is also accepted.
// Example 2:

// Input: nums = [1,2,4,8]
// Output: [1,2,4,8]

// Link : https://leetcode.com/problems/largest-divisible-subset/
// Solution : https://www.youtube.com/watch?v=gDuZwBW9VvM

package DynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public void solve(int currIndex, int prevIndex, int[] nums, List<Integer> subAns, List<Integer> ans) {
        // Base Case
        if (currIndex >= nums.length) {
            if (subAns.size() > ans.size()) {
                ans.clear();
                ans.addAll(subAns);
            }
            return;
        }

        // Include
        if ((prevIndex == -1) || (nums[currIndex] % nums[prevIndex] == 0)) {
            subAns.add(nums[currIndex]);
            solve(currIndex + 1, currIndex, nums, subAns, ans);
            subAns.remove(subAns.size() - 1);
        }

        // Exclude
        solve(currIndex + 1, prevIndex, nums, subAns, ans);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Step 1 : Sort the array
        Arrays.sort(nums);

        // Step 2 : Apply logic for longest divisible subsequence
        int currIndex = 0;
        int prevIndex = -1;
        List<Integer> subAns = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        solve(currIndex, prevIndex, nums, subAns, ans);
        return ans;
    }
}
