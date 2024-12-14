//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            // calling method findMaxSum() of class solve
            System.out.println(new Solution().findMaxSum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the maximum money the thief can get.
    public int findMaxSum(int nums[]) {
        // Your code here
        
        
        // Get the length of the input array.
        int n = nums.length;

        // If there is only one house, return the amount in that house as no other option exists.
        if(n == 1) return nums[0];

        // Initialize a dp array where dp[i] will store the maximum amount that can be robbed up to the i-th house.
        int dp[] = new int[n];

        // Base case: The maximum money that can be robbed from the first house is the money in the first house.
        dp[0] = nums[0];
        
        // Base case: The maximum money that can be robbed from the first two houses is the maximum of either the first or second house.
        dp[1] = Math.max(nums[0], nums[1]);

        // Fill the dp array starting from the third house (index 2) to the last house.
        for(int i = 2; i < n; i++) {
            // For each house, we have two choices:
            // 1. Rob this house (nums[i]) and add it to the maximum money robbed from two houses before (dp[i-2]).
            // 2. Skip this house and keep the maximum amount robbed up to the previous house (dp[i-1]).
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        // The last element in dp represents the maximum amount that can be robbed from all the houses.
        return dp[n-1];
    }
}