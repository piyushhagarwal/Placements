// Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

// The test cases are generated so that the answer can fit in a 32-bit integer.

// Example 1:

// Input: nums = [1,2,3], target = 4
// Output: 7
// Explanation:
// The possible combination ways are:
// (1, 1, 1, 1)
// (1, 1, 2)
// (1, 2, 1)
// (1, 3)
// (2, 1, 1)
// (2, 2)
// (3, 1)
// Note that different sequences are counted as different combinations.
// Example 2:

// Input: nums = [9], target = 3
// Output: 0

// Constraints:

// 1 <= nums.length <= 200
// 1 <= nums[i] <= 1000
// All the elements of nums are unique.
// 1 <= target <= 1000

// Link : https://leetcode.com/problems/combination-sum-iv/
// Solution : https://www.youtube.com/watch?v=Wct0mN2SCRQ&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=120&t=208s

package DynamicProgramming.OneDimention;

class Solution {

    public int Recur(int[] nums, int target) {
        // Base Case
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += Recur(nums, target - nums[i]);
        }

        return ans;
    }

    public int RecurMem(int[] nums, int target, int dp[]) {
        // Base Case
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }

        if (dp[target] != -1) {
            return dp[target];
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += RecurMem(nums, target - nums[i], dp);
        }

        dp[target] = ans;

        return dp[target];
    }

    public int Tabulation(int[] nums, int target) {

        int dp[] = new int[target + 1];
        for (int i = 0; i <= target; i++) {
            dp[i] = 0;
        }

        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }

            }
        }

        return dp[target];
    }

    // Space optimized approach is not possible here because we cant find a clear
    // relation on which the dp[i] depends upon

    public int combinationSum4(int[] nums, int target) {
        // return Recur(nums, target);

        // int dp[] = new int[target + 1];
        // for(int i = 0; i <= target; i++){
        // dp[i] = -1;
        // }
        // return RecurMem(nums, target, dp);

        return Tabulation(nums, target);

    }
}