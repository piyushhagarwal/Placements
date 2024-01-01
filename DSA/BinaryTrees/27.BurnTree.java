// You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.

// Each minute, a node becomes infected if:

// The node is currently uninfected.
// The node is adjacent to an infected node.
// Return the number of minutes needed for the entire tree to be infected.

// Example 1:

// Input: root = [1,5,3,null,4,10,6,9,2], start = 3
// Output: 4
// Explanation: The following nodes are infected during:
// - Minute 0: Node 3
// - Minute 1: Nodes 1, 10 and 6
// - Minute 2: Node 5
// - Minute 3: Node 4
// - Minute 4: Nodes 9 and 2
// It takes 4 minutes for the whole tree to be infected so we return 4.

// Example 2:

// Input: root = [1], start = 1
// Output: 0
// Explanation: At minute 0, the only node in the tree is infected so we return 0.

// Link : https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
// Solution : https://www.youtube.com/watch?v=XLdpy0_6MR4&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=73&t=5s

package BinaryTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode nodeToParentMapping(TreeNode root, int start, Map<TreeNode, TreeNode> parentMapping) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode targetNode = null;

        queue.add(root);
        parentMapping.put(root, null);

        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();

            if (front.val == start) {
                targetNode = front;
            }

            if (front.left != null) {
                queue.add(front.left);
                parentMapping.put(front.left, front);
            }

            if (front.right != null) {
                queue.add(front.right);
                parentMapping.put(front.right, front);
            }
        }
        return targetNode;
    }

    public int burnTree(TreeNode targetNode, Map<TreeNode, TreeNode> parentMapping) {
        // Make isVisited Map
        Map<TreeNode, Boolean> isVisited = new HashMap<>();

        isVisited.put(targetNode, true);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(targetNode);

        int ans = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            boolean insertionFlag = false;
            for (int i = 0; i < queueSize; i++) {
                TreeNode front = queue.poll();
                if (front.left != null && !isVisited.containsKey(front.left)) {
                    queue.add(front.left);
                    isVisited.put(front.left, true);
                    insertionFlag = true;
                }
                if (front.right != null && !isVisited.containsKey(front.right)) {
                    queue.add(front.right);
                    isVisited.put(front.right, true);
                    insertionFlag = true;
                }
                if (parentMapping.get(front) != null && !isVisited.containsKey(parentMapping.get(front))) {
                    queue.add(parentMapping.get(front));
                    isVisited.put(parentMapping.get(front), true);
                    insertionFlag = true;
                }
            }
            if (insertionFlag) {
                ans++;
            }
        }

        return ans;
    }

    public int amountOfTime(TreeNode root, int start) {
        // Algorithm
        // 1. Find parent mapping of each node
        // 2. Find target node
        // 3. Burn the tree

        if (root.left == null && root.right == null) {
            return 0;
        }
        // Function to make parent mapping and return the target node
        Map<TreeNode, TreeNode> parentMapping = new HashMap<>();
        TreeNode targetNode = nodeToParentMapping(root, start, parentMapping);

        // Function which will return the time to burn the tree
        int ans = burnTree(targetNode, parentMapping);

        return ans;
    }
}
