//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            t--;

            System.out.println(new Solution().findsum(arr) == true ? "true" : "false");
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[]) {
        // HashMap to store the cumulative sum and its frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Initialize sum as 0 (handles case where subarray starts from index 0)
        int sum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            // Update the cumulative sum
            sum += arr[i];
            
            // If sum is 0 or if the sum has already been seen, return true
            if (sum == 0 || map.containsKey(sum)) {
                return true;
            }
            
            // Store the cumulative sum in the map
            map.put(sum, 1);
        }
        
        // If no subarray with 0 sum is found
        return false;
    }
}
