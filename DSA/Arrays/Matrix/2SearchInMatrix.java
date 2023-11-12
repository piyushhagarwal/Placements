// You are given an m x n integer matrix matrix with the following two properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.

// You must write a solution in O(log(m * n)) time complexity.

package Arrays.Matrix;

class SearchInMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int rowMid = rowStart + (rowEnd - rowStart) / 2;
        while (rowStart < rowEnd) {
            if (matrix[rowMid][0] == target) {
                return true;
            } else if (matrix[rowMid][0] < target) {
                if (target <= matrix[rowMid][matrix[0].length - 1]) {
                    break;
                } else {
                    rowStart = rowMid + 1;
                }

            } else {
                rowEnd = rowMid - 1;
            }
            rowMid = rowStart + (rowEnd - rowStart) / 2;
        }

        int start = 0;
        int end = matrix[0].length - 1;
        int mid = start + (end - start) / 2;
        while (start <= end) {
            if (matrix[rowMid][mid] == target) {
                return true;
            } else if (matrix[rowMid][mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        return false;

    }
}
