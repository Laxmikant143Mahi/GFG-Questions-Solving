//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java





class Solution {
    
    int merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int invCount = 0;

        int i = start, j = mid + 1, k = 0;

        // Merge process
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i + 1); // Count inversions
            }
        }

        // Copy remaining elements of left half, if any
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements of right half, if any
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        // Copy sorted temp array back to the original array
        for (i = start, k = 0; i <= end; i++, k++) {
            arr[i] = temp[k];
        }

        return invCount;
    }
    
    int mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            int leftInvCount = mergeSort(arr, start, mid);
            int rightInvCount = mergeSort(arr, mid + 1, end);
            int splitInvCount = merge(arr, start, mid, end);

            return leftInvCount + rightInvCount + splitInvCount;
        }
        return 0;
    }
    
    // Function to count inversions in the array
    static int inversionCount(int[] arr) {
        Solution solution = new Solution();
        return solution.mergeSort(arr, 0, arr.length - 1);
    }
}

