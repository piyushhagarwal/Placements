// A conveyor belt has packages that must be shipped from one port to another within days days.

// The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

// Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.

// Example 1:

// Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
// Output: 15
// Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
// 1st day: 1, 2, 3, 4, 5
// 2nd day: 6, 7
// 3rd day: 8
// 4th day: 9
// 5th day: 10

// Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
// Example 2:

// Input: weights = [3,2,2,4,1,4], days = 3
// Output: 6
// Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
// 1st day: 3, 2
// 2nd day: 2, 4
// 3rd day: 1, 4
// Example 3:

// Input: weights = [1,2,3,1,1], days = 4
// Output: 3
// Explanation:
// 1st day: 1
// 2nd day: 2
// 3rd day: 3
// 4th day: 1, 1

// Link: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
// Solution: https://www.youtube.com/watch?v=MG-Ac4TAvTY

package BinarySearch.OnAnswers;

class CapacityToShipPakage {
    // Helper function to find the number of days required to ship the weights with
    // a given capacity
    public int FindDays(int[] weights, int capacity) {
        int ans = 0;
        int weightSum = 0;

        for (int weight : weights) {
            // Check if adding the current weight exceeds the capacity
            if ((weightSum + weight) <= capacity) {
                weightSum += weight;
            } else {
                ans++;
                weightSum = weight; // Start a new day with the current weight
            }
        }

        ans++; // A day is added to account for any remaining weights

        return ans;
    }

    // Main function to find the minimum capacity required to ship all weights
    // within a given number of days
    public int shipWithinDays(int[] weights, int days) {
        int start = Integer.MIN_VALUE; // Maximum value from the weights array
        int end = 0; // Sum of all the weights in the array

        // Calculate the total weight and find the maximum weight in the array
        for (int weight : weights) {
            end += weight;
            if (weight > start) {
                start = weight;
            }
        }

        // Initialize the midpoint for binary search
        int mid = start + (end - start) / 2;

        // Initialize the answer variable to store the result
        int ans = 0;

        // Binary search loop to find the minimum capacity
        while (start <= end) {
            // If the number of days required with the current capacity is greater than the
            // given days,
            // adjust the search range to the right half
            if (FindDays(weights, mid) > days) {
                start = mid + 1;
            }
            // If the number of days is less than or equal to the given days,
            // update the answer and adjust the search range to the left half
            else {
                ans = mid;
                end = mid - 1;
            }
            // Update the midpoint for the next iteration
            mid = start + (end - start) / 2;
        }

        // Return the final answer
        return ans;
    }
}
