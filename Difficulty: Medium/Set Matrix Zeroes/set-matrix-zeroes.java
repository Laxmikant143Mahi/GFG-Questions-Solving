//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            new Solution().setMatrixZeroes(arr);
            for (int[] row : arr) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    public void setMatrixZeroes(int[][] mat) {
        
         int n = mat.length, m = mat[0].length;

        // Flags to track if the first row and first column need to be zeroed
        boolean rowZero = false, colZero = false;

        // Check if the first row or first column has any zero
        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 0) colZero = true;
        }
        for (int j = 0; j < m; j++) {
            if (mat[0][j] == 0) rowZero = true;
        }

        // Use the first row and column to mark zero rows and columns
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0; // Mark row
                    mat[0][j] = 0; // Mark column
                }
            }
        }

        // Set matrix elements to zero based on markers in the first row/column
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        // Zero out the first row if needed
        if (rowZero) {
            for (int j = 0; j < m; j++) {
                mat[0][j] = 0;
            }
        }

        // Zero out the first column if needed
        if (colZero) {
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }
    }
}