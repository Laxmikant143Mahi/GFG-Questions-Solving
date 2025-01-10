//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer> ans = new Solution().countDistinct(arr, k);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            t--;
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Add first k elements to the map
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        result.add(map.size()); // Add distinct count of first window

        // Slide the window
        for (int i = k; i < arr.length; i++) {
            // Remove the element going out of the window
            int toRemove = arr[i - k];
            map.put(toRemove, map.get(toRemove) - 1);
            if (map.get(toRemove) == 0) map.remove(toRemove);

            // Add the new element to the window
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            // Add the current distinct count to result
            result.add(map.size());
        }

        return result;
    }
}
