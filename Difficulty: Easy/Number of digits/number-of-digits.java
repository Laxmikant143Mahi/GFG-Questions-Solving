//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.noOfDigits(N));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {

    // Function to calculate the number of digits in the N-th Fibonacci number
    static long noOfDigits(int N) {
        if (N == 0) return 1; // F(0) = 0, which has 1 digit
        if (N == 1) return 1; // F(1) = 1, which has 1 digit

        // Constants
        double phi = (1 + Math.sqrt(5)) / 2; // Golden ratio
        double log10_phi = Math.log10(phi);
        double log10_sqrt5 = Math.log10(Math.sqrt(5));

        // Calculate the number of digits using the formula
        double digits = N * log10_phi - log10_sqrt5;
        return (long) Math.floor(digits) + 1;
    }
}
