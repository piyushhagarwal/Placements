// Given a binary array nums, return the maximum number of consecutive 1's in the array.

// Example 1:

// Input: nums = [1,1,0,1,1,1]
// Output: 3
// Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
// Example 2:

// Input: nums = [1,0,1,1,0,1]
// Output: 2

// Link: https://leetcode.com/problems/max-consecutive-ones/

package Arrays;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnesSoFar = 0;
        int maxOneNow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                maxOneNow = 0;
            } else {
                maxOneNow++;
                if (maxOneNow > maxOnesSoFar) {
                    maxOnesSoFar = maxOneNow;
                }
            }
        }
        return maxOnesSoFar;
    }
}
