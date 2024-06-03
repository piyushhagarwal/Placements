// Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

// Example 1:

// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[20,9],[15,7]]
// Example 2:

// Input: root = [1]
// Output: [[1]]
// Example 3:

// Input: root = []
// Output: []

// Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
// Solution: https://www.youtube.com/watch?v=s1d8UGDCCN8&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=70&t=933s

package BinaryTrees;

import java.util.ArrayList;
import java.util.Collections;
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
    // Method to perform zigzag level order traversal of a binary tree
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // Initialize the result list to store the traversal
        List<List<Integer>> result = new ArrayList<>();

        // Base case: If the root is null, return an empty result
        if (root == null) {
            return result;
        }

        // Initialize a queue for level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Flag to track the direction of traversal (left to right or right to left)
        boolean leftToRight = true;

        // Perform level order traversal
        while (!queue.isEmpty()) {
            // List to store the values of nodes in the current level
            List<Integer> ans = new ArrayList<>(queue.size());
            int nodesInThisLevel = queue.size(); // We are not directly using queue.size() in the for loop because the
                                                 // queue size changes dynamically as we adding and removing elements
                                                 // from it

            // Process each node in the current level
            for (int i = 0; i < nodesInThisLevel; i++) {
                // Dequeue the node from the front of the queue
                TreeNode poppedNode = queue.poll();

                ans.add(poppedNode.val);

                // Enqueue the left and right children if they exist
                if (poppedNode.left != null) {
                    queue.add(poppedNode.left);
                }
                if (poppedNode.right != null) {
                    queue.add(poppedNode.right);
                }
            }

            // If the leftToRight is false
            Collections.reverse(ans);

            // Add the ans list to the result list
            result.add(new ArrayList<>(ans));

            // Toggle the direction for the next level
            leftToRight = !leftToRight;
        }

        // Return the final result after zigzag level order traversal
        return result;
    }
}
