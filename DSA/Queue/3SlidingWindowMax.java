// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

// Return the max sliding window.

// Example 1:

// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation: 
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]

// Link : https://leetcode.com/problems/sliding-window-maximum/
// Link : https://www.youtube.com/watch?v=CZQGRp93K4k

package Queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class SlidingWindowMax {
    // Naive approach
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Calculate the size of the resulting array
        int ansArraySize = nums.length - k + 1;

        // Initialize the array to store the maximum values
        int[] ans = new int[ansArraySize];

        // Iterate through the input array with a sliding window of size k
        for (int i = 0; i <= nums.length - k; i++) {
            // Calculate the ending index of the current window
            int j = i + k - 1;

            // Initialize a variable to track the maximum value in the current window
            int max = Integer.MIN_VALUE;

            // Iterate through the current window to find the maximum value
            for (int index = i; index <= j; index++) {
                // Update max if a larger value is found
                if (nums[index] > max) {
                    max = nums[index];
                }
            }

            // Store the maximum value in the resulting array for the current window
            ans[i] = max;
        }

        // Return the array containing maximum values for each window
        return ans;
    }

    // Optimized approach
    // Remember that the deque stores the indices of the elements
    // The maximum element of the current window is at the front of the deque
    // The elements of the deque are in descending order

    public int[] maxSlidingWindow1(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        // Perform operation for the first window
        deque.addLast(0);
        for (int i = 1; i < k; i++) {
            // Remove elements smaller than the current element from the back of the deque
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            // Add the current index to the deque
            deque.addLast(i);
        }
        // The maximum element of the first window is at the front of the deque
        ans.add(nums[deque.peekFirst()]);

        // Iterate through the rest of the array
        for (int i = k; i < nums.length; i++) {
            // Remove elements that are outside the current window from the front of the
            // deque
            if (deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements smaller than the current element from the back of the deque
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            // Add the current index to the deque
            deque.addLast(i);

            // The maximum element of the current window is at the front of the deque
            ans.add(nums[deque.peekFirst()]);
        }

        // Convert the ArrayList to an array
        int ansArray[] = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ansArray[i] = ans.get(i);
        }

        return ansArray;
    }

}
