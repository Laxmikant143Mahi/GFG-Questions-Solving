//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java



class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();

        // Early exit if pattern is longer than text
        if (m > n) {
            return result;
        }

        // Convert strings to char arrays for faster access
        char[] pattern = pat.toCharArray();
        char[] text = txt.toCharArray();

        // Step 1: Create LPS array
        int[] lps = computeLPSArray(pattern);

        // Step 2: Search for pattern in text
        int i = 0; // Index for text
        int j = 0; // Index for pattern

        while (i < n) {
            if (pattern[j] == text[i]) {
                i++;
                j++;
            }
            if (j == m) { // Match found
                result.add(i - j); // Add starting index
                j = lps[j - 1]; // Use LPS to continue searching
            } else if (i < n && pattern[j] != text[i]) {
                if (j != 0) {
                    j = lps[j - 1]; // Use LPS to avoid redundant checks
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    private int[] computeLPSArray(char[] pattern) {
        int m = pattern.length;
        int[] lps = new int[m];
        int len = 0; // Length of the previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pattern[i] == pattern[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
