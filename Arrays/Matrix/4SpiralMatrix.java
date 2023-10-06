//https://leetcode.com/problems/spiral-matrix/
//Leetcode q 54
// 1 → 2 → 3 → 4   →    5
// ↑                    ↓
// 6 → 7 → 8 → 9       10
// ↑                   ↓
// 11 ← 12 ← 13 ← 14 ← 15

package Arrays.Matrix;

import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;
        int totalCount = matrix.length * matrix[0].length;
        int count = 0;
        while (count < totalCount) {
            for (int i = startCol; i <= endCol; i++) {
                ans.add(matrix[startRow][i]);
                count++;
            }
            startRow++;
            if (count >= totalCount) {
                break;
            }

            for (int i = startRow; i <= endRow; i++) {
                ans.add(matrix[i][endCol]);
                count++;
            }
            endCol--;
            if (count >= totalCount) {
                break;
            }

            for (int i = endCol; i >= startCol; i--) {
                ans.add(matrix[endRow][i]);
                count++;
            }
            endRow--;
            if (count >= totalCount) {
                break;
            }

            for (int i = endRow; i >= startRow; i--) {
                ans.add(matrix[i][startCol]);
                count++;
            }
            startCol++;
            if (count >= totalCount) {
                break;
            }

        }
        return ans;
    }

    public static void main(String args[]) {
        int arr[][] = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 } };
        List<Integer> ans = spiralOrder(arr);
        for (int num : ans) {
            System.out.println(num);
        }

    }
}
