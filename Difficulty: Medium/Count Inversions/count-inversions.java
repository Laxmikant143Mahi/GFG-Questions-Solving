//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java



class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int[] arr) {
        int n = arr.length;
        
        // Step 1: Normalize the array elements to a smaller range
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        
        // Create a map to normalize values
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(sorted[i], i + 1); // Fenwick Tree is 1-indexed
        }
        
        // Step 2: Fenwick Tree for counting inversions
        int[] fenwick = new int[n + 1]; // Fenwick Tree of size n+1
        int inversionCount = 0;
        
        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Query the Fenwick Tree for the count of elements < arr[i]
            inversionCount += query(fenwick, map.get(arr[i]) - 1);
            // Update the Fenwick Tree with the current element
            update(fenwick, map.get(arr[i]), 1, n);
        }
        
        return inversionCount;
    }
    
    // Function to update the Fenwick Tree
    private static void update(int[] fenwick, int index, int value, int n) {
        while (index <= n) {
            fenwick[index] += value;
            index += index & -index; // Move to the next position
        }
    }
    
    // Function to query the Fenwick Tree for the prefix sum up to a given index
    private static int query(int[] fenwick, int index) {
        int sum = 0;
        while (index > 0) {
            sum += fenwick[index];
            index -= index & -index; // Move to the parent node
        }
        return sum;
    }
}
