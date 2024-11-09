//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; ++i) arr[i] = sc.nextInt();

            System.out.println(new Sol().search(n, arr));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Sol {
    public static int search(int n, int[] arr) {
        int start = 0, end = arr.length - 1;
        
        // Use binary search to find the single element
        while (start < end) {
            int mid = start + (end - start) / 2;
            
            // Check if mid is the unique element
            if ((mid == 0 || arr[mid] != arr[mid - 1]) && (mid == n - 1 || arr[mid] != arr[mid + 1])) {
                return arr[mid];
            }
            
            // Check how to move the search space
            // If mid is even and the next element is the same, the single element is on the right
            // If mid is odd and the previous element is the same, the single element is on the right
            if ((mid % 2 == 0 && arr[mid] == arr[mid + 1]) || (mid % 2 == 1 && arr[mid] == arr[mid - 1])) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        // When start == end, we've found the unique element
        return arr[start];
    }
}
