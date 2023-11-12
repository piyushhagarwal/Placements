//Given a list arr of N integers, return sums of all subsets in it.

// Input:
// N = 2
// arr[] = {2, 3}
// Output:
// 0 2 3 5
// Explanation:
// When no elements is taken then Sum = 0.
// When only 2 is taken then Sum = 2.
// When only 3 is taken then Sum = 3.
// When element 2 and 3 are taken then 
// Sum = 2+3 = 5.

// Input:
// N = 3
// arr = {5, 2, 1}
// Output:
// 0 1 2 3 5 6 7 8

// Link: https://practice.geeksforgeeks.org/problems/subset-sums2234/1

package Recursion.BackTracking.Medium;

import java.util.ArrayList;

class Solution {

    // Function to recursively solve for subset sums
    static void solve(ArrayList<Integer> arr, int N, int index, int sum, ArrayList<Integer> result) {
        // If we have processed all elements, add the current sum to the result and
        // return
        if (index >= N) {
            result.add(sum);
            return;
        }

        // Exclude the current element and move to the next index
        solve(arr, N, index + 1, sum, result);

        // Include the current element and move to the next index
        solve(arr, N, index + 1, sum + arr.get(index), result);
    }

    // Function to calculate subset sums
    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        // Initialize an empty ArrayList to store the subset sums
        ArrayList<Integer> result = new ArrayList<>();

        // Initialize variables for recursion
        int sum = 0;
        int index = 0;

        // Call the solve function to compute subset sums
        solve(arr, N, index, sum, result);

        // Return the final list of subset sums
        return result;
    }
}
