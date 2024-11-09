//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
                out.println("~");
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to count the number of ways in which a frog can reach the top.
    static int countWays(int n) {
        // Edge cases
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        // Create a dp array to store the number of ways to reach each step
        int dp[] = new int[n + 1];
        
        // Base cases
        dp[0] = 1; // 1 way to stay at the ground
        dp[1] = 1; // 1 way to jump to the first step
        dp[2] = 2; // 2 ways: (1+1) or (2)

        // Fill the dp array using the recurrence relation
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000007;
        }

        return dp[n];
    }
}
