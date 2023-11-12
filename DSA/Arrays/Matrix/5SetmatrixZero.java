// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

// You must do it in place.
// https://leetcode.com/problems/set-matrix-zeroes/description/

package Arrays.Matrix;

import java.util.ArrayList;

class SetmatrixZero {
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Store all the positions which have zeros
        ArrayList<int[]> storeZero = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    int[] pair = { i, j };
                    storeZero.add(pair);
                }
            }
        }

        // Set Rows and Coloums of the positions to zero
        for (int i = 0; i < storeZero.size(); i++) {
            int rowIndex = storeZero.get(i)[0];
            int colIndex = storeZero.get(i)[1];
            for (int j = 0; j < m; j++) {
                matrix[rowIndex][j] = 0;
            }
            for (int j = 0; j < n; j++) {
                matrix[j][colIndex] = 0;
            }
        }

        // For printing the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    // This approach is done in
    // 0(n^2) - time complexity
    // O(n) - space complexity

    public static void main(String args[]) {
        int matrix[][] = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        setZeroes(matrix);
    }

}
