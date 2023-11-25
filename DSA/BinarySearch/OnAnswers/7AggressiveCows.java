// You are given an array ‘arr’ of size ‘n’ which denotes the position of stalls.
// You are also given an integer ‘k’ which denotes the number of aggressive cows.
// You are given the task of assigning stalls to ‘k’ cows such that the minimum distance between any two of them is the maximum possible.
// Find the maximum possible minimum distance.

// Example 1:
// Input Format: N = 6, k = 4, arr[] = {0,3,4,7,10,9}
// Result: 3
// Explanation: The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions {0, 3, 7, 10}. Here the distances between cows are 3, 4, and 3 respectively. We cannot make the minimum distance greater than 3 in any ways.

// Link : https://www.codingninjas.com/studio/problems/aggressive-cows_1082559
// Solution : https://www.youtube.com/watch?v=R_Mfw4ew-Vo&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=18&t=462s

package BinarySearch.OnAnswers;

import java.util.Arrays;

class Solution {

    // Helper function to calculate the number of cows placed with a minimum
    // distance between them
    public static int NumberOfCowsPlaced(int[] stalls, int k, int minDistance) {
        int ans = 1;
        int previousCowStall = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            // Check if the distance between the current stall and the previous cow's stall
            // is greater than or equal to the minimum distance
            if ((stalls[i] - previousCowStall) >= minDistance) {
                ans++;
                previousCowStall = stalls[i];
            }
        }
        return ans;
    }

    // Main function to find the maximum minimum distance for placing k cows
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls); // Sort the stalls array in ascending order
        int start = 1;
        int end = stalls[stalls.length - 1] - stalls[0];

        int mid = start + (end - start) / 2;

        int ans = 0;

        // Binary search loop to find the maximum minimum distance
        while (start <= end) {
            // If the number of cows placed with the current minimum distance is less than
            // k,
            // adjust the search range to the right half
            if (NumberOfCowsPlaced(stalls, k, mid) < k) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
            // Update the midpoint for the next iteration
            mid = start + (end - start) / 2;
        }

        return ans;
    }
}
