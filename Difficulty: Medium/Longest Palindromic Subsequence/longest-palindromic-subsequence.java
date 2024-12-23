//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.longestPalinSubseq(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestPalinSubseq(String s) {
        // code here
        
         int n = s.length();
        int[][] dp = new int[n][n]; // dp[i][j] will store the length of the longest palindromic subsequence in s[i...j]

        // Base case: single character substrings
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill the table for substrings of length 2 to n
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1; // End index of the current substring
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2; // Characters match
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]); // Characters do not match
                }
            }
        }

        return dp[0][n - 1]; // The result is stored in dp[0][n-1]
    }
}