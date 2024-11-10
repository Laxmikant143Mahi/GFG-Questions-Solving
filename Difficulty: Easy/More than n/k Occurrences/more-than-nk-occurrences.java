//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            System.out.println(new Solution().countOccurence(arr, n, k));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




class Solution {
    // Function to find all elements in the array that appear more than n/k times.
    public int countOccurence(int[] arr, int n, int k) {
        // Map to store the frequency of elements
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Counting the frequency of each element
        for (int i = 0; i < n; i++) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }
        
        int count = 0;
        // Iterate over the entries in the map
        for (int key : frequencyMap.keySet()) {
            // If the frequency of the element is greater than n/k, increase the count
            if (frequencyMap.get(key) > (n / k)) {
                count++;
            }
        }
        
        return count; // Return the count of elements appearing more than n/k times
    }
}
