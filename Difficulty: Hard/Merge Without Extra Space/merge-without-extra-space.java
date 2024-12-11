//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

        while (t-- > 0) {
            String arr1[] = br.readLine().trim().split(" ");
            String arr2[] = br.readLine().trim().split(" ");

            int a[] = new int[arr1.length];
            int b[] = new int[arr2.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(arr1[i]);
            for (int i = 0; i < b.length; i++) b[i] = Integer.parseInt(arr2[i]);

            Solution ob = new Solution();
            ob.mergeArrays(a, b);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < a.length; i++) {
                str.append(a[i] + " ");
            }
            System.out.println(str);
            str = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                str.append(b[i] + " ");
            }
            System.out.println(str);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to merge two arrays.
    public void mergeArrays(int arr1[], int arr2[]) {
        int n = arr1.length; // Length of the first array
        int m = arr2.length; // Length of the second array

        int i = n - 1; // Pointer for the last element of arr1
        int j = 0;     // Pointer for the first element of arr2

        // Traverse from the end of arr1 and the beginning of arr2.
        while (i >= 0 && j < m) {
            if (arr1[i] > arr2[j]) {
                // Swap elements if arr1[i] is greater than arr2[j].
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                i--;
                j++;
            } else {
                // Break if arr1[i] is already smaller or equal to arr2[j].
                break;
            }
        }

        // Sort both arrays after swapping.
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}