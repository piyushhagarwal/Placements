package Stacks;

class Solution {
    // Naive approach
    public int trap(int[] height) {
        // Step 1: Create arrays to store the maximum height to the left and right of
        // each element
        int[] prevMax = new int[height.length];
        int[] nextMax = new int[height.length];

        // Step 2: Calculate the nextMax for each element
        for (int i = 0; i < height.length; i++) {
            int nexMax = Integer.MIN_VALUE;
            for (int j = i; j < height.length; j++) {
                if (height[j] > nexMax) {
                    nexMax = height[j];
                }
            }
            nextMax[i] = nexMax;
        }

        // Step 3: Calculate the prevMax for each element
        for (int i = height.length - 1; i >= 0; i--) {
            int preMax = Integer.MIN_VALUE;
            for (int j = i; j >= 0; j--) {
                if (height[j] > preMax) {
                    preMax = height[j];
                }
            }
            prevMax[i] = preMax;
        }

        // Step 4: Calculate the water trapped at each position and sum up the total
        int waterTrapped = 0;
        for (int i = 0; i < height.length; i++) {
            int waterTrappedPerCell = Math.min(prevMax[i], nextMax[i]) - height[i];
            waterTrapped += Math.max(0, waterTrappedPerCell); // Ensure non-negative value
        }

        // Step 5: Return the total water trapped
        return waterTrapped;
    }

    // Optimized approach
    public int trap1(int[] height) {
        // Step 1: Create arrays to store the maximum height to the left and right of
        // each element
        int[] prevMax = new int[height.length];
        int[] nextMax = new int[height.length];

        // Step 2: Initialize variables to track the maximum height to the left and
        // right
        int preMax = Integer.MIN_VALUE;
        int nexMax = Integer.MIN_VALUE;

        // Step 3: Calculate the maximum height to the left (prevMax) while iterating
        // from left to right
        for (int i = 0; i < height.length; i++) {
            // Update preMax with the maximum height encountered so far
            if (height[i] > preMax) {
                preMax = height[i];
            }
            // Assign the current preMax value to the corresponding index in prevMax array
            prevMax[i] = preMax;
        }

        // Step 4: Calculate the maximum height to the right (nextMax) while iterating
        // from right to left
        for (int i = height.length - 1; i >= 0; i--) {
            // Update nexMax with the maximum height encountered so far
            if (height[i] > nexMax) {
                nexMax = height[i];
            }
            // Assign the current nexMax value to the corresponding index in nextMax array
            nextMax[i] = nexMax;
        }

        // Step 5: Calculate the water trapped at each position and sum up the total
        int waterTrapped = 0;
        for (int i = 0; i < height.length; i++) {
            int waterTrappedPerCell = Math.min(prevMax[i], nextMax[i]) - height[i];
            waterTrapped += Math.max(0, waterTrappedPerCell); // Ensure non-negative value
        }

        // Step 6: Return the total water trapped
        return waterTrapped;
    }

}
