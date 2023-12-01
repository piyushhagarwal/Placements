package Stacks;

import java.util.ArrayList;
import java.util.Stack;

class nearestSmallestInteger {

    // Approach 1: Brute Force
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        // Create a new ArrayList to store the results
        ArrayList<Integer> ans = new ArrayList<>();

        // The first element always has no previous smaller element, so add -1 to the
        // result list
        ans.add(-1);

        // Iterate through the elements of the input ArrayList starting from the second
        // element
        for (int i = 1; i < A.size(); i++) {
            // Flag to check if a previous smaller element is found for the current element
            boolean isPresent = false;

            // Iterate backward through the elements before the current element
            for (int j = i - 1; j >= 0; j--) {
                // Check if the element at index j is smaller than the current element at index
                // i
                if (A.get(j) < A.get(i)) {
                    // If found, add the smaller element to the result list and set the flag to true
                    ans.add(A.get(j));
                    isPresent = true;
                    break;
                }
            }

            // If no previous smaller element is found, add -1 to the result list
            if (!isPresent) {
                ans.add(-1);
            }
        }

        // Return the final result list
        return ans;
    }

    // Approach 2: Using Stack
    public ArrayList<Integer> prevSmaller1(ArrayList<Integer> A) {
        // Create a new ArrayList to store the results
        ArrayList<Integer> ans = new ArrayList<>();

        // Create a stack to keep track of previous smaller elements
        Stack<Integer> stack = new Stack<>();

        // Push a sentinel value (-1) to the stack to handle the case when there is no
        // previous smaller element
        stack.push(-1);

        // Iterate through the elements of the input ArrayList
        for (int i = 0; i < A.size(); i++) {
            // Keep popping elements from the stack while they are greater than or equal to
            // the current element
            while (stack.peek() >= A.get(i)) {
                stack.pop();
            }

            // Add the current top of the stack to the result list, representing the
            // previous smaller element
            ans.add(stack.peek());

            // Push the current element to the stack for future comparisons
            stack.push(A.get(i));
        }

        // Return the final result list
        return ans;
    }

}
