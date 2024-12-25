//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java


class Solution {
    // Helper function to check if a queen can be safely placed at (row, col)
    public boolean isSafe(int[] board, int row, int col) {
        // Check vertical and diagonals
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    // Helper function to solve the N-Queens problem using backtracking
    public void solveNQueens(int n, int row, int[] board, ArrayList<ArrayList<Integer>> result) {
        // If all queens are placed
        if (row == n) {
            ArrayList<Integer> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(board[i] + 1); // Add 1-based column index
            }
            result.add(solution); // Add the current valid configuration
            return;
        }

        // Try placing the queen in all columns of the current row
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row] = col; // Place queen in the current column
                solveNQueens(n, row + 1, board, result); // Recur for next row
                board[row] = -1; // Backtrack
            }
        }
    }

    // Main function to return all solutions to the N-Queens problem
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] board = new int[n]; // board[i] represents the column of the queen in row i
        Arrays.fill(board, -1); // Initialize the board (no queen placed)

        // Start the backtracking process from the first row
        solveNQueens(n, 0, board, result);
        return result;
    }
}
