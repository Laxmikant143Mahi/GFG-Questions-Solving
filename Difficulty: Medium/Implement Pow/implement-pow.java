//{ Driver Code Starts
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            double b = sc.nextDouble();
            int e = sc.nextInt();
            Solution ob = new Solution();
            System.out.printf("%.5f\n", ob.power(b, e));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
   public static double fastPow(double b, int e){
        if(e==0){
            return 1.0;
        }
        
        double halfPow = fastPow(b,e/2);
        
        if(e%2==0){
            return halfPow * halfPow;
        }
        
        else{
            return b * halfPow * halfPow;
        }
    }
    
    double power(double b, int e) {
        // code here
        
   if(e==0){
       return 1.0;
   }
   
   if(e<0){
       b = 1/b;
       e=-e;
   }
   
   return fastPow(b,e);
}
}


//{ Driver Code Starts.
// } Driver Code Ends