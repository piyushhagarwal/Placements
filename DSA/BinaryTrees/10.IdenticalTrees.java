// Given the roots of two binary trees p and q, write a function to check if they are the same or not.

// Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

// Example 1:

// Input: p = [1,2,3], q = [1,2,3]
// Output: true
// Example 2:

// Input: p = [1,2], q = [1,null,2]
// Output: false
// Example 3:

// Input: p = [1,2,1], q = [1,1,2]
// Output: false

// Link: https://leetcode.com/problems/same-tree/
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

class Solution {
    // Method to check if two binary trees are the same
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: If both nodes are null, they are the same
        if (p == null && q == null) {
            return true;
        }

        // If one of the nodes is null and the other is not, they are not the same
        if (p == null || q == null) {
            return false;
        }

        // Recursively check if the left and right subtrees are the same
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        // Check if the values of the current nodes are the same
        boolean current = p.val == q.val;

        // Return true only if both subtrees and current nodes are the same
        return left && right && current;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
}
