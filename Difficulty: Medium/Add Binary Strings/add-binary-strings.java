//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public String addBinary(String s1, String s2) {
        // Remove leading zeros from both binary strings
        s1 = s1.replaceFirst("^0+", "");
        s2 = s2.replaceFirst("^0+", "");

        StringBuilder result = new StringBuilder();
        int i = s1.length() - 1; // Pointer for s1
        int j = s2.length() - 1; // Pointer for s2
        int carry = 0; // Initial carry is 0

        while (i >= 0 || j >= 0 || carry > 0) {
            int bit1 = i >= 0 ? s1.charAt(i) - '0' : 0; // Get bit from s1 or 0
            int bit2 = j >= 0 ? s2.charAt(j) - '0' : 0; // Get bit from s2 or 0

            int sum = bit1 + bit2 + carry; // Add the two bits and carry
            result.append(sum % 2); // Append the current bit to the result
            carry = sum / 2; // Update carry

            i--; // Move to the next bit in s1
            j--; // Move to the next bit in s2
        }

        return result.reverse().toString(); // Reverse the result and return
    }
}
