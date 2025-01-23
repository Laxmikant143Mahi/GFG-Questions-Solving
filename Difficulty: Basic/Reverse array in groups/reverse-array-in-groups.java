//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to reverse every sub-array group of size k
    void reverseInGroups(ArrayList<Long> arr, int k) {
        int n = arr.size();

        // Traverse the array in chunks of size k
        for (int i = 0; i < n; i += k) {
            int start = i; // Start of the group
            int end = Math.min(i + k - 1, n - 1); // End of the group, ensuring it doesn't exceed array size

            // Reverse the elements within the current group
            while (start < end) {
                long temp = arr.get(start);
                arr.set(start, arr.get(end));
                arr.set(end, temp);
                start++;
                end--;
            }
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