//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String St[] = read.readLine().split(" ");
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);

            Solution ob = new Solution();
            System.out.println(ob.maximizeMoney(N,K));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int maximizeMoney(int N , int K) {
        // code here
        
        int sum = 0;
        
        for(int i=0; i<N; i++){
            
            sum+=K;
            i++;
        }
        return sum;
    }
};