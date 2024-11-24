//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.maxSubarraySum(arr));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int[] arr) {
        // Initialize variables
        long max_current = arr[0];
        long max_global = arr[0];
        
        // Iterate over the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Update max_current to be the maximum of the current element itself or the sum of the current element and the previous max_current
            max_current = Math.max(arr[i], max_current + arr[i]);
            
            // Update max_global to be the maximum of max_global and max_current
            max_global = Math.max(max_global, max_current);
        }
        
        return max_global;
    }
}