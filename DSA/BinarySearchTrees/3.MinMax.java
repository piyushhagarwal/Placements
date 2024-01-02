package BinarySearchTrees;

class MinMax {
    // To find the minimum element in a BST, we need to traverse the left subtree
    // until we reach the leftmost leaf.
    public int findMin(TreeNode root) {
        if (root == null) {
            return -1;
        }

        TreeNode curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }

        return curr.val;
    }

    // To find the maximum element in a BST, we need to traverse the right subtree
    // until we reach the rightmost leaf.
    public int findMax(TreeNode root) {
        if (root == null) {
            return -1;
        }

        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }

        return curr.val;
    }
}
