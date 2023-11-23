// You are given a sorted array consisting of only integers where every element
// appears exactly twice, except for one element which appears exactly once.

// Return the single element that appears only once.

// Your solution must run in O(log n) time and O(1) space.

// Example 1:

// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2
// Example 2:

// Input: nums = [3,3,7,7,10,11,11]
// Output: 10

// Link: https://leetcode.com/problems/single-element-in-a-sorted-array/
// Solution : https://www.youtube.com/watch?v=AZOmHuHadxQ

package BinarySearch.OneDArray;

class Solution {

    public int singleNonDuplicate(int[] nums) {
        // Check if the array has only one element
        if (nums.length == 1) {
            return nums[0];
        }

        // Check if the unique element is at the beginning of the array
        if (nums[0] != nums[1]) {
            return nums[0];
        }

        // Check if the unique element is at the end of the array
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }

        // Binary search to find the unique element
        int start = 1;
        int end = nums.length - 2;
        int mid = start + (end - start) / 2;

        while (start <= end) {
            // Check if the middle element is the unique one
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // If the mid is even and the element at mid is equal to the element at mid + 1
            // or if the mid is odd and the element at mid is equal to the element at mid -
            // 1
            // then the unique element is to the right of mid
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                start = mid + 1;
            } else {
                end = end - 1;
            }

            // Update mid
            mid = start + (end - start) / 2;
        }

        // Default case if no unique element is found
        return -1;
    }
}
