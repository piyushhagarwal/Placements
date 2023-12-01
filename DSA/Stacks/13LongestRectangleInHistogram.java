// Given an array of integers heights representing the histograms bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

// Example 1:

// Input: heights = [2,1,5,6,2,3]
// Output: 10
// Explanation: The above is a histogram where width of each bar is 1.
// The largest rectangle is shown in the red area, which has an area = 10 units.
// Example 2:

// Input: heights = [2,4]
// Output: 4

// Link : https://leetcode.com/problems/largest-rectangle-in-histogram/
// Solution : https://www.youtube.com/watch?v=lJLcqDsmYfg&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=61&t=41s

package Stacks;

class LongestRectangleInHistogram {
    // Approach 1: Brute Force
    public int largestRectangleArea(int[] heights) {
        // Variable to store the maximum area, initialized to the smallest possible
        // integer value
        int maxArea = Integer.MIN_VALUE;

        // Iterate through each element in the heights array
        for (int i = 0; i < heights.length; i++) {
            // Variables to track the indices of the previous and next elements
            int prev = i - 1;
            int next = i + 1;

            // Move backward to find the first element smaller than the current element
            while (prev >= 0) {
                if (heights[prev] < heights[i]) {
                    break;
                }
                prev--;
            }

            // Move forward to find the first element smaller than the current element
            while (next < heights.length) {
                if (heights[next] < heights[i]) {
                    break;
                }
                next++;
            }

            // Calculate the height of the rectangle (current element's height)
            int height = heights[i];

            // Calculate the width of the rectangle (distance between the first smaller
            // elements on both sides)
            int width = next - prev - 1;

            // Calculate the area of the rectangle
            int area = height * width;

            // Update the maximum area if the current rectangle has a larger area
            maxArea = Math.max(area, maxArea);
        }

        // Return the maximum area calculated for all rectangles
        return maxArea;
    }

}
