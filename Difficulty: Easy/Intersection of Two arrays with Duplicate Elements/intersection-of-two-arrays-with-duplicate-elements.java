//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution sol = new Solution();
            ArrayList<Integer> res = sol.intersectionWithDuplicates(a, b);

            // Sort the result
            Collections.sort(res);

            // Print the result
            if (res.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int num : res) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // Create a map to store the frequency of elements in the first array
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Fill the map with frequencies of elements from array 'a'
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        
        // Create a set (via list) to store unique intersection results
        ArrayList<Integer> result = new ArrayList<>();
        
        // Traverse the second array 'b'
        for (int i = 0; i < b.length; i++) {
            // If the element is present in the map, add it to the result
            if (map.containsKey(b[i])) {
                result.add(b[i]); // Add the element once
                map.remove(b[i]); // Remove to ensure the element is only added once
            }
        }
        
        // Sort the result in ascending order
        Collections.sort(result);
        
        return result;
    }
}
