//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(br.readLine().trim());

        while (test_cases-- > 0) {
            // Read the array from input line
            String[] input = br.readLine().trim().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            // Solution instance to invoke the function
            Solution ob = new Solution();
            int result = ob.hIndex(arr);

            System.out.println(result);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to find hIndex
    public int hIndex(int[] a) {
    
        int n = a.length;
        int freq[] = new int[n+1];
        
        for(int i = 0;i<n;i++){
            if(a[i]>=n)
            freq[n]++;
            else{
                freq[a[i]]++;
            }
        }
        
        int i = freq.length-1;
        int j =1;
        int sum =0;
        
        while(j<=freq.length){
            sum+=freq[i];
            if(sum>=i){
               return i;
            }
           
            j++;
            i--;
        }
        return -1;
    }
}