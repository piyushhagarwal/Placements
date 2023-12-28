//Link: https://leetcode.com/problems/sudoku-solver/
// Difficulty: Hard
// Solution : https://www.youtube.com/watch?v=8lWxaRviJBA&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=92

package Recursion.BackTracking.Hard;

class Solution {

    // Check if it's possible to place 'num' at the specified position (row, col)
    public boolean isPossible(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            // Check in row
            if (board[row][i] == num) {
                return false;
            }

            // Check in column
            if (board[i][col] == num) {
                return false;
            }

            // Check if same grid
            if (board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == num) {
                return false;
            }
        }
        return true;
    }

    // Backtracking function to solve the Sudoku puzzle
    public boolean solve(char[][] board) {
        // Traverse through all the elements of the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Check if the element is empty or not
                if (board[i][j] == '.') {
                    // Put every number from '1' to '9' and check if it is capable of being in the
                    // particular cell
                    for (char num = '1'; num <= '9'; num++) {
                        if (isPossible(board, i, j, num)) {
                            board[i][j] = num;
                            // Recursively attempt to solve the rest of the puzzle
                            if (solve(board)) {
                                return true; // If a solution is found, propagate the result
                            } else {
                                // BackTrack
                                board[i][j] = '.'; // If placing 'num' doesn't lead to a solution, backtrack
                            }
                        }
                    }
                    return false; // No valid number to place at this position, backtrack
                }
            }
        }
        return true; // All cells are filled, the board is solved
    }

    // Public method to initiate the Sudoku solving process
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    // Time complexity: O(9^m) where m is the number of blanks to be filled
    // Space complexity: O(1)
}
