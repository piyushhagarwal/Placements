// Given a binary tree, determine if it is 
// height-balanced. 

// Example 1:

// Input: root = [3,9,20,null,null,15,7]
// Output: true
// Example 2:

// Input: root = [1,2,2,3,3,null,null,4,4]
// Output: false
// Example 3:

// Input: root = []
// Output: true

// Link: https://leetcode.com/problems/balanced-binary-tree/
// Solution : https://www.youtube.com/watch?v=nHMQ33LZ6oA&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=69&t=2250s

package BinaryTrees;

class Solution {

    // Naive method

    // Method to calculate the height of a binary tree
    public int height(TreeNode root) {
        // Base case: If the root is null, return 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate the height of the left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Return the maximum height of the left and right subtrees plus 1 (for the
        // current node)
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Method to check if a binary tree is balanced
    public boolean isBalanced(TreeNode root) {
        // Base case: If the root is null, the tree is balanced
        if (root == null) {
            return true;
        }

        // Recursively check if the left and right subtrees are balanced
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        // Calculate the height difference between the left and right subtrees
        boolean diff = Math.abs(height(root.left) - height(root.right)) <= 1;

        // Check if the current subtree is balanced based on the conditions
        if (left && right && diff) {
            return true;
        } else {
            return false;
        }
    }

    // Optimized method
    // Custom Pair class to store height and balanced information
    class Pair {
        int height;
        boolean isBalanced;

        // Default constructor
        Pair() {
            this.height = 0;
            this.isBalanced = true;
        }

        // Parameterized constructor
        Pair(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }

        // Method to check if a binary tree is balanced (optimized with Pair class)
        public Pair isBalancedOptimized(TreeNode root) {
            // Base case: If the root is null, return a Pair with height 0 and isBalanced
            // true
            if (root == null) {
                Pair pair = new Pair(0, true);
                return pair;
            }

            // Recursively call the method on the left and right subtrees
            Pair left = isBalancedOptimized(root.left);
            Pair right = isBalancedOptimized(root.right);

            // Options for checking balanced property
            boolean op1 = left.isBalanced;
            boolean op2 = right.isBalanced;
            boolean diff = Math.abs(left.height - right.height) <= 1;

            // Create a new Pair to store the result
            Pair ans = new Pair();

            // Calculate the height of the current subtree
            ans.height = Math.max(left.height, right.height) + 1;

            // Check if the current subtree is balanced based on the conditions
            if (op1 && op2 && diff) {
                ans.isBalanced = true;
            } else {
                ans.isBalanced = false;
            }

            // Return the result Pair
            return ans;
        }

        // Method to check if a binary tree is balanced (final result)
        public boolean isBalanced1(TreeNode root) {
            // Return the isBalanced property from the result Pair obtained from the
            // optimized method
            return isBalancedOptimized(root).isBalanced;
        }
    }
}
