// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

// Example 1:

// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]
// Example 2:

// Input: root = [1]
// Output: [[1]]
// Example 3:

// Input: root = []
// Output: []

// Link : https://leetcode.com/problems/binary-tree-level-order-traversal/
// Solution : https://www.youtube.com/watch?v=5NiXlPrLslg&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=67

package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a binary tree node.
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Step 1: Create a list to store the result
        List<List<Integer>> ans = new ArrayList<>();

        // Step 2: Check if the root is null, return an empty list if so
        if (root == null) {
            return ans;
        }

        // Step 3: Create a queue for level-order traversal
        Queue<TreeNode> queue = new LinkedList<>();

        // Step 4: Enqueue the root and a null marker to signify the end of a level
        queue.add(root);
        queue.add(null);

        // Step 5: Create a list to store nodes at the current level
        List<Integer> levelNodesList = new ArrayList<>();

        // Step 6: Perform level-order traversal using the queue
        while (!queue.isEmpty()) {
            // Step 7: Pop a node
            TreeNode poppedElement = queue.poll();

            // Step 8: Check if the node is null (end of level)
            if (poppedElement == null) {
                // Add the nodes at the current level to the result
                ans.add(new ArrayList<>(levelNodesList));
                levelNodesList = new ArrayList<>();

                // If the queue is not empty, push a null marker for the next level
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                // Step 9: Add the value of the node to the current level's list
                levelNodesList.add(poppedElement.val);

                // Step 10: Push the left and right children if they exist
                if (poppedElement.left != null) {
                    queue.add(poppedElement.left);
                }

                if (poppedElement.right != null) {
                    queue.add(poppedElement.right);
                }
            }
        }

        // Step 11: Return the final result
        return ans;
    }
}
