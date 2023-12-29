// Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

// A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
// Example 1:

// Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
// Output: [[5,4,11,2],[5,8,4,5]]
// Explanation: There are two paths whose sum equals targetSum:
// 5 + 4 + 11 + 2 = 22
// 5 + 8 + 4 + 5 = 22

// Example 2:
// Input: root = [1,2,3], targetSum = 5
// Output: []
// Example 3:

// Input: root = [1,2], targetSum = 0
// Output: []

// Link : https://leetcode.com/problems/path-sum-ii/description/

package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

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
    // Helper function to find paths with the given target sum
    public void helper(TreeNode root, int targetSum, List<Integer> subAns, List<List<Integer>> ans) {
        // Subtract the current node's value from the target sum
        targetSum -= root.val;
        subAns.add(root.val);

        // Check if the current node is a leaf and if the target sum is 0
        if (root.left == null && root.right == null && targetSum == 0) {
            ans.add(new ArrayList<>(subAns)); // Add the current path to the result
            return;
        }

        // Recursively explore the left subtree if it exists
        if (root.left != null) {
            helper(root.left, targetSum, subAns, ans);
            subAns.remove(subAns.size() - 1); // Backtrack: Remove the last element for backtracking
        }

        // Recursively explore the right subtree if it exists
        if (root.right != null) {
            helper(root.right, targetSum, subAns, ans);
            subAns.remove(subAns.size() - 1); // Backtrack: Remove the last element for backtracking
        }
    }

    // Main function to find paths with the given target sum
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();

        // Base Case: If the root is null, return an empty result
        if (root == null) {
            return ans;
        }

        List<Integer> subAns = new ArrayList<>();

        // Call the helper function to find paths with the target sum
        helper(root, targetSum, subAns, ans);

        return ans;
    }
}
