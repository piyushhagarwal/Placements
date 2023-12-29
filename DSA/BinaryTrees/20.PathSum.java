// Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

// A leaf is a node with no children.

// Example 1:

// Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
// Output: true
// Explanation: The root-to-leaf path with the target sum is shown.

// Example 2:
// Input: root = [1,2,3], targetSum = 5
// Output: false
// Explanation: There two root-to-leaf paths in the tree:
// (1 --> 2): The sum is 3.
// (1 --> 3): The sum is 4.
// There is no root-to-leaf path with sum = 5.
// Example 3:

// Input: root = [], targetSum = 0
// Output: false
// Explanation: Since the tree is empty, there are no root-to-leaf paths.

// Link : https://leetcode.com/problems/path-sum/

package BinaryTrees;

import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    // Helper function to check if there is a path with the given target sum
    public void helper(TreeNode root, int targetSum, ArrayList<Integer> ans) {
        // Subtract the current node's value from the target sum
        targetSum = targetSum - root.val;

        // Check if the current node is a leaf and the target sum is 0
        if (root.left == null && root.right == null && targetSum == 0) {
            ans.add(1); // Add 1 to the ans list to indicate a valid path
            return;
        }

        // Recursively check the left subtree if it exists
        if (root.left != null) {
            helper(root.left, targetSum, ans);
        }

        // Recursively check the right subtree if it exists
        if (root.right != null) {
            helper(root.right, targetSum, ans);
        }
    }

    // Main function to check if there is a path with the given target sum
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base Case: If the root is null, there is no path
        if (root == null) {
            return false;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        helper(root, targetSum, ans);

        // Check if at least one valid path exists
        if (ans.size() >= 1) {
            return true;
        } else {
            return false;
        }
    }
}
