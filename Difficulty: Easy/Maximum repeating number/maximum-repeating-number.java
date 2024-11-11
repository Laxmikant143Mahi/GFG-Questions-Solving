//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

import java.util.HashMap;
import java.util.Map;

class Solution {
    int maxRepeating(int k, int[] arr) {
        // Create a HashMap to store the frequency of each element
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count the frequency of each element in the array
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int minElement = Integer.MAX_VALUE;
        int maxFreq = -1;

        // Find the maximum frequency
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                minElement = entry.getKey();
            } else if (entry.getValue() == maxFreq) {
                minElement = Math.min(minElement, entry.getKey());
            }
        }

        return minElement;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
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
            int res = obj.maxRepeating(k, arr);

            System.out.println(res);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends