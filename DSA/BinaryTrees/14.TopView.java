// Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

//        1
//     /     \
//    2       3
//   /  \    /   \
// 4    5  6      7

// Top view will be: 4 2 1 3 7
// Note: Return nodes from leftmost node to rightmost node. Also if 2 nodes are outside the shadow of the tree and are at same position then consider the left ones only(i.e. leftmost). 
// For ex - 1 2 3 N 4 5 N 6 N 7 N 8 N 9 N N N N N will give 8 2 1 3 as answer. Here 8 and 9 are on the same position but 9 will get shadowed.

// Example 1:

// Input:
//       1
//    /    \
//   2      3
// Output: 2 1 3
// Example 2:

// Input:
//        10
//     /      \
//   20        30
//  /   \    /    \
// 40   60  90    100
// Output: 40 20 10 30 100
// Your Task:
// Since this is a function problem. You don't have to take input. Just complete the function topView() that takes root node as parameter and returns a list of nodes visible from the top view from left to right.

// Expected Time Complexity: O(NlogN)
// Expected Auxiliary Space: O(N).

// Link : https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1#
// Solution : // Solution : https://www.youtube.com/watch?v=s1d8UGDCCN8&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=70

package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

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

            // If the level is not already in the map, add the node's data to the map
            if (!map.containsKey(level)) {
                map.put(level, node.data);
            }

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
