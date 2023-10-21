// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

// Example 1:

// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
// Example 2:

// Input: n = 1
// Output: [["Q"]]

// Link: https://leetcode.com/problems/n-queens/
// Solution Link: https://www.youtube.com/watch?v=9wEwqNdOAVQ&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=91

package Recursion.BackTracking.Hard;

import java.util.ArrayList;
import java.util.List;

class Solution {

    // Method to check if placing a queen at a given position is possible
    public boolean ifPossible(int n, int row, int col, List<StringBuffer> board) {
        // Check for the same row
        int x = row;
        int y = col;
        while (y >= 0) {
            if (board.get(x).charAt(y) == 'Q') {
                return false;
            }
            y--;
        }

        // Check downward diagonal
        x = row;
        y = col;
        while (x < n && y >= 0) {
            if (board.get(x).charAt(y) == 'Q') {
                return false;
            }
            x++;
            y--;
        }

        // Check upward diagonal
        x = row;
        y = col;
        while (x >= 0 && y >= 0) {
            if (board.get(x).charAt(y) == 'Q') {
                return false;
            }
            x--;
            y--;
        }

        return true;
    }

    // Recursive method to solve N-Queens problem
    public void solve(int n, int colIndex, List<StringBuffer> board, List<List<String>> result) {
        // Base case: If all queens are placed, add the current solution to the result
        if (colIndex >= n) {
            List<String> boardString = new ArrayList<>();
            for (StringBuffer rowString : board) {
                boardString.add((new StringBuffer(rowString)).toString());
            }
            result.add(boardString);
            return;
        }

        // Try placing a queen in each row of the current column
        for (int row = 0; row < n; row++) {
            if (ifPossible(n, row, colIndex, board)) {
                // Place the queen and recursively solve for the next column
                board.get(row).setCharAt(colIndex, 'Q');
                solve(n, colIndex + 1, board, result);
                // Backtrack: Remove the queen to explore other possibilities
                board.get(row).setCharAt(colIndex, '.');
            }
        }
    }

    // Main method to solve N-Queens problem
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int colIndex = 0;
        List<StringBuffer> board = new ArrayList<>();

        // Initialize a row with empty cells
        StringBuffer s = new StringBuffer();
        for (int j = 0; j < n; j++) {
            s.append('.');
        }

        // Initialize the board with empty cells
        for (int i = 0; i < n; i++) {
            board.add(new StringBuffer(s));
        }

        // Start solving the N-Queens problem
        solve(n, colIndex, board, result);

        return result;
    }
}
