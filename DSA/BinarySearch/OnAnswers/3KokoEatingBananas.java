// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

// Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

// Return the minimum integer k such that she can eat all the bananas within h hours.

// Example 1:

// Input: piles = [3,6,7,11], h = 8
// Output: 4
// Example 2:

// Input: piles = [30,11,23,4,20], h = 5
// Output: 30
// Example 3:

// Input: piles = [30,11,23,4,20], h = 6
// Output: 23

// Link : https://leetcode.com/problems/koko-eating-bananas/
// Solution : https://www.youtube.com/watch?v=qyfekrNni90

package BinarySearch.OnAnswers;

class KokoEatingBananas {
    // Function to calculate the total hours required to eat all piles with a given
    // eating speed
    public int findHours(int[] piles, int k) {
        int ans = 0;
        for (int num : piles) {
            // Calculate hours needed for each pile, rounding up to ensure full hours
            double value = (double) num / k;
            ans += Math.ceil(value);
        }
        return ans;
    }

    // Function to find the minimum eating speed to eat all piles within a given
    // time constraint
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Integer.MIN_VALUE; // Initialize end with the minimum possible value

        // Find the maximum pile size in the array
        for (int num : piles) {
            if (num > end) {
                end = num;
            }
        }

        int mid = start + (end - start) / 2; // Initialize mid point for binary search
        int ans = 0; // Variable to store the minimum eating speed

        // Binary search to find the minimum eating speed
        while (start <= end) {
            if (findHours(piles, mid) <= h) {
                // If eating speed is sufficient, update ans and search in the lower half
                ans = mid;
                end = mid - 1;
            } else {
                // If eating speed is not sufficient, search in the higher half
                start = mid + 1;
            }
            mid = start + (end - start) / 2; // Update mid point
        }

        return ans;
    }
}
