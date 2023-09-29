// Given an array arr[] denoting heights of N towers and a positive integer K.

// For each tower, you must perform exactly one of the following operations exactly once.

// Increase the height of the tower by K
// Decrease the height of the tower by K
// Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.

// Note: It is compulsory to increase or decrease the height by K for each tower. After the operation, the resultant array should not contain any negative integers.

// Example 1:

// Input:
// K = 2, N = 4
// Arr[] = {1, 5, 8, 10}
// Output:
// 5
// Explanation:
// The array can be modified as 
// {1+k, 5-k, 8-k, 10-k} = {3, 3, 6, 8}. 
// The difference between 
// the largest and the smallest is 8-3 = 5.
// Example 2:

// Input:
// K = 3, N = 5
// Arr[] = {3, 9, 12, 16, 20}
// Output:
// 11
// Explanation:
// The array can be modified as
// {3+k, 9+k, 12-k, 16-k, 20-k} -> {6, 12, 9, 13, 17}. 
// The difference between 
// the largest and the smallest is 17-6 = 11. 

package Arrays;

import java.util.Arrays;

class MaximizeTheMinimum {
    public static int getMaxDiff(int arr[], int n, int k) {

        // 1. Sort the array
        Arrays.sort(arr);

        // 2. Initial max possible height difference

        int ans = arr[n - 1] - arr[0];

        int tempmin = arr[0];
        int tempmax = arr[n - 1];

        for (int i = 1; i < n; i++) {
            // if on subtracting k we got negative then
            // continue
            if (arr[i] - k < 0) {
                continue;
            }

            // Minimum element when we add k to whole array
            tempmin = Math.min(arr[0] + k, arr[i] - k);

            // Maximum element when we subtract k from whole
            // array

            tempmax = Math.max(arr[i - 1] + k, arr[n - 1] - k);

            ans = Math.min(ans, tempmax - tempmin);
        }
        return ans;

    }

}

// I did not understand this solution.