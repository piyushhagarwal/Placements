// Given a binary tree of size N. Your task is to complete the function sumOfLongRootToLeafPath(), that find the sum of all nodes on the longest path from root to leaf node.
// If two or more paths compete for the longest path, then the path having maximum sum of nodes is being considered.

// Example 1:

// Input: 
//         4        
//        / \       
//       2   5      
//      / \ / \     
//     7  1 2  3    
//       /
//      6
// Output: 13
// Explanation:
//         4        
//        / \       
//       2   5      
//      / \ / \     
//     7  1 2  3 
//       /
//      6

// The highlighted nodes (4, 2, 1, 6) above are 
// part of the longest root to leaf path having
// sum = (4 + 2 + 1 + 6) = 13
// Example 2:

// Input: 
//           1
//         /   \
//        2     3
//       / \   / \
//      4   5 6   7
// Output: 11
// Your Task:
// You don't need to read input or print anything. Your task is to complete the function sumOfLongRootToLeafPath() which takes root node of the tree as input parameter and returns an integer denoting the sum of the longest root to leaf path of the tree. If the tree is empty, return 0.

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(N)

// Link: https://www.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1
// Solution : https://www.youtube.com/watch?v=QG0hE0R_ng4&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=71&t=30s

package BinaryTrees;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}

class Solution {
    // Helper function to traverse the tree and find the sum of the longest
    // root-to-leaf path
    public void helper(Node root, int len, int sum, int[] maxLenSum) {
        // Base Case: If the current node is null
        if (root == null) {
            // Check if the current path is longer than the previously recorded longest path
            if (len > maxLenSum[0]) {
                maxLenSum[0] = len;
                maxLenSum[1] = sum;
            } else if (len == maxLenSum[0]) {
                // If paths have equal length, update maxSum with the larger sum
                maxLenSum[1] = Math.max(sum, maxLenSum[1]);
            }
            return;
        }

        // Add the current node's value to the sum
        sum += root.data;

        // Recursively explore the left subtree
        helper(root.left, len + 1, sum, maxLenSum);
        // Recursively explore the right subtree
        helper(root.right, len + 1, sum, maxLenSum);
    }

    // Main function to calculate the sum of the longest root-to-leaf path
    public int sumOfLongRootToLeafPath(Node root) {
        // Initialize length, sum, and an array to store maxLen and maxSum
        int len = 0;
        int sum = 0;
        int[] maxLenSum = { 0, Integer.MIN_VALUE };

        // Call the helper function to traverse the tree and update maxLenSum
        helper(root, len, sum, maxLenSum);

        // Return the sum of the longest root-to-leaf path
        return maxLenSum[1];
    }
}
