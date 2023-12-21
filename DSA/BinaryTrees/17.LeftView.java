package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

//Definition for a binary tree node.
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

    // Helper method to traverse the tree and add the rightmost node at each level
    // to the result
    public void helper(int level, TreeNode root, List<Integer> ans) {
        // Base case: If the node is null, return
        if (root == null) {
            return;
        }

        // If the current level is equal to the size of the result list, add the node's
        // value to the list
        if (level == ans.size()) {
            ans.add(root.val);
        }

        // Recursively explore the left and right children with an increased level
        helper(level + 1, root.left, ans);
        helper(level + 1, root.right, ans);
        // Only difference between right side view and left side view is the order of
        // recursive calls
    }

    // Main method to get the right side view of the binary tree
    public List<Integer> rightSideView(TreeNode root) {
        // ArrayList to store the right side view result
        List<Integer> ans = new ArrayList<>();
        int level = 0;

        // Call the helper method to populate the result list
        helper(level, root, ans);

        return ans;
    }
}
