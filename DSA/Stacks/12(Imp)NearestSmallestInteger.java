// Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

// More formally,

//     G[i] for an element A[i] = an element A[j] such that 
//     j is maximum possible AND 
//     j < i AND
//     A[j] < A[i]
// Elements for which no smaller element exist, consider next smaller element as -1.

// Input Format

// The only argument given is integer array A.
// Output Format

// Return the integar array G such that G[i] contains nearest smaller number than A[i].If no such element occurs G[i] should be -1.
// For Example

// Input 1:
//     A = [4, 5, 2, 10, 8]
// Output 1:
//     G = [-1, 4, -1, 2, 2]
// Explaination 1:
//     index 1: No element less than 4 in left of 4, G[1] = -1
//     index 2: A[1] is only element less than A[2], G[2] = A[1]
//     index 3: No element less than 2 in left of 2, G[3] = -1
//     index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
//     index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]

// Input 2:
//     A = [3, 2, 1]
// Output 2:
//     [-1, -1, -1]
// Explaination 2:
//     index 1: No element less than 3 in left of 3, G[1] = -1
//     index 2: No element less than 2 in left of 2, G[2] = -1
//     index 3: No element less than 1 in left of 1, G[3] = -1

// Link : https://www.interviewbit.com/problems/nearest-smaller-element/
// Solution : https://www.youtube.com/watch?v=lJLcqDsmYfg&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=61&t=41s

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

// Similar Problems:
// Nearest Smallest Element to the right
// Nearest Greater Element to the left
// Nearest Greater Element to the right