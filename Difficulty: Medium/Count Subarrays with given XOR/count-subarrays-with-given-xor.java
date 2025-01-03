//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int arr[], int k) {
        int n = arr.length; // Size of the given array
        int xr = 0; // Variable to store prefix XOR
        Map<Integer, Integer> mpp = new HashMap<>(); // Declaring the map
        mpp.put(xr, 1); // Initializing the map with 0 as prefix XOR
        long cnt = 0; // Count of subarrays with XOR equal to k

        for (int i = 0; i < n; i++) {
            // Calculate prefix XOR till index i
            xr = xr ^ arr[i];

            // Using the formula x = xr ^ k
            int x = xr ^ k;

            // Add the occurrences of xr ^ k to the count
            if (mpp.containsKey(x)) {
                cnt += mpp.get(x);
            }

            // Insert the prefix XOR till index i into the map
            mpp.put(xr, mpp.getOrDefault(xr, 0) + 1);
        }

        return cnt; // Return the count of subarrays
    }
}
