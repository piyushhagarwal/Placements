// Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

// Example 1:

// Input: temperatures = [73,74,75,71,69,72,76,73]
// Output: [1,1,4,2,1,1,0,0]

// Example 2:

// Input: temperatures = [30,40,50,60]
// Output: [1,1,1,0]

// Example 3:

// Input: temperatures = [30,60,90]
// Output: [1,1,0]

// Link : https://leetcode.com/problems/daily-temperatures/

// Before solving this question solve the previous question

package Stacks;

import java.util.Stack;

class Solution {
    // Method to calculate daily temperatures
    public int[] dailyTemperatures(int[] temperatures) {
        // Using a stack to keep track of temperatures and their indices
        Stack<int[]> stack = new Stack<>();

        // Array to store the final result
        int[] ans = new int[temperatures.length];

        // Push an initial value into the stack to handle edge cases
        stack.push(new int[] { Integer.MAX_VALUE, -1 });

        // Iterate through the temperatures in reverse order
        for (int i = temperatures.length - 1; i >= 0; i--) {
            // Keep popping temperatures from the stack as long as the current temperature
            // is greater than or equal to the temperature at the top of the stack
            while (temperatures[i] >= stack.peek()[0]) {
                stack.pop();
            }

            // If the top of the stack still has the initial value, set the result to 0
            if (stack.peek()[0] == Integer.MAX_VALUE) {
                ans[i] = 0;
            } else {
                // Calculate the difference between the current index and the index of the
                // temperature at the top of the stack
                ans[i] = stack.peek()[1] - i;
            }

            // Push the current temperature and its index into the stack
            stack.push(new int[] { temperatures[i], i });
        }

        // Return the final result
        return ans;
    }
}