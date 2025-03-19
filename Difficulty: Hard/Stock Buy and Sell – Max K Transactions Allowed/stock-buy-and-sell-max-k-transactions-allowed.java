//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String[] input = br.readLine().split(" ");
            int arr[] = new int[input.length];

            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(input[i]);

            // Read the integer k
            int k = Integer.parseInt(br.readLine());

            // Call the solution function
            Solution obj = new Solution();
            System.out.println(obj.maxProfit(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int help(int[] p , int k ,int i , int b , int[][][] dp){
        if(i==p.length || k==0){
            return 0;
        }
        
        if(dp[i][k][b]!=-1){
            return dp[i][k][b];
        }
        int ans =help(p,k,i+1,b,dp);
        if(b==1){
            ans = Math.max(ans , help(p,k,i+1,0,dp)-p[i] );
        }
        else{
            ans = Math.max(ans , help(p,k-1,i+1,1,dp) + p[i]);
        }
        
        return dp[i][k][b] = ans;
    }
    static int maxProfit(int p[], int k) {
        // code here
        int[][][] dp = new int[p.length][k+1][2];
        
        for(int i=0; i<dp.length ; i++){
            for(int j=0 ; j<dp[0].length ; j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }
        return help(p,k,0,1,dp);
    }
}