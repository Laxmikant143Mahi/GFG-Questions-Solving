//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String S = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends





//User function Template for Java

class Solution {
    static int maxLength(String S) {
        int maxLength = 0;  // To store the maximum length of valid parentheses
        Stack<Integer> stack = new Stack<>();  // Stack to track indices
        stack.push(-1);  // Initialize with -1 to handle valid parentheses starting from index 0

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push(i);  // Push the index of the opening bracket
            } else {
                stack.pop();  // Pop for the closing bracket
                if (stack.isEmpty()) {
                    stack.push(i);  // Push the current index as a base for future valid parentheses
                } else {
                    // Calculate the length of the valid parentheses substring
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;  // Return the longest valid parentheses length
    }
}