//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();
            // System.out.println(str.length());
            Solution ob = new Solution();
            System.out.println(ob.countPS(str));
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*You are required to complete below method */

class Solution {
    int countPS(String s) {
        int n = s.length();
        int[][] dp = new int[n][n]; // dp[i][j] stores the count of palindromic subsequences in s[i...j]
        int mod = 1_000_000_007; // To handle large results

        // Base case: single character substrings
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1; // Each single character is a palindrome
        }

        // Fill the table for substrings of length 2 to n
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1; // End index of the current substring

                if (s.charAt(i) == s.charAt(j)) {
                    // Case 1: Characters at both ends are the same
                    dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] + 1) % mod;
                } else {
                    // Case 2: Characters at both ends are different
                    dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1] + mod) % mod;
                }
            }
        }

        return dp[0][n - 1]; // The result is stored in dp[0][n-1]
    }
}
