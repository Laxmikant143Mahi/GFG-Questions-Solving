//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[(int)(n)];
            for (int i = 0; i < n; i++) {
                arr[i] = (int)(Long.parseLong(inputLine[i]));
            }

            Solution obj = new Solution();
            int[] product = obj.minAnd2ndMin(arr);
            if (product[0] == -1)
                System.out.println(product[0]);
            else
                System.out.println(product[0] + " " + product[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] minAnd2ndMin(int arr[]) {
        // If the array has fewer than 2 elements, we cannot find the smallest and second smallest
        if (arr.length < 2) {
            return new int[]{-1, -1}; // Return -1 for both if not enough elements
        }

        // Initialize 'small' and 'second' to maximum possible values
        int small = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        // First loop to find the smallest element
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < small) {
                second = small; // Update 'second' to the previous 'small'
                small = arr[i]; // Update 'small' to the new smallest value
            } else if (arr[i] > small && arr[i] < second) {
                second = arr[i]; // Update 'second' if arr[i] is greater than 'small' and less than 'second'
            }
        }

        // If 'second' was not updated, there is no valid second smallest element
        if (second == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        return new int[]{small, second};
    }
}

