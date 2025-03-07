//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
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

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().search(arr, key));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class Solution {
    int search(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the key
            if (arr[mid] == key) {
                return mid;
            }

            // Determine if the left half is sorted
            if (arr[left] <= arr[mid]) {
                // If the key lies in the sorted left half
                if (key >= arr[left] && key < arr[mid]) {
                    right = mid - 1;
                } else { // Otherwise, search in the right half
                    left = mid + 1;
                }
            } 
            // If the right half is sorted
            else {
                // If the key lies in the sorted right half
                if (key > arr[mid] && key <= arr[right]) {
                    left = mid + 1;
                } else { // Otherwise, search in the left half
                    right = mid - 1;
                }
            }
        }

        // If the key is not found, return -1
        return -1;
    }
}