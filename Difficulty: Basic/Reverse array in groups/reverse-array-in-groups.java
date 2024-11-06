//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to reverse every sub-array group of size k.
    void reverseInGroups(ArrayList<Long> arr, int k) {
        // Iterate over the array in steps of k
        for (int i = 0; i < arr.size(); i += k) {
            // Determine the end index of the sub-array
            int end = Math.min(i + k - 1, arr.size() - 1);
            // Reverse the sub-array from index i to end
            Collections.reverse(arr.subList(i, end + 1));
        }
    }
}

//{ Driver Code Starts.

public class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline
        while (t-- > 0) {
            int k = sc.nextInt();
            sc.nextLine(); // consume the newline
            String input = sc.nextLine();
            ArrayList<Long> arr = new ArrayList<>();
            Scanner ss = new Scanner(input);
            while (ss.hasNextLong()) {
                arr.add(ss.nextLong());
            }
            Solution ob = new Solution();
            ob.reverseInGroups(arr, k);
            for (long num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        
System.out.println("~");
}
        sc.close();
    }
}
// } Driver Code Ends