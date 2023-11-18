// There is an integer array nums sorted in ascending order (with distinct values).

// Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

// You must write an algorithm with O(log n) runtime complexity.

// Example 1:

// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
// Example 2:

// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1
// Example 3:

// Input: nums = [1], target = 0
// Output: -1

// Link : https://leetcode.com/problems/search-in-rotated-sorted-array/
// Solution : https://www.youtube.com/watch?v=6z2HK4o8qcU&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=14

// Similar Question(Find Minumum in Rotated Array) : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

package BinarySearch;

//Step 1 : Find the pivot element
//Step 2 : We check if the key is present between pivot and arr[n - 1]
//If yes we apply binary search in arr[pivot] and arr[n - 1]
//Else we apply it on arr[0] and arr[pivot - 1]

class Pivot {
    static int findPivot(int arr[], int n) {
        int start = 0;
        int end = n - 1;
        int mid = start + (end - start) / 2;

        // If the array is not rotated at all
        if (arr[start] < arr[end]) {
            return 0;
        }

        while (start < end) {
            if (arr[mid] >= arr[0]) {
                start = mid + 1;
            } else {
                end = mid;
            }
            mid = start + (end - start) / 2;
        }
        return mid;
    }

    static int binarySearch(int arr[], int start, int end, int key) {
        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }

        return -1;
    }

    static int searchInRotatedArray(int arr[], int key) {
        int n = arr.length - 1;
        int pivot = findPivot(arr, n);
        if (key >= arr[pivot] && key <= arr[arr.length - 1]) {
            return binarySearch(arr, pivot, n - 1, key);
        } else {
            return binarySearch(arr, 0, pivot - 1, key);
        }
    }

    public static void main(String args[]) {
        int arr[] = { 7, 8, 9, 10, 1, 2, 3 };
        System.out.println(searchInRotatedArray(arr, 2));
    }
}
