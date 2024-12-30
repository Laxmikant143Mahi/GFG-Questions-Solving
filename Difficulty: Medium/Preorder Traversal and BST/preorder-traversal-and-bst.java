//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.canRepresentBST(arr, N));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
     static void BST(int arr[], int index[], int lower, int upper, int n){
        
        //Base condition
        if(index[0] ==n || arr[index[0]] < lower || arr[index[0]] > upper){
            return;
        }
        
        
        int val = arr[index[0]++];
        
        //left side 
        
        BST(arr,index,lower,val, n);
        //right side
        
        BST(arr,index,val,upper,n);
    }
    
    static int canRepresentBST(int arr[], int N) {
        // code here
        
        int index[] = {0};
        
        BST(arr, index, Integer.MIN_VALUE, Integer.MAX_VALUE, N);
        
        if (index[0] == N) return 1;
        else return 0;
    }
}