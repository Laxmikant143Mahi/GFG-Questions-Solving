//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // Initialize variables
        int currentSum = 0;
        int left = 0;
        
        // Traverse the array using the right pointer
        for (int right = 0; right < arr.length; right++) {
            // Add the current element to the current sum
            currentSum += arr[right];
            
            // If current sum exceeds the target, move the left pointer
            while (currentSum > target && left <= right) {
                currentSum -= arr[left];
                left++;
            }
            
            // If current sum equals the target, return the 1-based indices
            if (currentSum == target) {
                return new ArrayList<>(Arrays.asList(left + 1, right + 1));
            }
        }
        
        // If no subarray found, return [-1]
        return new ArrayList<>(Arrays.asList(-1));
    }
}