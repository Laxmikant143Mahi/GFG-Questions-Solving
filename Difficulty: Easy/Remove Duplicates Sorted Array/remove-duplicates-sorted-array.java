//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            ArrayList<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            Solution ob = new Solution();
            int ans = ob.remove_duplicate(arr);
            for (int i = 0; i < ans; i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
        
System.out.println("~");
}
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java




class Solution {
    // Function to remove duplicates from the given array
    public int remove_duplicate(List<Integer> arr) {
        // Edge case: empty list or single-element list
        if (arr == null || arr.size() <= 1) {
            return arr.size();
        }
        
        // Pointer i to track the unique elements position
        int i = 0;

        // Start checking from the second element
        for (int j = 1; j < arr.size(); j++) {
            // If current element is different from arr[i], it's unique
            if (!arr.get(i).equals(arr.get(j))) {
                i++;  // Move i to next position for unique element
                arr.set(i, arr.get(j));  // Move the unique element to position i
            }
        }
        
        // The length of the array with unique elements is i+1
        return i + 1;
    }
}
