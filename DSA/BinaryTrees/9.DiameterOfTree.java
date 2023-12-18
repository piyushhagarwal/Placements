// Given the root of a binary tree, return the length of the diameter of the tree.

// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

// The length of a path between two nodes is represented by the number of edges between them.

// Example 1:

// Input: root = [1,2,3,4,5]
// Output: 3
// Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
// Example 2:

// Input: root = [1,2]
// Output: 1

// Link : https://leetcode.com/problems/diameter-of-binary-tree/
// Solution : https://www.youtube.com/watch?v=nHMQ33LZ6oA&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=69&t=2250s

package BinaryTrees;

// Sample TreeNode class definition
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

// Solution class with methods to calculate height and diameter of a binary tree
class Solution {

    // Naive method

    // Method to calculate the height of a binary tree
    public int heightOfBinaryTree(TreeNode root) {
        // Base case: If the root is null, return 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate the height of the left and right subtrees
        int leftHeight = heightOfBinaryTree(root.left);
        int rightHeight = heightOfBinaryTree(root.right);

        // Return the maximum height of the left and right subtrees plus 1 (for the
        // current node)
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Method to calculate the diameter of a binary tree
    public int diameter(TreeNode root) {
        // Base case: If the root is null, return 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate the diameter of the left and right subtrees
        int op1 = diameter(root.left);
        int op2 = diameter(root.right);

        // Calculate option 3: Diameter passing through the root
        int op3 = heightOfBinaryTree(root.left) + heightOfBinaryTree(root.right) + 1;

        // Return the maximum of the three options
        return Math.max(op1, Math.max(op2, op3));
    }

    // Method to calculate the diameter of a binary tree (final result)
    public int diameterOfBinaryTree(TreeNode root) {
        // Calculate the diameter using the diameter method and subtract 1
        int ans = diameter(root) - 1;

        // Return the final diameter of the binary tree
        return ans;
    }

    // Time Complexity: O(n^2)
    // Space Complexity: O(n)

    // Efficient method
    public int[] optimizedDiameter(TreeNode root) {
        // Base case: If the root is null, return an array with diameter and height both
        // set to 0
        if (root == null) {
            int[] pair = new int[2];
            pair[0] = 0; // Diameter
            pair[1] = 0; // Height
            return pair;
        }

        // Recursively calculate the optimized diameter and height of the left and right
        // subtrees
        int[] left = optimizedDiameter(root.left);
        int[] right = optimizedDiameter(root.right);

        // Options for diameter calculation
        int op1 = left[0]; // Diameter of the left subtree
        int op2 = right[0]; // Diameter of the right subtree
        int op3 = left[1] + right[1] + 1; // Diameter passing through the root

        // Initialize an array to store the result
        int[] ans = new int[2];

        // Calculate the maximum diameter and update height
        ans[0] = Math.max(op1, Math.max(op2, op3));
        ans[1] = Math.max(left[1], right[1]) + 1;

        // Return the result array
        return ans;
    }

    // Method to calculate the diameter of a binary tree (final result)
    public int diameterOfBinaryTree1(TreeNode root) {
        // Calculate the optimized diameter using the optimizedDiameter method and
        // subtract 1
        int ans = optimizedDiameter(root)[0];

        // Return the final diameter of the binary tree
        return ans - 1;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)

}
