//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperation(n));
                
System.out.println("~");
}
        }
}    
// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int minOperation(int n)
    {
        if (n == 0) return 0; // If n is 0, no operations are needed.
        
        int dp[] = new int[n + 1]; // Initialize dp array to size n+1.
        
        dp[0] = 0; // Base case: 0 operations to reach 0.
        dp[1] = 1; // Base case: 1 operation to reach 1.
        
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) 
                dp[i] = 1 + Math.min(dp[i / 2], dp[i - 1]);
            else 
                dp[i] = 1 + dp[i - 1];
        }
        
        return dp[n]; // Return the minimum operations to reach n.
    }
}


