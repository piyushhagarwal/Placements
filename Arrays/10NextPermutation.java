// A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

// For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
// The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

// For example, the next permutation of arr = [1,2,3] is [1,3,2].
// Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
// While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
// Given an array of integers nums, find the next permutation of nums.

// The replacement must be in place and use only constant extra memory.

// Example 1:

// Input: nums = [1,2,3]
// Output: [1,3,2]
// Example 2:

// Input: nums = [3,2,1]
// Output: [1,2,3]
// Example 3:

// Input: nums = [1,1,5]
// Output: [1,5,1]

// Link : https://leetcode.com/problems/next-permutation/

package Arrays;

class NextPermutation {
    public static void nextPermutation(int nums[]) {
        // 1. We find the first element that is smaller than the element to its right
        int n = nums.length;
        int i = n - 2;
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
            i--;
        }

        // If such a pair doesn't exist, it means the array is in descending order, and
        // it is the largest permutation possible.
        // In this case, reverse the entire array to make it the smallest permutation.

        // 2. If such an element is found, find the smallest element to its right that
        // is
        // greater than it
        if (i >= 0) {
            int j = n - 1;
            while (j >= 0) {
                if (nums[j] > nums[i]) {
                    break;
                }
                j--;
            }

            // 3. Swap the numbers
            swap(nums, i, j);
        }

        // 3. Reverse the subarray to the right of nums[i]
        reverse(nums, i + 1);

        // Print the next permutation
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int arr[], int start) {
        int end = arr.length - 1;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
    // In Cpp there is a function next_permutation()
    // void nextPermutation(vector<int>& nums) {
    // next_permutation(nums.begin(),nums.end());
    // }

    public static void main(String args[]) {
        int arr1[] = { 1, 3, 5, 4, 2 };
        int arr2[] = { 1, 2, 3 };
        int arr3[] = { 1, 1 };

        nextPermutation(arr1);
        nextPermutation(arr2);
        nextPermutation(arr3);

    }
}
