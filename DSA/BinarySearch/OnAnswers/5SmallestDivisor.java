// Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

// Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

// The test cases are generated so that there will be an answer.

// Example 1:

// Input: nums = [1,2,5,9], threshold = 6
// Output: 5
// Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
// If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 
// Example 2:

// Input: nums = [44,22,33,11,1], threshold = 5
// Output: 44

// Link : https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
// Solution : https://www.youtube.com/watch?v=UvBKTVaG6U8

package BinarySearch.OnAnswers;

class SmallestDivisor {
    // Helper function to calculate the sum of divisions for an array of numbers
    public int DivisionSum(int[] nums, int divisor) {
        int ans = 0;
        for (int num : nums) {
            // Calculate the division result as a double to include decimal values
            double divisionAns = (double) num / divisor;
            // Add the ceiling value of the division result to the sum
            ans += Math.ceil(divisionAns);
        }
        return ans;
    }

    // Main function to find the smallest divisor such that the sum of divisions is
    // less than or equal to a threshold
    public int smallestDivisor(int[] nums, int threshold) {
        // Initialize the start and end points for binary search
        int start = 1;
        int end = Integer.MIN_VALUE;

        // Find the maximum value in the array to set as the upper limit
        for (int num : nums) {
            if (end < num) {
                end = num;
            }
        }

        // Initialize the midpoint for binary search
        int mid = start + (end - start) / 2;

        // Initialize the answer variable to store the result
        int ans = 0;

        // Binary search loop
        while (start <= end) {
            // If the sum of divisions for the current midpoint is greater than the
            // threshold,
            // adjust the search range to the right half
            if (DivisionSum(nums, mid) > threshold) {
                start = mid + 1;
            }
            // If the sum of divisions is less than or equal to the threshold,
            // update the answer and adjust the search range to the left half
            else {
                ans = mid;
                end = mid - 1;
            }
            // Update the midpoint for the next iteration
            mid = start + (end - start) / 2;
        }

        // Return the final answer
        return ans;
    }
}
