// You are given an m x n integer matrix matrix with the following two properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.

// You must write a solution in O(log(m * n)) time complexity.

// Link: https://leetcode.com/problems/search-a-2d-matrix/
package Arrays.Matrix;

class SearchInMatrix {

    // Function to search for a target value in a 2D matrix
    public boolean searchMatrix(int[][] matrix, int target) {

        // Initialize pointers for the rows
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int rowMid = rowStart + (rowEnd - rowStart) / 2;

        // Binary search on rows
        while (rowStart < rowEnd) {
            // Check if the target is in the first column of the current row
            if (matrix[rowMid][0] == target) {
                return true;
            } else if (matrix[rowMid][0] < target) {
                // Check if the target is within the range of the current row
                if (target <= matrix[rowMid][matrix[0].length - 1]) {
                    break;
                } else {
                    // Adjust the rowStart pointer if the target is in a lower row
                    rowStart = rowMid + 1;
                }
            } else {
                // Adjust the rowEnd pointer if the target is in a higher row
                rowEnd = rowMid - 1;
            }
            // Update the mid pointer for the next iteration
            rowMid = rowStart + (rowEnd - rowStart) / 2;
        }

        // Initialize pointers for the columns in the selected row
        int start = 0;
        int end = matrix[0].length - 1;
        int mid = start + (end - start) / 2;

        // Binary search on columns
        while (start <= end) {
            // Check if the target is found in the selected row and column
            if (matrix[rowMid][mid] == target) {
                return true;
            } else if (matrix[rowMid][mid] < target) {
                // Adjust the start pointer if the target is in a higher column
                start = mid + 1;
            } else {
                // Adjust the end pointer if the target is in a lower column
                end = mid - 1;
            }
            // Update the mid pointer for the next iteration
            mid = start + (end - start) / 2;
        }

        // If the target is not found in the matrix, return false
        return false;
    }
}
