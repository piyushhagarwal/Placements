// Link : https://leetcode.com/problems/search-a-2d-matrix-ii/description/

//solution : https://www.youtube.com/watch?v=9ZbB397jU4k

package Arrays.Matrix;

class SearchMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        int row = 0;
        int col = colSize - 1; // start from top right corner

        while (row < rowSize && col >= 0) { // while we are in the matrix
            if (matrix[row][col] == target) { // if we found the target
                return true;
            } else if (matrix[row][col] > target) { // if the target is smaller than the current element
                col--; // move left
            } else { // if the target is larger than the current element
                row++; // move down
            }
        }

        return false; // if we reach here, it means we didn't find the target

    }
}
