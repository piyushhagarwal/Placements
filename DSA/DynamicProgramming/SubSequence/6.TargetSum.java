// You are given an integer array nums and an integer target.

// You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
// Return the number of different expressions that you can build, which evaluates to target.

// Example 1:

// Input: nums = [1,1,1,1,1], target = 3
// Output: 5
// Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
// -1 + 1 + 1 + 1 + 1 = 3
// +1 - 1 + 1 + 1 + 1 = 3
// +1 + 1 - 1 + 1 + 1 = 3
// +1 + 1 + 1 - 1 + 1 = 3
// +1 + 1 + 1 + 1 - 1 = 3
// Example 2:

// Input: nums = [1], target = 1
// Output: 1

// Link : https://leetcode.com/problems/target-sum/

package DynamicProgramming.SubSequence;

// By using recursion
class Solution {
    public int solve(int index, int[] nums, int target) {
        if (index == nums.length) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int add = solve(index + 1, nums, target - nums[index]);
        int subtract = solve(index + 1, nums, target + nums[index]);

        return add + subtract;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int index = 0;
        return solve(index, nums, target);
    }
}
