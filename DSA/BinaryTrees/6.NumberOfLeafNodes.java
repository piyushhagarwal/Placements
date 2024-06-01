// Link : https://www.codingninjas.com/studio/problems/count-leaf-nodes_893055
package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

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

    // By using queue
    public static int noOfLeafNodes2(BinaryTreeNode<Integer> root) {
        // Write your code here.

        if (root == null) {
            return 0;
        }

        int count = 0;

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> poppedElement = queue.poll();

            if (poppedElement.left == null && poppedElement.right == null) {
                count++;
            }

            if (poppedElement.left != null) {
                queue.add(poppedElement.left);
            }

            if (poppedElement.right != null) {
                queue.add(poppedElement.right);
            }
        }

        return count;
    }

}
