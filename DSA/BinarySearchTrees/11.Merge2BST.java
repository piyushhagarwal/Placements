// Given two BSTs, return elements of both BSTs in sorted form.

// Example 1:

// Input:
// BST1:
//        5
//      /   \
//     3     6
//    / \
//   2   4  
// BST2:
//         2
//       /   \
//      1     3
//             \
//              7
//             /
//            6
// Output: 1 2 2 3 3 4 5 6 6 7
// Explanation: 
// After merging and sorting the
// two BST we get 1 2 2 3 3 4 5 6 6 7.
// Example 2:

// Input:
// BST1:
//        12
//      /   
//     9
//    / \    
//   6   11
// BST2:
//       8
//     /  \
//    5    10
//   /
//  2
// Output: 2 5 6 8 9 10 11 12
// Explanation: 
// After merging and sorting the
// two BST we get 2 5 6 8 9 10 11 12.

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function merge() which takes roots of both the BSTs as its input and returns an array of integers denoting the node values of both the BSTs in a sorted order.

// Expected Time Complexity: O(M+N) where M and N are the sizes of the two BSTs.
// Expected Auxiliary Space: O(Height of BST1 + Height of BST2 + M + N(for storing the answer)).

// Link : https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1#
// Solution : https://www.youtube.com/watch?v=18w8VduomfI&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=78

package BinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {
    public void inorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    public void mergeSortedArrs(List<Integer> list1, List<Integer> list2, List<Integer> combinedList) {
        int i = 0;
        int j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                combinedList.add(list1.get(i));
                i++;
            } else {
                combinedList.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            combinedList.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            combinedList.add(list2.get(j));
            j++;
        }
    }

    // Function to return a list of integers denoting the node
    // values of both the BST in a sorted order.
    public List<Integer> merge(Node root1, Node root2) {
        // Write your code here
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inorder(root1, list1);
        inorder(root2, list2);

        List<Integer> combinedList = new ArrayList<>();

        // Merge 2 sorted arrays
        mergeSortedArrs(list1, list2, combinedList);

        return combinedList;

        // If you want to return the node itself, then you can construct a BST from the
        // inorder traversal of the combinedList (Similar to 10.BalanceBST.java)
    }
}