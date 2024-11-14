//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int x;
            x = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            boolean res = obj.findPair(arr, x);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {
    public boolean findPair(int[] arr, int x) {
        // First, sort the array
        Arrays.sort(arr);

        int start = 0;
        int end = 1;

        // Use two pointers to find the required difference
        while (start < arr.length && end < arr.length) {
            // Calculate the difference between arr[end] and arr[start]
            int diff = arr[end] - arr[start];

            // Check if the difference matches x
            if (diff == x && start != end) {
                return true;
            } else if (diff < x) {
                // If difference is less than x, move the end pointer to increase the difference
                end++;
            } else {
                // If difference is greater than x, move the start pointer to decrease the difference
                start++;
            }
        }

        return false; // Return false if no such pair is found
    }
}
