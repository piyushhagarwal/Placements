// You are given an array ‘arr’ of size ‘n’ which denotes the position of stalls.
// You are also given an integer ‘k’ which denotes the number of aggressive cows.
// You are given the task of assigning stalls to ‘k’ cows such that the minimum distance between any two of them is the maximum possible.
// Find the maximum possible minimum distance.

// Example 1:
// Input Format: N = 6, k = 4, arr[] = {0,3,4,7,10,9}
// Result: 3
// Explanation: The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions {0, 3, 7, 10}. Here the distances between cows are 3, 4, and 3 respectively. We cannot make the minimum distance greater than 3 in any ways.

package BinarySearch;

import java.util.*;

class Solution {

    static boolean isPossible(int stalls[], int mid, int k) {
        int count = 1;
        int currentLocation = stalls[0];
        for (int i = 0; i < stalls.length; i++) {
            if (stalls[i] - currentLocation >= mid) {
                count++;
                currentLocation = stalls[i];
            }
        }
        if (count < k) {
            return false;
        } else {
            return true;
        }
    }

    public static int aggressiveCows(int[] stalls, int k) {

        Arrays.sort(stalls);

        int start = 1;
        int end = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(stalls, mid, k)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}