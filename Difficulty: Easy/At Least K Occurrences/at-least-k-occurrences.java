//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
public int firstElementKTime(int[] arr, int k) {
    // Create a HashMap to store the frequency of each element
    HashMap<Integer, Integer> map = new HashMap<>();
    
    // Traverse the array and update the frequency count of each element in the map
    for (int i = 0; i < arr.length; i++) {
        // Increment the count for arr[i] in the map using getOrDefault
        map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        
        // Check if the frequency of arr[i] becomes equal to or greater than k
        if (map.get(arr[i]) >= k) {
            // Return the first element that has appeared k times
            return arr[i];
        }
    }
    
    // If no element appears k times, return -1
    return -1;
}
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }
            int k = Integer.parseInt(br.readLine());

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.firstElementKTime(arr, k);

            System.out.println(res);

            // System.out.println("~");
        }
    }
}

// } Driver Code Ends