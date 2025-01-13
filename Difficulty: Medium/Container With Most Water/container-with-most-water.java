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
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxWater(int[] height) {
        int start = 0; // Pointer to the first line
        int end = height.length - 1; // Pointer to the last line
        int maxWater = 0; // Variable to store the maximum area

        // Loop until the two pointers meet
        while (start < end) {
            // Calculate the area between the two lines
            int currentWater = Math.min(height[start], height[end]) * (end - start);
            // Update maxWater if the current area is larger
            maxWater = Math.max(maxWater, currentWater);

            // Move the pointer corresponding to the shorter line
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxWater;
    }
}