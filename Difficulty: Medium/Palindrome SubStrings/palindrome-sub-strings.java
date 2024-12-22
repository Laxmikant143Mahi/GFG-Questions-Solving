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

            System.out.println(obj.CountPs(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int CountPs(String s) {
        // code here
        
        int n = s.length();
        int count=0;
        
        int dp[][] = new int[n][n];
        
        for(int i=0; i<n; i++){
            
            dp[i][i] = 1;
            count++;
        }
        
        
        for(int i=0; i<n-1; i++){
            
           if (s.charAt(i) == s.charAt(i + 1)) { // Check if two consecutive characters are the same
                dp[i][i + 1] = 1; // Mark this substring as a palindrome
                count++; // Increment the count
            }
        }
        
        
        for(int len = 3; len<=n; len++){
            
            for(int i=0; i<=n-len; i++){
                
                int j = i+len-1;
                
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1){
                    dp[i][j] = 1;
                    count++;
                }
            }
        }
        return count-n;
    }
}