//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline character

        while (t-- > 0) {
            String input = sc.nextLine();

            // Replace ][ with ],[
            input = input.replace("][", "],[");

            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            String[] rows = input.split("],\\s*\\[");

            for (String row : rows) {
                row = row.replaceAll("[\\[\\]]", ""); // Remove any surrounding brackets
                ArrayList<Integer> intRow = new ArrayList<>();
                for (String num : row.split(",")) {
                    intRow.add(Integer.parseInt(num.trim()));
                }
                mat.add(intRow);
            }

            Solution obj = new Solution();
            ArrayList<String> result = obj.findPath(mat);

            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (String res : result) {
                    System.out.print(res + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Helper function to explore all paths
    public void helper(ArrayList<ArrayList<Integer>> mat, int row, int col, String path, ArrayList<String> ans, boolean[][] visited) {
        int n = mat.size();

        // Boundary conditions and visited check
        if (row < 0 || col < 0 || row >= n || col >= n || visited[row][col] || mat.get(row).get(col) == 0) {
            return;
        }

        // If the destination is reached
        if (row == n - 1 && col == n - 1) {
            ans.add(path);
            return;
        }

        // Mark the cell as visited
        visited[row][col] = true;

        // Explore all possible directions in lexicographical order
        helper(mat, row + 1, col, path + "D", ans, visited); // Down
        helper(mat, row, col - 1, path + "L", ans, visited); // Left
        helper(mat, row, col + 1, path + "R", ans, visited); // Right
        helper(mat, row - 1, col, path + "U", ans, visited); // Up

        // Backtrack and unmark the cell
        visited[row][col] = false;
    }

    // Main function to find all paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        ArrayList<String> ans = new ArrayList<>();
        int n = mat.size();

        // Edge case: If the starting cell or destination cell is blocked
        if (mat.get(0).get(0) == 0 || mat.get(n - 1).get(n - 1) == 0) {
            return ans;
        }

        // Create the visited matrix
        boolean[][] visited = new boolean[n][n];

        // Initialize the path and start exploring
        String path = "";
        helper(mat, 0, 0, path, ans, visited);

        // Sort the paths lexicographically to meet problem requirements
        Collections.sort(ans);

        return ans;
    }
}
