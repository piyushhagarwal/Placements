// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

// The overall run time complexity should be O(log (m+n)).

// Example 1:

// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.
// Example 2:

// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

// Link: https://leetcode.com/problems/median-of-two-sorted-arrays/
// Solution Link: https://www.youtube.com/watch?v=F9c7LpRZWVQ

package BinarySearch;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int onLeftSide = (n1 + n2) / 2;
        if (n2 < n1) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0;
        int high = n1;

        while (low <= high) {
            int mid1 = low + (high - low) / 2; // Number of elements from the first array
            int mid2 = onLeftSide - mid1; // Number of elements from the second array

            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;

            int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 1) {
                    return Math.min(r1, r2);
                } else {
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2);
                }
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return 0;

    }
}
