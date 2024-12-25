//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Using a Set to remove duplicates
            Set<Integer> uniqueElements = new LinkedHashSet<>();
            for (String token : tokens) {
                uniqueElements.add(Integer.parseInt(token));
            }

            // Converting the set to an array
            int[] arr = new int[uniqueElements.size()];
            int idx = 0;
            for (int num : uniqueElements) {
                arr[idx++] = num;
            }

            // Finding and printing subsets
            ArrayList<ArrayList<Integer>> res = new Solution().subsets(arr);
            for (ArrayList<Integer> subset : res) {
                if (subset.size() == 0) {
                    System.out.println("[]");
                } else {
                    for (int num : subset) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                }
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java




class Solution {

    // Helper function to generate all subsets
    private void generateSubsets(int[] arr, int index, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        // Add the current subset to the result
        result.add(new ArrayList<>(current));

        // Iterate through the array starting from the current index
        for (int i = index; i < arr.length; i++) {
            // Include the current element
            current.add(arr[i]);
            // Recurse with the next index
            generateSubsets(arr, i + 1, current, result);
            // Backtrack: remove the last element added
            current.remove(current.size() - 1);
        }
    }

    // Main function to return all subsets in lexicographical order
    public ArrayList<ArrayList<Integer>> subsets(int[] arr) {
        // Sort the array to ensure lexicographical order
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // Start the recursive generation of subsets
        generateSubsets(arr, 0, new ArrayList<>(), result);
        return result;
    }
}
