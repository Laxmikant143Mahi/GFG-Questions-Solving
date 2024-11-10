//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    int countTriplet(int[] arr) {
        int n = arr.length;
        int count = 0;
        
        // Sort the array to use two-pointer approach
        Arrays.sort(arr);
        
        // Iterate from the end of the array, treating arr[k] as the potential sum
        for (int k = n - 1; k >= 2; k--) {
            int i = 0; // Pointer starting from the beginning
            int j = k - 1; // Pointer starting from the element before k
            
            // Use two-pointer technique to find pairs that sum to arr[k]
            while (i < j) {
                if (arr[i] + arr[j] == arr[k]) {
                    count++; // Found a valid triplet
                    i++; // Move both pointers to continue searching
                    j--;
                } else if (arr[i] + arr[j] < arr[k]) {
                    i++; // Increase the sum by moving the left pointer
                } else {
                    j--; // Decrease the sum by moving the right pointer
                }
            }
        }
        
        return count; // Return the total number of triplets found
    }
}




//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
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
            int res = obj.countTriplet(arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends