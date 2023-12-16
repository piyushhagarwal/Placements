// Link : https://www.codingninjas.com/studio/problems/count-leaf-nodes_893055
package BinaryTrees;

// Following is the Binary Tree Node class structure.
class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

class NumberOfLeafNodes {
    public static int noOfLeafNodes(BinaryTreeNode<Integer> root) {
        // Write your code here.

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return noOfLeafNodes(root.left) + noOfLeafNodes(root.right);
    }
}
