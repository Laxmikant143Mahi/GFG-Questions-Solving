//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline
        for (int tc = 0; tc < t; tc++) {
            String[] greedStr = sc.nextLine().split(" ");
            String[] cookieStr = sc.nextLine().split(" ");

            int[] greed = Arrays.stream(greedStr).mapToInt(Integer::parseInt).toArray();
            int[] cookie =
                Arrays.stream(cookieStr).mapToInt(Integer::parseInt).toArray();

            Solution obj = new Solution();
            System.out.println(obj.maxChildren(greed, cookie));
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends



class Solution {
    public int maxChildren(int[] greed, int[] cookies) {
        // Your code goes here.
        // Sort both the greed factor of the children and the size of the cookies
        Arrays.sort(greed);
        Arrays.sort(cookies);

        // Initialize variables to keep track of the index for greed array and the count of content children
        int j = 0, count = 0;

        // Iterate through each cookie while we have children left to satisfy
        for (int i = 0; i < cookies.length && j < greed.length; i++) {
            // If the current cookie can satisfy the current child's greed factor
            if (cookies[i] >= greed[j]) {
                count++; // Increment the count of content children
                j++;     // Move to the next child
            }
        }

        // Return the total number of content children
        return count;
    }
}