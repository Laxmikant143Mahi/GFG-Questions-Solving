//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java



class Solution {
    public int longestUniqueSubstr(String s) {
        // HashMap to store the last index of each character
        HashMap<Character, Integer> lastIndexMap = new HashMap<>();
        int max = 0, start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the character is already in the map and is within the current window,
            // move the start pointer to exclude its previous occurrence
            if (lastIndexMap.containsKey(currentChar) && lastIndexMap.get(currentChar) >= start) {
                start = lastIndexMap.get(currentChar) + 1;
            }

            // Update the character's last index in the map
            lastIndexMap.put(currentChar, end);

            // Calculate the length of the current unique substring
            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
