// Given a binary tree, print the bottom view from left to right.
// A node is included in bottom view if it can be seen when we look at the tree from bottom.

//                       20
//                     /    \
//                   8       22
//                 /   \        \
//               5      3       25
//                     /   \      
//                   10    14

// For the above tree, the bottom view is 5 10 3 14 25.
// If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. For example, in the below diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.

//                       20
//                     /    \
//                   8       22
//                 /   \     /   \
//               5      3 4     25
//                      /    \      
//                  10       14

// For the above tree the output should be 5 10 4 14 25.

// Note: The Input/Output format and Example given are used for the system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from the stdin/console. The task is to complete the function specified, and not to write the full code.

// Example 1:

// Input:
//        1
//      /   \
//     3     2
// Output: 3 1 2
// Explanation:
// First case represents a tree with 3 nodes
// and 2 edges where root is 1, left child of
// 1 is 3 and right child of 1 is 2.

// Thus nodes of the binary tree will be
// printed as such 3 1 2.
// Example 2:

// Input:
//          10
//        /    \
//       20    30
//      /  \
//     40   60
// Output: 40 20 60 30
// Your Task:
// This is a functional problem, you don't need to care about input, just complete the function bottomView() which takes the root node of the tree as input and returns an array containing the bottom view of the given tree.

// Expected Time Complexity: O(N*logN).
// Expected Auxiliary Space: O(N).

// Link : https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
// Solution : // Solution : https://www.youtube.com/watch?v=s1d8UGDCCN8&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=70

package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Solution {

    // Nested class to represent an element containing a node and its level
    static class Element {
        Node node;
        int level;

        public Element(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // ArrayList to store the result
        ArrayList<Integer> ans = new ArrayList<>();

        // Queue for level order traversal and TreeMap to store top view nodes based on
        // their levels
        Queue<Element> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        // Enqueue the root node with level 0
        queue.add(new Element(root, 0));

        // Perform level order traversal
        while (!queue.isEmpty()) {
            Element poppedElement = queue.poll();
            Node node = poppedElement.node;
            int level = poppedElement.level;

            // Update the TreeMap with the current node and its level (overwriting the value
            // of current level)
            map.put(level, node.data);

            // Enqueue left and right children with updated levels
            if (node.left != null) {
                queue.add(new Element(node.left, level - 1));
            }

            if (node.right != null) {
                queue.add(new Element(node.right, level + 1));
            }
        }

        // Add nodes to the result ArrayList in sorted order of levels
        for (int level : map.keySet()) {
            ans.add(map.get(level));
        }

        return ans;
    }
}
