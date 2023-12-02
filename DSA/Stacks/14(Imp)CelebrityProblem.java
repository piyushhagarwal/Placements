// A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people, find if there is a celebrity in the party or not.
// A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.
// Note: Follow 0 based indexing.
// Follow Up: Can you optimize it to O(N)
// Example 1:

// Input:
// N = 3
// M[][] = {{0 1 0},
//          {0 0 0}, 
//          {0 1 0}}
// Output: 1
// Explanation: 0th and 2nd person both
// know 1. Therefore, 1 is the celebrity. 

// Example 2:

// Input:
// N = 2
// M[][] = {{0 1},
//          {1 0}}
// Output: -1
// Explanation: The two people at the party both
// know each other. None of them is a celebrity.

// Your Task:
// You don't need to read input or print anything.
// Complete the function celebrity() which takes the matrix M and its size N as input parameters and returns the index of the celebrity.
// If no such celebrity is present, return -1.

// Link: https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1
// Solution : https://www.youtube.com/watch?v=9u2BJfmWNEg&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=62&t=815s

package Stacks;

public class 14CelebrityProblem {
    // Approach 1: Brute Force
    // Function to find the celebrity in a group
    static int findCelebrity(int M[][], int n) {
        // Initialize celebrityIndex to -1 (indicating no celebrity found yet)
        int celebrityIndex = -1;

        // Iterate through each person in the group (rows of the matrix)
        for (int i = 0; i < n; i++) {
            // Check if the column i contains all 1s except for the diagonal element
            boolean condition1 = true;
            for (int j = 0; j < n; j++) {
                if (i != j && M[j][i] != 1) {
                    // If condition1 is violated, set it to false and break
                    condition1 = false;
                    break;
                }
            }

            // If condition1 is true, proceed to the next condition
            if (condition1) {
                // Check if the row i contains all zeros
                boolean condition2 = true;
                for (int j = 0; j < n; j++) {
                    if (M[i][j] != 0) {
                        // If condition2 is violated, set it to false and break
                        condition2 = false;
                        break;
                    }
                }

                // If both conditions are true, update celebrityIndex to i
                if (condition2) {
                    celebrityIndex = i;
                    // Note: There should be only one potential celebrity, so no need to continue checking
                    break;
                }
            }
        }

        // Return the final celebrityIndex (may be -1 if no celebrity is found)
        return celebrityIndex;
    }
    // Time Complexity: O(n^2)

    // Approach 2: Using Stack
    // Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n) {
        Stack<Integer> stack = new Stack<>();

        // Push all celebrities into the stack
        for (int i = 0; i < M.length; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            // Pop top 2 elements from the stack
            int A = stack.pop();
            int B = stack.pop();

            if (M[A][B] == 1) { // A knows B, therefore A cannot be a celebrity
                stack.push(B); // Push the potential celebrity
            } else if (M[B][A] == 1) { // B knows A, therefore B cannot be a celebrity
                stack.push(A);
            }
        }

        int potentialCelebrity = stack.peek();

        // Check if the column contains all 1 and the diagonal element is 0
        for (int j = 0; j < M.length; j++) {
            if (potentialCelebrity == j) {
                continue;
            }
            if (M[j][potentialCelebrity] != 1) {
                return -1; // Not a celebrity
            }
        }

        // Check if the row contains all zeros
        for (int j = 0; j < M.length; j++) {
            if (M[potentialCelebrity][j] != 0) {
                return -1; // Not a celebrity
            }
        }

        return potentialCelebrity; // If both conditions are true, return the potential celebrity
    }
    // Time Complexity: O(n)


    // Example usage
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 0},
            {0, 0, 0},
            {1, 1, 0}
        };
        int n = matrix.length;
        int result = findCelebrity(matrix, n);
        System.out.println("Celebrity index: " + result);
    }
}
