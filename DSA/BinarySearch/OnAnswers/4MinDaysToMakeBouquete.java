// You are given an integer array bloomDay, an integer m and an integer k.

// You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

// The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

// Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

// Example 1:

// Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
// Output: 3
// Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
// We need 3 bouquets each should contain 1 flower.
// After day 1: [x, _, _, _, _]   // we can only make one bouquet.
// After day 2: [x, _, _, _, x]   // we can only make two bouquets.
// After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
// Example 2:

// Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
// Output: -1
// Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
// Example 3:

// Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
// Output: 12
// Explanation: We need 2 bouquets each should have 3 flowers.
// Here is the garden after the 7 and 12 days:
// After day 7: [x, x, x, x, _, x, x]
// We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
// After day 12: [x, x, x, x, x, x, x]
// It is obvious that we can make two bouquets in different ways.

// Link : https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
// Solution https://www.youtube.com/watch?v=TXAuxeYBTdg

package BinarySearch.OnAnswers;

class MinDaysToMakeBouquate {
    // Function to check if it is possible to make m bouquets with k flowers each,
    // given a certain day
    public boolean isPossible(int[] bloomDay, int m, int k, int currentDay) {
        int noOfBouquets = 0;
        int count = 0;

        // Loop through bloomDay array to count flowers bloomed on or before currentDay
        for (int day : bloomDay) {
            if (day <= currentDay) {
                count++;
            } else {
                // If the current flower is not bloomed on or before currentDay, calculate
                // bouquets
                noOfBouquets += count / k;
                count = 0;
            }
        }
        noOfBouquets += count / k; // Calculate remaining bouquets

        // Check if the number of bouquets is sufficient
        if (noOfBouquets >= m) {
            return true;
        } else {
            return false;
        }
    }

    // Function to find the minimum number of days required to bloom flowers for
    // making bouquets
    public int minDays(int[] bloomDay, int m, int k) {
        // If it's impossible to make bouquets with the given number of flowers
        if ((long) (m * k) > bloomDay.length) {
            return -1;
        }

        int start = Integer.MAX_VALUE; // Initialize start with the maximum possible value
        int end = Integer.MIN_VALUE; // Initialize end with the minimum possible value

        // Find the minimum and maximum bloom days in the array
        for (int num : bloomDay) {
            if (num < start) {
                start = num;
            }

            if (num > end) {
                end = num;
            }
        }

        int mid = start + (end - start) / 2;
        int ans = -1;

        // Binary search to find the minimum days
        while (start <= end) {
            if (isPossible(bloomDay, m, k, mid)) {
                // If it's possible to make bouquets, update ans and search in the lower half
                ans = mid;
                end = mid - 1;
            } else {
                // If it's not possible to make bouquets, search in the higher half
                start = mid + 1;
            }
            mid = start + (end - start) / 2; // Update mid point
        }

        return ans;
    }
}
