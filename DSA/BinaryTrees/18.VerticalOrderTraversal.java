// Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

// For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

// The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

// Return the vertical order traversal of the binary tree.

// Example 1:

// Input: root = [3,9,20,null,null,15,7]
// Output: [[9],[3,15],[20],[7]]
// Explanation:
// Column -1: Only node 9 is in this column.
// Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
// Column 1: Only node 20 is in this column.
// Column 2: Only node 7 is in this column.
// Example 2:

// Input: root = [1,2,3,4,5,6,7]
// Output: [[4],[2],[1,5,6],[3],[7]]
// Explanation:
// Column -2: Only node 4 is in this column.
// Column -1: Only node 2 is in this column.
// Column 0: Nodes 1, 5, and 6 are in this column.
//           1 is at the top, so it comes first.
//           5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
// Column 1: Only node 3 is in this column.
// Column 2: Only node 7 is in this column.
// Example 3:

// Input: root = [1,2,3,4,6,5,7]
// Output: [[4],[2],[1,5,6],[3],[7]]
// Explanation:
// This case is the exact same as example 2, but with nodes 5 and 6 swapped.
// Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.

// Link : https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
// Solution : https://www.youtube.com/watch?v=s1d8UGDCCN8&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=70

package BinaryTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

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
    class Element {
        TreeNode node;
        int horizontalDistance;
        int level;

        public Element(TreeNode node, int horizontalDistance, int level) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
            this.level = level;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Element> queue = new LinkedList<>();
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();

        queue.add(new Element(root, 0, 0));

        while (!queue.isEmpty()) {
            Element poppedElement = queue.poll();
            TreeNode node = poppedElement.node;
            int horizontalDistance = poppedElement.horizontalDistance;
            int level = poppedElement.level;

            if (map.containsKey(horizontalDistance)) {
                Map<Integer, List<Integer>> subMap = map.get(horizontalDistance);
                if (subMap.containsKey(level)) {
                    List<Integer> subList = subMap.get(level);
                    subList.add(node.val);
                    Collections.sort(subList);
                    subMap.put(level, subList);
                } else {
                    List<Integer> subList = new ArrayList<>();
                    subList.add(node.val);
                    subMap.put(level, subList);
                }
                map.put(horizontalDistance, subMap);
            } else {
                Map<Integer, List<Integer>> subMap = new TreeMap<>();
                List<Integer> subList = new ArrayList<>();
                subList.add(node.val);
                subMap.put(level, subList);
                map.put(horizontalDistance, subMap);
            }

            if (node.left != null) {
                queue.add(new Element(node.left, horizontalDistance - 1, level + 1));
            }
            if (node.right != null) {
                queue.add(new Element(node.right, horizontalDistance + 1, level + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int horizontalDistance : map.keySet()) {
            List<Integer> subAns = new ArrayList<>();
            Map<Integer, List<Integer>> subMap = map.get(horizontalDistance);
            for (int level : subMap.keySet()) {
                List<Integer> list = subMap.get(level);
                for (int i = 0; i < list.size(); i++) {
                    subAns.add(list.get(i));
                }
            }
            result.add(subAns);
        }

        return result;
    }
}